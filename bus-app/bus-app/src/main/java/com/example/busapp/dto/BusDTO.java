package com.example.busapp.dto;

import com.example.busapp.model.BusType;
import com.example.busapp.model.Departure;
import com.example.busapp.model.Destination;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class BusDTO {

    private int id;
    @Size(min = 4)
    private String code;

    private BusType busType;

    private String companyName;

    private Departure departure;

    private Destination destination;

    private String phoneNumber;

    private String email;

    private String departureTime;

    private String arrivalTime;
}
