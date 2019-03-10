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

  @Column(name = "city", columnDefinition = "default 'UNKNOWN'")
  @Basic
  @Enumerated(EnumType.STRING)
  private City city;

  @Column(name = "province", columnDefinition = "default 'UNKNOWN'")
  @Basic
  @Enumerated(EnumType.STRING)
  private Province province;

  @Column(name = "post_code")
  private String postCode;
}
