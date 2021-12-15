package edu.miu.cs544.courseregistrationsystem.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@PrimaryKeyJoinColumn
public class Student extends Person {
	private String studentId;
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "street", column = @Column(name = "mailing_street")),
			@AttributeOverride(name = "city", column = @Column(name = "mailing_city")),
			@AttributeOverride(name = "postalCode", column = @Column(name = "mailing_postalCode")),
			@AttributeOverride(name = "stateOrProvince", column = @Column(name = "mailing_stateOrProvince")),
			@AttributeOverride(name = "countryRegion", column = @Column(name = "mailing_countryRegion")) })
	private Address mailingAddress;
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "street", column = @Column(name = "home_street")),
			@AttributeOverride(name = "city", column = @Column(name = "home_city")),
			@AttributeOverride(name = "postalCode", column = @Column(name = "home_postalCode")),
			@AttributeOverride(name = "stateOrProvince", column = @Column(name = "home_stateOrProvince")),
			@AttributeOverride(name = "countryRegion", column = @Column(name = "home_countryRegion")) })
	private Address homeAddress;

	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)
	List<Registration> registrations = new ArrayList<>();

//	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY,
//			cascade = CascadeType.ALL)
//	List<RegistrationRequest> registrationRequests = new ArrayList<>();
	@OneToOne
	private RegistrationRequest registrationRequests ;
}
