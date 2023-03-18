package com.example.busapp.model;

import javax.persistence.*;

@Entity
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String code;

    @ManyToOne
    @JoinColumn(name = "bus_type_id", referencedColumnName = "id")
    private BusType busType;

    private String companyName;

    @ManyToOne
    @JoinColumn(name = "departure_id", referencedColumnName = "id")
    private Departure departure;

    @ManyToOne
    @JoinColumn(name = "destination_id", referencedColumnName = "id")
    private Destination destination;

    private String phoneNumber;

    private String email;

    private String departureTime;

    private String arrivalTime;

    private boolean isDeleted;

    public Bus() {
    }

    public Bus(int id, String code, BusType busType, String companyName, Departure departure, Destination destination, String phoneNumber, String email, String departureTime, String arrivalTime, boolean isDeleted) {
        this.id = id;
        this.code = code;
        this.busType = busType;
        this.companyName = companyName;
        this.departure = departure;
        this.destination = destination;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.isDeleted = isDeleted;
    }

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

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
