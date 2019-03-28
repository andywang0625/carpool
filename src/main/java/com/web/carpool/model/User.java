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

	@Column(name = "preferred_language")
	@Basic
	@Enumerated(EnumType.STRING)
	private Language language = Language.UNKNOWN;

	@Embedded
	@NotEmpty(message = "Please provide your address")
	private Address address;

	@Column(name = "license_number")
	private String licenseNumber;

	@Column(name = "photo_path")
	private String path;

	@Column(name = "role")
	@Basic
	@Enumerated(EnumType.STRING)
	private Role role = Role.USER;

	@Column(name = "created_at", nullable = false, updatable = false)
	@CreatedDate
	private Calendar createdDate;

	@Column(name = "modified_at")
	@LastModifiedDate
	private Calendar modifiedDate;

	@Column(name = "deleted_at")
	private Calendar deletedDate = null;

	@OneToMany(mappedBy = "user")//one-many 主表对应viechle
	private List<Vehicle> vehicles; // List<T> -> List,Set,Map;  
}
