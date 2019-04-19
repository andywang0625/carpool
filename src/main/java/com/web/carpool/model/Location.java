package com.web.carpool.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.web.carpool.model.SharedModels.Address;

import lombok.Data;

@Entity
@Table(name = "c_post_location")
@Data
public class Location {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  @NotBlank(message = "Please provide a location name")
  private String name;

  @Embedded
  private Address address;

  @OneToMany(mappedBy = "departure")
  private List<Post> postDepartures;

  @OneToMany(mappedBy = "destination")
  private List<Post> postDestinations;
}