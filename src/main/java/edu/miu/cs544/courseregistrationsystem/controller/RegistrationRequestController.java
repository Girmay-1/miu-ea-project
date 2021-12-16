package edu.miu.cs544.courseregistrationsystem.controller;

import edu.miu.cs544.courseregistrationsystem.model.*;
import edu.miu.cs544.courseregistrationsystem.service.*;
import edu.miu.cs544.courseregistrationsystem.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/registration-request")
public class RegistrationRequestController {
	@Autowired
	RegistrationRequestService registrationReqService;

	@Autowired
	private RegistrationEventRepository eventRepository;

	@Autowired
	private RegistrationRequestRepository requestRepository;

	@PutMapping("/prioritize")
	public ResponseEntity<String> updateRegistrationRequest(@RequestBody List<RegistrationRequest> requests) {
		try {
			List<RegistrationEvent> events = eventRepository.currentEvent(LocalDateTime.now());

			// validate check event is active
			if (events.isEmpty())
				return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);

			else {
				Long currentUserId = 10L;
				RegistrationEvent currentEvent = events.get(0);

				System.out.println("------> " + currentEvent.getId() + " <----------");

				List<RegistrationRequest> targetRequests = requestRepository.currentRequests(currentEvent.getId(),
						currentUserId);

//				System.out.println("---------requests toList-> " + requests.stream().map(a -> a.getId())
//						.collect(Collectors.toList()) + " <----------");
//				System.out.println("---------targetRequests toList-> " + targetRequests.stream().map(a -> a.getId())
//						.collect(Collectors.toList()) + " <----------");
				
				
				// Validate one object per course offering for all blocks available to select from
				if(Arrays.equals(requests.stream().map(a -> a.getId())
						.collect(Collectors.toList()), targetRequests.stream().map(a -> a.getId())
						.collect(Collectors.toList()))) {
					
				}
				for (RegistrationRequest targetRequest : targetRequests) {
					List<RegistrationRequest> req = requests.stream().filter(a -> a.getId() == targetRequest.getId())
							.collect(Collectors.toList());

				System.out.println("---------req-> " + req + " <----------");
					// Validate one object per course offering for all blocks available to select
					// from
					if (req.isEmpty()) {
						return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);
					} else {
						targetRequest.setPriorityNumber(req.get(0).getPriorityNumber());
						requestRepository.save(targetRequest);
					}
				}
				return new ResponseEntity<String>(HttpStatus.OK);
			}
		} catch (NoSuchElementException e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}