package edu.miu.cs544.courseregistrationsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import edu.miu.cs544.courseregistrationsystem.model.*;

@Repository
public interface RegistrationRequestRepository extends JpaRepository<RegistrationRequest, Long> {
//	List<RegistrationRequest> findByStatus(String status);
	@Query("from RegistrationRequest where priorityNumber = :priority and block = :block and student = :student")
	RegistrationRequest findByAttributes(int priority, AcademicBlock block, Student student);

}