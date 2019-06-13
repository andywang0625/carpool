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
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @NotBlank(message = "Please provide your last name")
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public Name setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Name setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}
