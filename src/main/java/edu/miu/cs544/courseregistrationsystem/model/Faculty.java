package edu.miu.cs544.courseregistrationsystem.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Data
@Entity
@PrimaryKeyJoinColumn
public class Faculty extends Person{
    private String title;
}
