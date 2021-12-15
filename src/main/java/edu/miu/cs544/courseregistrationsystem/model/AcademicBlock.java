package edu.miu.cs544.courseregistrationsystem.model;

import edu.miu.cs544.courseregistrationsystem.model.util.Semester;
import lombok.Data;
import lombok.ToString;

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

//    @ToString.Exclude
//    @OneToMany(mappedBy = "academicBlock", fetch = FetchType.LAZY,
//			cascade = CascadeType.ALL)
@OneToMany(fetch = FetchType.EAGER)
    private List<CourseOffering> courseOfferings = new ArrayList<>();

}
