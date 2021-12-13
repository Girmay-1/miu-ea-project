package edu.miu.cs544.courseregistrationsystem.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String code;

    @Column
    private String name;

    @Column(name = "Description", length = 1024)
    private String description;
}
