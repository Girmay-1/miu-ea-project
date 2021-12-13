package edu.miu.cs544.courseregistrationsystem.model;

import edu.miu.cs544.courseregistrationsystem.model.util.Semester;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

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
}
