package edu.miu.cs544.courseregistrationsystem.model;

import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
public class Student extends Person{
    private String studentId;
    @Embedded
    private Address mailingAddress;
    @Embedded
    private Address homeAddress;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "student")
    List<Registration> registrations = new ArrayList<>();
}
