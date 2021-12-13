package edu.miu.cs544.courseregistrationsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.miu.cs544.courseregistrationsystem.model.RegistrationEvent;

@Repository
public interface RegistrationEventRepository extends JpaRepository<RegistrationEvent, Long> {

}
