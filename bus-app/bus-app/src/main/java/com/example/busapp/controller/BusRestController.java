package com.example.busapp.controller;

import com.example.busapp.dto.BusDTO;
import com.example.busapp.model.Bus;
import com.example.busapp.model.BusType;
import com.example.busapp.model.Departure;
import com.example.busapp.service.BusService;
import com.example.busapp.service.IBusTypeService;
import com.example.busapp.service.IDepartureService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class BusRestController {
    @Autowired
    private BusService busService;
    @Autowired
    private IBusTypeService busTypeService;
    @Autowired
    private IDepartureService departureService;

    @GetMapping("/buses/{page}")
    public ResponseEntity<Page<Bus>> getAllBuses(@PathVariable(required = false) Integer page) {
        if (page == null) {
            page = 0;
        }
        Pageable pageable = PageRequest.of(page, 3);
        Page<Bus> busPage = busService.getAllBus(pageable);
        if (busPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(busPage, HttpStatus.OK);
        }
    }

    @GetMapping("/bus-type")
    public ResponseEntity<List<BusType>> getAllBusTypes() {
        List<BusType> busTypeList = busTypeService.getAllBusTypes();
        if (busTypeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(busTypeList, HttpStatus.OK);
    }

    @GetMapping("/departure")
    public ResponseEntity<List<Departure>> getAllLocations() {
        List<Departure> departureList = departureService.getAllDepartures();
        if (departureList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(departureList, HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete-bus/{id}")
    public ResponseEntity<Bus> deleteBById(@PathVariable int id) {
        busService.deleteBus(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/update-bus/{id}")
    public ResponseEntity<BusDTO> updateBus(@PathVariable int id, @Validated @RequestBody BusDTO busDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(busDTO, HttpStatus.NOT_FOUND);
        }
        Bus bus1 = busService.findBusById(id);
        if (bus1 == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        Bus bus = new Bus();
        BeanUtils.copyProperties(busDTO, bus);
        bus.setId(id);
        busService.saveBus(bus);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/find-bus/{id}")
    public ResponseEntity<Bus> findBusById(@PathVariable int id) {
        Bus bus = busService.findBusById(id);
        if (bus == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(bus, HttpStatus.OK);
    }

    @PostMapping("/save-bus")
    public ResponseEntity<BusDTO> saveBus(@Validated @RequestBody BusDTO busDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(busDTO, HttpStatus.NOT_FOUND);
        }
        Bus bus = new Bus();
        BeanUtils.copyProperties(busDTO, bus);
        this.busService.saveBus(bus);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


//    @PutMapping("/update-bus/{id}")
//    public ResponseEntity<Bus> updateBus(@RequestBody);
}
