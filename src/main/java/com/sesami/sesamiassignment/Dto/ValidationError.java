package com.sesami.sesamiassignment.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data @AllArgsConstructor @Builder
public class ValidationError {
    private String field;
    private String error;
}
