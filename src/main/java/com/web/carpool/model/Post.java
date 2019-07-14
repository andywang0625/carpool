package com.web.carpool.model;

<<<<<<< HEAD
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
=======
import java.util.Calendar;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;

import com.web.carpool.model.SharedModels.DateOrDateRange;
import com.web.carpool.model.SharedModels.PostRepeatType;
import com.web.carpool.model.SharedModels.PostStatus;
import com.web.carpool.model.SharedModels.PostType;
>>>>>>> b2e319418d78d939494f1a59e49f6468421872a4

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Entity
@EntityListeners(AuditingEntityListener.class)
<<<<<<< HEAD
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

=======
@Table(name = "c_post")
@Data
public class Post {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
  @JoinColumn(name = "departure_location_id")
  private Location departure;

  @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
  @JoinColumn(name = "destination_location_id")
  private Location destination;

  @Column(name = "price", nullable = false)
  @Positive
  private int price = 1;

  @Column(name = "created_at", nullable = false, updatable = false)
  @CreatedDate
  private Calendar createdDate;

  @Column(name = "modified_at")
  @LastModifiedDate
  private Calendar modifiedDate;

  @Column(name = "deleted_at")
  @PastOrPresent
  private Calendar deletedDate = null;

  @Embedded
  @Enumerated(EnumType.STRING)
  @NotEmpty(message = "Please provide repeat type")
  private PostRepeatType repeat_time = PostRepeatType.ONE_OFF;

  @Embedded
  private DateOrDateRange dateOrDateRange;

  @Column(name = "available_seat_number", nullable = false)
  @NotEmpty(message = "Please provide the number of available seats")
  @Min(value = 1, message = "Seat number should not be less than 1")
  @Max(value = 10, message = "Seat number should not be greater than 10")
  private int availableSeatNumber;

  @Column(name = "post_type")
  @Enumerated(EnumType.STRING)
  @NotEmpty(message = "Please provide the post type")
  private PostType type = PostType.PASSENGER;

  @Column(name = "post_status")
  @Enumerated(EnumType.STRING)
  @NotEmpty(message = "Please provide the post status")
  private PostStatus status = PostStatus.DRAFT;

  @OneToMany(mappedBy = "post")
  private List<Comment> comments;
}
>>>>>>> b2e319418d78d939494f1a59e49f6468421872a4
