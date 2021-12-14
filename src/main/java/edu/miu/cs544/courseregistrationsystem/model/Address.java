package edu.miu.cs544.courseregistrationsystem.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Embeddable
public class Address {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id", nullable = false)
//    private Long id;

    private String street;
    private String city;
    private String postalCode;
    private String stateOrProvince;
    private String countryRegion;
}
