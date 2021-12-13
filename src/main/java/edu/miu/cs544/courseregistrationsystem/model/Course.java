package edu.miu.cs544.courseregistrationsystem.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Course {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String code;

    @Column
    private String name;

    @Column(name = "Description", length = 1024)
    private String description;
}
