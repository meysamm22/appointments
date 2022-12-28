package com.sesami.sesamiassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SesamiAssignmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(SesamiAssignmentApplication.class, args);
    }

}
