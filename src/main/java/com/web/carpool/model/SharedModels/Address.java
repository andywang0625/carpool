package com.web.carpool.model.SharedModels;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Embeddable
@Data
public class Address {
  @Column(name = "line_1")
  @NotEmpty(message = "Please provide your address")
  private String line1;

  @Column(name = "line_2")
  private String line2;

  @Column(name = "city")
  @Basic
  @Enumerated(EnumType.STRING)
  @NotEmpty(message = "Please provide your city")
  private City city = City.UNKNOWN;

  @Column(name = "province")
  @Basic
  @Enumerated(EnumType.STRING)
  @NotEmpty(message = "Please provide your province")
  private Province province = Province.UNKNOWN;

  @Column(name = "post_code")
  @NotEmpty(message = "Please provide your postcode")
  @Size(min = 6, max = 6)
  private String postCode;
}
