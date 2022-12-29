package com.sesami.sesamiassignment.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
public class AppointmentDto {
    private int id;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    @NotNull(message = "Start date and time is mandatory")
    private Date start;
    @NotNull(message = "End date and time is mandatory")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Date end;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createdAt;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateAt;
}
