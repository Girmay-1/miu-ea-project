package edu.miu.cs544.courseregistrationsystem.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class RegistrationEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    @OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="reg_event_id")
    private List<RegistrationGroup> registrationGroups = new ArrayList<>();
}
