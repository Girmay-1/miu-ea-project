package edu.miu.cs544.courseregistrationsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import edu.miu.cs544.courseregistrationsystem.model.*;
import edu.miu.cs544.courseregistrationsystem.model.dto.*;

@Repository
public interface RegistrationRequestRepository extends JpaRepository<RegistrationRequest, Long> {
//	List<RegistrationRequest> findByStatus(String status);
	@Query("from RegistrationRequest where priorityNumber = :priority and block = :block and student = :student")
	RegistrationRequest findByAttributes(int priority, AcademicBlock block, Student student);

	@Query("select rr.id as id, rr.priorityNumber as priorityNumber, rr.block as block from RegistrationEvent re join re.registrationGroups rg"
			+ " join rg.academicBlocks ab join ab.courseOfferings co join co.registrationRequests rr"
			+ " where re.id = :eventId AND rr.student.id = :studentId")
	List<RegistrationRequestDto> requests(Long eventId, Long studentId);
	
	@Query("select rr from RegistrationEvent re join re.registrationGroups rg"
			+ " join rg.academicBlocks ab join ab.courseOfferings co join co.registrationRequests rr"
			+ " where re.id = :eventId AND rr.student.id = :studentId")
	List<RegistrationRequest> currentRequests(Long eventId, Long studentId);
	

	@Query("select rr from RegistrationEvent re join re.registrationGroups rg join rg.academicBlocks ab join ab.courseOfferings co join co.registrationRequests rr")
	List<RegistrationRequest> requests2();
}