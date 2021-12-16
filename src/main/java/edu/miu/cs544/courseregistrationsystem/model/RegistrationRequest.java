package edu.miu.cs544.courseregistrationsystem.model;

import lombok.Data;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class RegistrationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private int priorityNumber;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "student_id")
    private Student student;
    
    @ManyToOne
    private AcademicBlock block;

    @ManyToOne
//    @JsonProperty(value = "courseOffering")
    @JoinColumn(name = "courseOffering_id")
    @JsonIgnore
    private CourseOffering courseOffering;

    @OneToMany(fetch = FetchType.LAZY)
    private List<RegistrationGroup> registrationGroups = new ArrayList<>();
}
