package com.Project2.CustomerManagement.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "customers")
public class Customers {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.UUID) //UUID column where id stores // same here
    @GenericGenerator(name = "uuid2", strategy = "uuid2") //strategy is generator who is generating uuid here version 2 is generating
    private UUID customerID;
    @Column(name = "First Name", nullable = false)
    private String fName;
    @Column(name = "Last Name", nullable = false)
    private String lName;
    @Column(name = "Gender", nullable = false)
    private String Gender;

    @Column(name = "Phone Number", nullable = false)
    private String phoneNumber;
    @Column(name = "Age", nullable = false)
    private int Age;


    public Customers(String fName, String lName, String gender, String phoneNumber, int age) {
        super();
        this.fName = fName;
        this.lName = lName;
        Gender = gender;
        this.phoneNumber = phoneNumber;
        Age = age;
    }

    public Customers() {
        super();
    }

    public UUID getCustomerID() {
        return customerID;
    }

    public void setCustomerID(UUID customerID) {
        this.customerID = customerID;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }
}
