package edu.miu.cs544.courseregistrationsystem.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.miu.cs544.courseregistrationsystem.model.AcademicBlock;
import edu.miu.cs544.courseregistrationsystem.model.RegistrationGroup;

@Repository
@Transactional
public interface AcademicBlockRepository extends JpaRepository<AcademicBlock, Long> {
	List<AcademicBlock> findByRegistrationGroupIn(List<RegistrationGroup> registrationGroups);
}