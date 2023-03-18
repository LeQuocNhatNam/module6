package com.example.busapp.repository;

import com.example.busapp.model.BusType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IBusTypeRepository extends JpaRepository<BusType, Integer> {
    @Query(value = "select bt.* from bus_type as bt;", nativeQuery = true)
    List<BusType> getAllBusTypes();
}
