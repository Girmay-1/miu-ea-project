package edu.miu.cs544.courseregistrationsystem.model.dto;

import edu.miu.cs544.courseregistrationsystem.model.AcademicBlock;
import edu.miu.cs544.courseregistrationsystem.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationGroupDto implements Serializable {
    private Long id;
    private List<Student> students = new ArrayList<>();
    private List<AcademicBlock> academicBlocks = new ArrayList<>();
}
