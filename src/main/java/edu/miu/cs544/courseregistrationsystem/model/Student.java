package edu.miu.cs544.courseregistrationsystem.model;

import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.Entity;


@Entity
@Data
public class Student extends Person{
    private String studentId;
    @Embedded
    private Address mailingAddress;
    @Embedded
    private Address homeAddress;
}
