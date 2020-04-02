package com.stacksimplify.restservices.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.hateoas.RepresentationModel;

//Entity
@Entity
@Table(name = "user")
//This @JsonIgnoreProperties is part of Static Filtering @JsonIgnore
//@JsonIgnoreProperties({"firstname", "lastname"})
//This is for MappingJackson Filtering Section
//@JsonFilter(value = "userFilter")
//Resource Support is now called RepresentationModel
public class User extends RepresentationModel {

    @Id
    @GeneratedValue
    @JsonView(Views.External.class)
    private Long userid;

    @NotEmpty(message = "Username is Mandatory Field. Please provide username")
    @Column(name = "USER_NAME", length = 50, nullable = false, unique = true)
    @JsonView(Views.External.class)
    private String username;

    @Size(min = 2, message = "FirstName should have at least 2 characters")
    @Column(name = "FIRST_NAME", length = 50, nullable = false)
    @JsonView(Views.External.class)
    private String firstname;

    @Column(name = "LAST_NAME", length = 50, nullable = false)
    @JsonView(Views.External.class)
    private String lastname;

    @Column(name = "EMAIL_ADDRESS", length = 50, nullable = false)
    @JsonView(Views.External.class)
    private String email;

    @Column(name = "ROLE", length = 50, nullable = false)
    @JsonView(Views.Internal.class)
    private String role;

    @Column(name = "SSN", length = 50, nullable = true, unique = true)
//    @JsonIgnore
    @JsonView(Views.Internal.class)
    private String ssn;

    @OneToMany(mappedBy = "user")
    @JsonView(Views.Internal.class)
    private List<Order> orders;

    //No Argument Constructor
    public User() {

    }

    //Fields Constructor
    public User(Long userid, String username, String firstname, String lastname, String email, String role, String ssn) {
        this.userid = userid;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.role = role;
        this.ssn = ssn;
    }

    //Getters & Setters
    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrder(List<Order> order) {
        this.orders = order;
    }

    //To String
    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", ssn='" + ssn + '\'' +
                '}';
    }
}
