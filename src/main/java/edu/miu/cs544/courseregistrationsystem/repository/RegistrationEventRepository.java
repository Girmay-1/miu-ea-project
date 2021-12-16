package edu.miu.cs544.courseregistrationsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import edu.miu.cs544.courseregistrationsystem.model.*;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RegistrationEventRepository extends JpaRepository<RegistrationEvent, Long> {

	@Query("from RegistrationEvent re where :current_date BETWEEN re.startDateTime AND re.endDateTime")
	List<RegistrationEvent> currentEvent(LocalDateTime current_date);
}
