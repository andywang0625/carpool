package com.web.carpool.model;

import java.util.Calendar;
import javax.persistence.*;
import javax.validation.constraints.*;

import com.web.carpool.model.SharedModels.VehicleBrand;
import com.web.carpool.model.SharedModels.VehicleColor;

import lombok.Data;

@Entity
@Table(name = "c_user_vehicle")
@Data
public class Vehicle {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  @Column(name = "plate", nullable = false)
  @NotBlank(message = "Please provide your vehicle's plate number")
  private String plate;

  @Embedded
  @Enumerated(EnumType.STRING)
  @NotEmpty(message = "Please provide your vehicle's brand")
  private VehicleBrand brand = VehicleBrand.UNKNOWN;

  @Column(name = "model", nullable = false)
  @NotBlank(message = "Please provide your vehicle's model")
  private String model;

  @Embedded
  @NotEmpty(message = "Please provide your vehicle's color")
  private VehicleColor color = VehicleColor.UNKNOWN;

  @Column(name = "manufactured_date", nullable = false)
  @NotEmpty(message = "Please provide your vehicle's manufacture date")
  private Calendar manufacturedDate;

  @Column(name = "passenger_seat_amount", nullable = false)
  @NotEmpty(message = "Please provide the number of available seats")
  @Min(value = 1, message = "Seat number should not be less than 1")
  @Max(value = 10, message = "Seat number should not be greater than 10")
  private int passengerSeatAmount;

  @Column(name = "insurance_number", nullable = false)
  @NotBlank(message = "Please provide your auto insurance number")
  private String insuranceNumber;

  @Column(name = "insurance_expired_date", nullable = false)
  @NotEmpty(message = "Please provide your auto insurance expired date")
  private Calendar insuranceExpireddDate;

  @Column(name = "is_accessible", nullable = false)
  @NotEmpty(message = "Please provide accessibility info")
  private boolean isAccessible = false;

  @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
  @JoinColumn(name = "user_id")
  private User user;
}