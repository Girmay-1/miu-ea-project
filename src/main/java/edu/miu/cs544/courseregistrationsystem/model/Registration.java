package edu.miu.cs544.courseregistrationsystem.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "course_offering_id")
    private CourseOffering courseOffering;
}
