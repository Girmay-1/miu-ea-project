package edu.miu.cs544.courseregistrationsystem.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
public class CourseOffering {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private int capacity;
    private int  availableSeats;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Registration> registrations = new ArrayList<>();

}
