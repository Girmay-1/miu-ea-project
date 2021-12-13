package edu.miu.cs544.courseregistrationsystem.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Student {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

}
