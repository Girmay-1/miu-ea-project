package edu.miu.cs544.courseregistrationsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import edu.miu.cs544.courseregistrationsystem.model.RegistrationGroup;

@Repository
public interface RegistrationGroupRepository extends JpaRepository<RegistrationGroup, Long> {
    @Query(value = "SELECT * FROM registrationgroup where reg_event_id = ?1", nativeQuery = true)
	List<RegistrationGroup> findByRegistrationId(Long registrationEvent);

}
