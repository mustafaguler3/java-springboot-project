package com.eazybytes.eazyschool.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
public class Address extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name = "native",strategy = "native")
    private int addressId;
    @NotBlank(message = "Address1 must not be blank")
    @Size(min = 5,message = "Address1 must be at least 5 characters long")
    private String address1;

    private String address2;

    @NotBlank(message = "City must not be blank")
    @Size(min = 5,message = "City must be at least 5 characters long")
    private String city;

    @NotBlank(message = "State must not be blank")
    @Size(min = 5,message = "State must be at least 5 characters long")
    private String state;

    @NotBlank(message = "Zip Code must not be blank")
    @Pattern(regexp = "(^$|[0-9]{5})",message = "Zip code must be 5 digits")
    private int zipCode;
}


























