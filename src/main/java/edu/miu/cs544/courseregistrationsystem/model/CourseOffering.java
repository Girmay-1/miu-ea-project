package edu.miu.cs544.courseregistrationsystem.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
public class CourseOffering {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private int capacity;

    private int  availableSeats;

    private String code;

    @ManyToOne
    private Faculty faculty;

    @ManyToOne
    private AcademicBlock academicBlock;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "courseOffering")
    private List<Registration> registrations = new ArrayList<>();

}
