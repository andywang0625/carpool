package com.web.carpool.model.SharedModels;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.persistence.Column;
import lombok.Data;

@Embeddable
@Data
public class Name {
  @Column(name = "first_name", nullable = false)
  @NotBlank(message = "Please provide your first name")
  private String fname;

  @Column(name = "last_name", nullable = false)
  @NotBlank(message = "Please provide your last name")
  private String lname;
}
