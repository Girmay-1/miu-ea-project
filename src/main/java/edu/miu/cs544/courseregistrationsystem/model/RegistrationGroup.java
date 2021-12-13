package edu.miu.cs544.courseregistrationsystem.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class RegistrationGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Student> students = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER)
    private List<AcademicBlock> academicBlocks = new ArrayList<>();

}
