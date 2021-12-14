package edu.miu.cs544.courseregistrationsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs544.courseregistrationsystem.model.Student;
import edu.miu.cs544.courseregistrationsystem.repository.StudentRepository;

@Service
public class StudentServiceImp implements StudentService{

	@Autowired
	StudentRepository repository;

	public List<Student> getAllCourses() {
		return this.repository.findAll();
	}

	public Student readCourse(Long id) {
		return this.repository.findById(id).get();
	}

	public Student save(Student student) {
		return this.repository.save(student);
	}

	public void delete(Long id) {
		this.repository.deleteById(id);
	}

}