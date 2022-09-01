package com.eazybytes.eazyschool.model;

import com.eazybytes.eazyschool.annotation.FieldsValueMatch;
import com.eazybytes.eazyschool.annotation.PasswordValidator;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
@FieldsValueMatch.List({
        @FieldsValueMatch(
                field = "pwd",
                fieldMatch = "confirmPwd",
                message = "Passwords do not match!"
        ),
        @FieldsValueMatch(
                field = "email",
                fieldMatch = "confirmEmail",
                message = "Email addresses do not match!"
        )
})
public class Person extends BaseEntity{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int personId;
    @NotBlank(message = "Name must not be blank")
    @Size(min = 3,message = "Name must be at least 3 character long")
    private String name;
    @NotBlank(message = "Mobile number must not be blank")
    @Pattern(regexp = "(^$|[0-9]{11})",message = "Mobile number must be 11 digits")
    private String mobileNumber;
    @NotBlank(message = "Email must not be blank")
    @Email(message = "Please provide a valid email address")
    private String email;
    @NotBlank(message = "Confirm email must not be blank")
    @Email(message = "Please provide a confirm valid email address")
    @Transient
    private String confirmEmail;
    @NotBlank(message = "Password must not be blank")
    @Size(min = 5,message = "Password must be at least 5 character long")
    //@PasswordValidator
    private String pwd;
    @NotBlank(message = "Confirm password must not be blank")
    @Size(min = 5,message = "Confirm Password must be at least 5 character long")
    @Transient
    private String confirmPwd;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST,targetEntity = Roles.class)
    @JoinColumn(name = "role_id",referencedColumnName = "roleId",nullable = false)
    private Roles roles;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL,targetEntity = Address.class)
    @JoinColumn(name = "address_id",referencedColumnName = "addressId",nullable = true)
    private Address address;

}




















