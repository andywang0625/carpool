package com.web.carpool.model;

import javax.persistence.*;
import lombok.Data;

@Embeddable
@Data
public class Address {
  @Column(name = "line_1")
  private String line1;

  @Column(name = "line_2")
  private String line2;

  @Column(name = "city")
  @Basic
  @Enumerated(EnumType.STRING)
  private City city = City.UNKNOWN;

  @Column(name = "province")
  @Basic
  @Enumerated(EnumType.STRING)
  private Province province = Province.UNKNOWN;

  @Column(name = "post_code")
  private String postCode;
}
