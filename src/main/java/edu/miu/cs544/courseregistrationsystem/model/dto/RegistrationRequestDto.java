package edu.miu.cs544.courseregistrationsystem.model.dto;

import lombok.Data;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class RegistrationRequestDto {
//    private Long id;
//    private int priorityNumber;
//    private AcademicBlockDto block;
//}
public interface RegistrationRequestDto {
	Long getId();
	Integer getPriorityNumber();
	
	AcademicBlockDto getBlock();
//	StudentProjection getStudent();
	
	interface AcademicBlockDto {
		Long getId();
		String getName();
	}
}