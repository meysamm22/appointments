package com.sesami.sesamiassignment;

import com.sesami.sesamiassignment.Dto.ValidationError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

@Slf4j
@ControllerAdvice
@RestController
public class ExceptionController {

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(ConstraintViolationException.class)
    public List<ValidationError>
    handleConstraintViolation(ConstraintViolationException ex) {
        log.debug(
                "Constraint violation exception encountered: {}",
                ex.getConstraintViolations(),
                ex
        );
        return buildValidationErrors(ex.getConstraintViolations());
    }


    private List<ValidationError> buildValidationErrors(
            Set<ConstraintViolation<?>> violations) {
        return violations.
                stream().
                map(violation ->
                        ValidationError.builder().
                                field(
                                        StreamSupport.stream(
                                                        violation.getPropertyPath().spliterator(), false).
                                                reduce((first, second) -> second).
                                                orElse(null).
                                                toString()
                                ).
                                error(violation.getMessage()).
                                build()).
                collect(toList());
    }
}