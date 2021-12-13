package edu.miu.cs544.courseregistrationsystem.model;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Faculty extends Person{
    private String title;
}
