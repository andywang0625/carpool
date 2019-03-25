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
import lombok.NoArgsConstructor;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="user_rank")
@Data
public class Rank {

    public Rank() {
        // System.out.println("into rank constructor");
        // this.userId = 000;
        // this.driverLicense = "TEST";
        // this.insuranceNumber = "123321";
        // this.customerScore = 100;
        // this.clientCount = 5;
    }

    public Rank(Rank rnk){
        System.out.println("into rank constructor");
        this.setUserId( rnk.getUserId() );
        this.setDriverLicense(rnk.getDriverLicense());
        this.setInsuranceNumber(rnk.getInsuranceNumber());
        this.setCustomerScore(rnk.getCustomerScore());
        this.setClientCount(rnk.getClientCount());
    }

    public Rank(long userId, String driverLicense, String insuranceNumber, Integer customerScore, Integer clientCount) {
        System.out.println("into rank constructor");
        this.setUserId( userId );
        this.setDriverLicense(driverLicense);
        this.setInsuranceNumber(insuranceNumber);
        this.setCustomerScore(customerScore);
        this.setClientCount(clientCount);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_id")
    private long userId;

    @Column(name="driver_license")
    private String driverLicense;

    @Column(name="insurance_number")
    private String insuranceNumber;

    // @NotEmpty(message="Please rate your trip")
    @Column(name="customer_score")
    private Integer customerScore;

    @Column(name="client_count")
    @Min(0)
    private Integer clientCount;

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long id) {
        this.userId = id;
    }

    public String getInsuranceNumber() {
        return this.insuranceNumber;
    }

    public void setInsuranceNumber( String num ) {
        this.insuranceNumber = num;
    } 

    public String getDriverLicense() {
        return this.driverLicense;
    }

    public void setDriverLicense( String license ) {
        this.driverLicense = license;
    }

    public Integer getCustomerScore() {
        return this.customerScore;
    }

    public void setCustomerScore( Integer score) {
        this.customerScore = score;
    }

    public Integer getClientCount() {
        return this.clientCount;
    }

    public void setClientCount( Integer count ) {
        this.clientCount = count;
    }
}