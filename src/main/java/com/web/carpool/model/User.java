package com.web.carpool.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;

import com.web.carpool.model.SharedModels.Account;
import com.web.carpool.model.SharedModels.Address;
import com.web.carpool.model.SharedModels.Name;
import com.web.carpool.model.SharedModels.Role;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "c_user")
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Embedded
	private Account account;
	
	@Embedded
	private Name name;

	@Column(name = "email", nullable = false)
	@Email(message = "Please provide a valid Email")
	@NotEmpty(message = "Please provide an Email")
	private String email;

	@Column(name = "phone", nullable = false)
	@NotEmpty(message = "Please provide your phone number")
	private String phone;

	@Embedded
	private Address address;

	@Column(name = "license_number")
	private String licenseNumber;

	@Column(name = "photo_path")
	private String photoPath;

	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	private Role role = Role.USER;

	@Column(name = "created_at", nullable = false, updatable = false)
	@CreatedDate
	private Calendar createdDate;

	@Column(name = "modified_at")
	@LastModifiedDate
	private Calendar modifiedDate;

	@Column(name = "deleted_at")
	@PastOrPresent
	private Calendar deletedDate = null;

	@OneToMany(mappedBy = "user")
	private List<Vehicle> vehicles;

	@OneToMany(mappedBy = "user")
	private List<Comment> comments;
}
