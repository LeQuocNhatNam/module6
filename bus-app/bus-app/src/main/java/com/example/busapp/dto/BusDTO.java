package com.example.busapp.dto;

import com.example.busapp.model.BusType;
import com.example.busapp.model.Departure;
import com.example.busapp.model.Destination;

import javax.persistence.*;
import javax.validation.constraints.*;

public class BusDTO {

    private int id;

    @Size(min = 4)
    @NotNull
    private String code;

    @NotNull
    private BusType busType;

    @NotNull
    private String companyName;

    @NotNull
    private Departure departure;

    @NotNull
    private Destination destination;

    @NotNull
    @Pattern(regexp = "^090[0-9]{7}$|^093[0-9]{7}$|^097[0-9]{7}$")
    private String phoneNumber;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Pattern(regexp = "^(0[5-9]|1[0-9]|2[0-2]):[0-5][0-9]$|^23:00$")
    private String departureTime;

    @NotNull
    @Pattern(regexp = "^(0[5-9]|1[0-9]|2[0-2]):[0-5][0-9]$|^23:00$")
    private String arrivalTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BusType getBusType() {
        return busType;
    }

    public void setBusType(BusType busType) {
        this.busType = busType;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Departure getDeparture() {
        return departure;
    }

    public void setDeparture(Departure departure) {
        this.departure = departure;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
