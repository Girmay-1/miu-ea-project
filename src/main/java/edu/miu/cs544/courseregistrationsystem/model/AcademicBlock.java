package edu.miu.cs544.courseregistrationsystem.model;

import edu.miu.cs544.courseregistrationsystem.model.util.Semester;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class AcademicBlock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String code;

    private String name;

    private Semester semester;

    private LocalDate startDate;

    private LocalDate endDate;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "academicBlock_id")
    private List<CourseOffering> courseOfferings = new ArrayList<>();

}
