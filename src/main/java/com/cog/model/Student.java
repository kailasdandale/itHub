package com.cog.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotNull(message = "FirstName is required")
	private String firstName;
	@NotNull(message = "LastName is required")
	private String lastName;
	@NotNull(message = "MobileNumber is required")
	@Size(min = 10,max = 10,message = "please enter valid Mobile Number")
	private String mobileNumber;
	@NotNull(message = "Email is required")
	@Email(message = "please enter valid Email")
	private String email;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Project> project=new ArrayList<>();
	
}
