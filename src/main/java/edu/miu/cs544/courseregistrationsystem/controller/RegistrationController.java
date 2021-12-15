package edu.miu.cs544.courseregistrationsystem.controller;

import edu.miu.cs544.courseregistrationsystem.model.Registration;
import edu.miu.cs544.courseregistrationsystem.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;
//    @RequestMapping("/registration-events/latest")
//    public List<AcademicBlock> findALatest(){

//    }


}
