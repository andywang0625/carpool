package com.web.carpool.model;

import javax.persistence.Embeddable;
import javax.persistence.Column;
import lombok.Data;

@Embeddable
@Data
public class Name {
  @Column(name = "first_name", nullable = false)
  private String fname;

  @Column(name = "last_name", nullable = false)
  private String lname;
}
