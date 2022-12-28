package com.sesami.sesamiassignment.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
@Data
public class Appointment {
    @Id
    private Integer id;

    private Date start;
    private Date end;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date UpdatedAt;
}
