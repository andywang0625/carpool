package com.web.carpool.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "t_user")
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Embedded
	@NotEmpty(message = "Please provide your name")
	private Name name;

	@Column(name = "email", nullable = false)
	@Email(message = "Please provide a valid Email")
	@NotEmpty(message = "Please provide an Email")
	private String email;

	@Column(name = "phone", nullable = false)
	@NotEmpty(message = "Please provide your phone number")
	private String phone;

	@Column(name = "preferred_language", columnDefinition = "default 'UNKNOWN'")
	@Basic
	@Enumerated(EnumType.STRING)
	private Language language;

	@Embedded
	@NotEmpty(message = "Please provide your address")
	private Address address;

	@Column(name = "license_number")
	private String licenseNumber;

	@Column(name = "photo_path")
	private String path;

	@Column(name = "role", columnDefinition = "default 'USER'")
	@Basic
	@Enumerated(EnumType.STRING)
	private Role role;

	@Column(name = "created_at", nullable = false, updatable = false)
	@CreatedDate
	private Calendar createdDate;

	@Column(name = "modified_at")
	@LastModifiedDate
	private Calendar modifiedDate;

	@Column(name = "deleted_at", columnDefinition = "default 'null'")
	private Calendar deletedDate;

	@OneToMany(mappedBy = "user")
	private List<Vehicle> vehicles;
}
