package com.ss.flightmsvc.controller;


import com.ss.flightmsvc.entity.Flight;
import com.ss.flightmsvc.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class FlightController {
    @Autowired
    FlightService flightService;

    @RequestMapping(path = "/lms/flight/{id}", method = RequestMethod.GET)
    public List<Flight> getFlights(@PathVariable String id){
        try{
            // case where user provided id
            Integer.parseInt(id);
            return flightService.getFlightByID(Integer.parseInt(id));
        } catch (NumberFormatException n){
            // all other cases returns all results
            return flightService.getFlights(id);
        }

    }

    // create
    @RequestMapping(path = "/lms/flight", method = RequestMethod.POST)
    public void addFlight(@RequestBody Flight f){
        try {
            flightService.addFlight(f);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    // update
    @RequestMapping(path = "/lms/flight", method = RequestMethod.PATCH)
    public void updateFlight(@RequestBody Flight[] f){
        try {
            flightService.updateFlight(f[0], f[1]);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    //delete
    @RequestMapping(path = "/lms/flight", method = {RequestMethod.DELETE})
    public void deleteFlight(@RequestBody Flight f){
        try {
            flightService.deleteFlight(f);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
