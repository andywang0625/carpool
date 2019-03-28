package com.web.carpool.model;

import java.util.Calendar;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

import lombok.Data;

@Entity
@Table(name = "t_vehicle")
@Data
public class Vehicle {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  @Column(name = "plate", nullable = false)
  @NotEmpty(message = "Please provide your vehicle's plate number")
  private String plate;

  @Embedded
  @NotEmpty(message = "Please provide your vehicle's brand")
  private VehicleBrand brand = VehicleBrand.UNKNOWN;

  @Column(name = "model", nullable = false)
  @NotEmpty(message = "Please provide your vehicle's model")
  private String model;

  @Embedded
  @NotEmpty(message = "Please provide your vehicle's color")
  private VehicleColor color = VehicleColor.UNKNOWN;

  @Column(name = "manufactured_date", nullable = false)
  @Basic
  @NotEmpty(message = "Please provide your vehicle's manufacture date")
  private Calendar manufacturedDate;

  @Column(name = "available_seat", nullable = false)
  @NotEmpty(message = "Please provide the number of available seats")
  @Positive
  @Max(value = 10, message = "Seat number should not be greater than 10")
  private int seatNumber;

  @Column(name = "insurance_number", nullable = false)
  @NotEmpty(message = "Please provide your auto insurance number")
  @Positive
  private int insuranceNumber;

  @Column(name = "insurance_expired_date", nullable = false)
  @Basic
  @NotEmpty(message = "Please provide your auto insurance expired date")
  private Calendar insuranceExpireddDate;

  @Column(name = "is_accessible", nullable = false)
  @NotEmpty(message = "Please provide your vehicle's manufacture date")
  private boolean isAccessible = false;

  @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL }) 
  @JoinColumn(name = "user_id")
  private User user;
}