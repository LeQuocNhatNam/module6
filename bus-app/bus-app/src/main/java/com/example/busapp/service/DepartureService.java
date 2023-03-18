package com.example.busapp.service;

import com.example.busapp.model.Departure;
import com.example.busapp.repository.IDepartureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartureService implements IDepartureService {
    @Autowired
    private IDepartureRepository departureRepository;

    @Override
    public List<Departure> getAllDepartures() {
        return departureRepository.getAllDeparture();
    }
}
