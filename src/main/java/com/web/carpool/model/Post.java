package com.web.carpool.model;

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

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Entity
@EntityListeners(AuditingEntityListener.class)
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