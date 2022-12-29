package com.sesami.sesamiassignment.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
public class AppointmentDto {
    private int id;
    private Date start;
    private Date end;
    private Date createdAt;
    private Date updateAt;
}
