package com.web.carpool.model;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "post_id")
    private Integer post_id;

    @Column(name = "user_id")
    @NotEmpty(message = "Please provide a valid user ID")
    private Integer user_id;

    @Column(name = "car_plate")
    @NotEmpty(message = "Please provide a valid car plate")
    private String car_plate;

    @Column(name = "start_location")
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

    @Column(name = "post_time")
    private Time post_time;

    @Column(name = "update_time")
    private Time update_time;

    @Column(name = "carpool_type")
    @NotEmpty(message = "Please provide a valid carpool type")
    private Integer carpool_type;

    @Column(name = "comments")
    private String comments;

    @Column(name = "carpool_frequency")
    private Integer carpool_frequency;

    public Integer getpostId() {
		return post_id;
	}

	public void setpostId(Integer post_id) {
		this.post_id = post_id;
	}

	public Integer getuserId() {
		return user_id;
	}

	public void setuserId(Integer user_id) {
		this.user_id = user_id;
	}

	public String getCarPlate() {
		return car_plate;
	}

	public void setCarPlate(String car_plate) {
		this.car_plate = car_plate;
    }
    
    public String getStartLocation() {
		return start_location;
	}

	public void setDestination(String destination ) {
		this.destination = destination;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Time getDepartureTime() {
		return departure_time;
	}

	public void setDepartureTime(Time departure_time) {
        this.departure_time = departure_time;
    }
    
    public Time getPostTime() {
		return post_time;
	}

	public void setPostTime(Time post_time) {
        this.post_time = post_time;
    }

    public Integer getCarpoolType() {
		return carpool_type;
	}

	public void setCarpoolType(Integer carpool_type) {
		this.carpool_type = carpool_type;
    }
    
    public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
    }

    public Integer getCarpoolFrequency() {
		return carpool_frequency;
	}

	public void setCarpoolFrequency(Integer carpool_frequency) {
		this.carpool_frequency = carpool_frequency;
	}



}

