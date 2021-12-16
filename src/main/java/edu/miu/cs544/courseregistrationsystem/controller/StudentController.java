package edu.miu.cs544.courseregistrationsystem.controller;

import edu.miu.cs544.courseregistrationsystem.service.RegistrationEventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student")
public class StudentController {
    //GET /registration-events/lates
    private RegistrationEventService eventService;

    public StudentController(RegistrationEventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("registration-events/latest/{studentId}")
    public ResponseEntity<?> getRegEvent(@PathVariable String studentId){
        return ResponseEntity.ok(eventService.getLatest(studentId));
    }

    // --------- additional
}
