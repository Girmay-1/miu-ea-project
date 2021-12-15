package edu.miu.cs544.courseregistrationsystem.service;

import java.time.LocalDateTime;
import java.util.*;

import edu.miu.cs544.courseregistrationsystem.model.RegistrationGroup;
import edu.miu.cs544.courseregistrationsystem.model.Student;
import edu.miu.cs544.courseregistrationsystem.model.dto.RegistrationEventDto;
import org.springframework.stereotype.Service;

import edu.miu.cs544.courseregistrationsystem.model.RegistrationEvent;
import edu.miu.cs544.courseregistrationsystem.repository.RegistrationEventRepository;

@Service
public class RegistrationEventServiceImp implements RegistrationEventService {

	final
	RegistrationEventRepository repository;

	public RegistrationEventServiceImp(RegistrationEventRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<RegistrationEvent> getAll() {
		return this.repository.findAll();
	}

	@Override
	public RegistrationEvent get(Long id) {
		return this.repository.findById(id).get();
	}

	@Override
	public RegistrationEvent save(RegistrationEvent registrationEvent) {
		return this.repository.save(registrationEvent);
	}

	@Override
	public void delete(Long id) {
		this.repository.deleteById(id);
	}

	@Override
	public RegistrationEventDto getLatest(String studentId) {
		//get regEvent object from repository
		//get the latest registration event
		//filter student registration group
		//filter out student list
		RegistrationEventDto dto = new RegistrationEventDto();
		try {
			List<RegistrationEvent> events = repository.findAll();
			System.out.println("events==>" + events);
			RegistrationEvent latest = events.stream()
					.max(Comparator.comparing(RegistrationEvent::getEndDateTime))
					.get();
			System.out.println("latest==>" + latest);

			RegistrationGroup group = new RegistrationGroup();
			for (RegistrationGroup grp: latest.getRegistrationGroups()) {
				for (Student st: grp.getStudents()){
					if(studentId.equals(st.getStudentId())) group = grp;
				}
			}
			System.out.println("group==> " + group);

			dto.setId(latest.getId());
			dto.setStartDateTime(latest.getStartDateTime());
			dto.setEndDateTime(latest.getEndDateTime());
			dto.setStatus((LocalDateTime.now().compareTo(latest.getEndDateTime()) < 0) ? "OPEN/IN-PROGRESS" : "CLOSED");
			dto.setRegistrationGroup(new RegistrationGroup(group.getId(), null, group.getAcademicBlocks()));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

}