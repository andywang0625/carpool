package com.web.carpool.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="rate")
@Data
public class Rank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="userId")
    private long userId;

    @Column(name="driverLicense")
    private String driverLicense;

    @Column(name="insuranceNumber")
    private long insuranceNumber;

    @Column(name="customerScore")
    @NotEmpty(message="Please rate your trip")
    private Integer customerScore;

    @Column(name="clientCount")
    @Min(0)
    private Integer clientCount;
}