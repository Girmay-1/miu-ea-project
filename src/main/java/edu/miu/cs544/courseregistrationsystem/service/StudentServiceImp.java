package edu.miu.cs544.courseregistrationsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs544.courseregistrationsystem.model.*;
import edu.miu.cs544.courseregistrationsystem.repository.StudentRepository;

@Service
public class StudentServiceImp implements StudentService {

	@Autowired
	StudentRepository repository;

	@Override
	public List<Student> getAll() {
		return this.repository.findAll();
	}

	@Override
	public Student get(Long id) {
		return this.repository.findById(id).get();
	}

	@Override
	public Student save(Student student) {
		return this.repository.save(student);
	}

	@Override
	public void delete(Long id) {
		this.repository.deleteById(id);
	}

	@Override
    public List<Student> findByRegistrationEvent(long registrationEventId) {
        return repository.findByRegistrationEvent(registrationEventId);
    }
}