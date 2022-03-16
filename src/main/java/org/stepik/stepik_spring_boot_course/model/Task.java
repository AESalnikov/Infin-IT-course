package org.stepik.stepik_spring_boot_course.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private String description;

    private boolean done;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

}
