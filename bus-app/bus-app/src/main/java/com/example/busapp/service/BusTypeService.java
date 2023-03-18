package com.example.busapp.service;

import com.example.busapp.model.BusType;
import com.example.busapp.repository.IBusRepository;
import com.example.busapp.repository.IBusTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusTypeService implements IBusTypeService {
    @Autowired
    private IBusTypeRepository busTypeRepository;

    @Override
    public List<BusType> getAllBusTypes() {
        return busTypeRepository.getAllBusTypes();
    }
}
