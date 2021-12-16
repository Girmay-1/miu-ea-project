package edu.miu.cs544.courseregistrationsystem.model;

import lombok.Data;
import lombok.ToString;

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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="faculty_id",  nullable = false)
    private Faculty faculty;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name="academic_block_id", nullable = false)
//    private AcademicBlock academicBlock;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="course_id",  nullable = false)
    private Course course;

    @OneToMany(mappedBy = "courseOffering", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Registration> registrations = new ArrayList<>();

    @OneToMany(mappedBy = "courseOffering", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<RegistrationRequest> registrationRequests= new ArrayList<>();


}
