package com.web.carpool.model;

import java.sql.Time;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Post")
@Data
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "post_id")
	private long post_id;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private long user_id;

	@Column(name = "car_plate", nullable = false)
	@NotEmpty(message = "Please provide a valid car plate")
	private String car_plate;

	@Column(name = "start_location", nullable = false)
	@NotEmpty(message = "Please provide a valid start location")
	private String start_location;

	@Column(name = "destination")
	@NotEmpty(message = "Please provide a valid destination")
	private String destination;

	@Column(name = "price")
	@NotEmpty(message = "Please provide a valid price")
	private Double price;

	@Column(name = "departure_time")
	@NotEmpty(message = "Please provide a valid departure time")
	private Time departure_time;

	@Column(name = "post_time", nullable = false, updatable = false)
	@CreatedDate
	private Calendar createdDate;

	@Column(name = "update_time")
	@LastModifiedDate
	private Calendar modifiedDate;

    @Column(name = "carpool_type")
    @NotEmpty(message = "Please provide a valid carpool type")
    private Integer carpool_type;

    @Column(name = "comments")
    private String comments;

	@Column(name = "carpool_frequency")
	private long carpool_frequency;
	
	@OneToMany(mappedBy = "post")//mapped by-> map from parent ???
	private List<Comment> comment;


}

