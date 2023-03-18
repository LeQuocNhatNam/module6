package com.example.busapp.service;

import com.example.busapp.model.Bus;
import com.example.busapp.repository.IBusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BusService implements IBusService {
    @Autowired
    private IBusRepository busRepository;

    @Override
    public Page<Bus> getAllBus(Pageable pageable) {
        return busRepository.getAll(pageable);
    }

    @Override
    public void deleteBus(int id) {
        busRepository.deleteBus(id);
    }

    @Override
    public void saveBus(Bus bus) {
        busRepository.save(bus);
    }

    @Override
    public Bus findBusById(int id) {
        return busRepository.findById(id).get();
    }

}
