package com.web.carpool.model.SharedModels;

import java.math.BigInteger;
import java.util.Calendar;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Embeddable
@Data
public class DateOrDateRange {
  @Column(name = "date")
  @NotEmpty(message = "Please provide a valid date")
  @FutureOrPresent
  private Calendar date = Calendar.getInstance();

  @Column(name = "date_range")
  @Min(value = 0)
  private BigInteger dateRange;
}