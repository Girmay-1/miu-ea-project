package edu.miu.cs544.courseregistrationsystem.model.dto;

import edu.miu.cs544.courseregistrationsystem.model.RegistrationGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationEventDto {
    private Long id;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private RegistrationGroup registrationGroup;
    private String status;
}
