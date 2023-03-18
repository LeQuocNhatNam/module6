package com.example.busapp.repository;

import com.example.busapp.model.Departure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IDepartureRepository extends JpaRepository<Departure, Integer> {
    @Query(value = "select d.* from departure as d; ", nativeQuery = true)
    List<Departure> getAllDeparture();
}
