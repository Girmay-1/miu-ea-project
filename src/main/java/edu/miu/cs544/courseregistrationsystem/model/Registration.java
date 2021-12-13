package edu.miu.cs544.courseregistrationsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Registration {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;


}
