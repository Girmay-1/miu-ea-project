package edu.miu.cs544.courseregistrationsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import edu.miu.cs544.courseregistrationsystem.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	@Query("select s from RegistrationEvent rv join rv.registrationGroups rg join rg.students s " +
            "where rv.id= :registrationEventId")
    List<Student> findByRegistrationEvent(long registrationEventId);

}

