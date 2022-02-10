package com.ss.flightmsvc.controller;


import com.ss.flightmsvc.entity.Airplane;
import com.ss.flightmsvc.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class AirplaneController {
    @Autowired
    AirplaneService airplaneService;

    // read
    @RequestMapping(path = "/lms/airplane/{id}", method = RequestMethod.GET)
    public List<Airplane> getAirplaneByID(@PathVariable String id){
        try{
            Integer.parseInt(id);
            return airplaneService.getAirplaneByID(Integer.parseInt(id));
        } catch (NumberFormatException n){
            return airplaneService.getAirplanes(id);
        }

    }
    // create
    @RequestMapping(path = "/lms/airplane", method = RequestMethod.POST)
    public void addAirplane(@RequestBody Airplane a){
        try {
            airplaneService.addAirplane(a.getType_id());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    // update
    @RequestMapping(path = "/lms/airplane", method = RequestMethod.PATCH)
    public void updateAirplane(@RequestBody Airplane a){
        try {
            airplaneService.updateAirplane(a);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    // delete
    @RequestMapping(path = "/lms/airplane", method = RequestMethod.DELETE)
    public void deleteAirplane(@RequestBody Airplane a){
        try {
            airplaneService.deleteAirplane(a.getId());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
