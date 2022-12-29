package com.sesami.sesamiassignment.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table
@Data @AllArgsConstructor @NoArgsConstructor
public class Appointment {
    @Id
    private Integer id;

    @NotNull(message = "Start date and time is mandatory")
    private Date start;
    @NotNull(message = "End date and time is mandatory")
    private Date end;

    private Date createdAt;

    private Date UpdatedAt;
}
