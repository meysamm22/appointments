package com.sesami.sesamiassignment.Model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "Start date and time is mandatory")
    private Date start;
    @NotNull(message = "End date and time is mandatory")
    private Date end;

    private Date createdAt;

    private Date UpdatedAt;

    @Version
    private Long version;
}
