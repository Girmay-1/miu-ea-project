package edu.miu.cs544.courseregistrationsystem.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="id",  referencedColumnName = "id",  insertable=false, updatable=false)
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="id",  referencedColumnName = "id", insertable=false, updatable=false)
    private CourseOffering courseOffering;



}
