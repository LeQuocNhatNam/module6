package com.example.busapp.service;

import com.example.busapp.model.Bus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface IBusService {
    Page<Bus> getAllBus(Pageable pageable);

    void deleteBus(int id);

    void saveBus(Bus bus);

    Bus findBusById(int id);
}
