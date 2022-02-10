package com.ss.flightmsvc.controller;

import com.ss.flightmsvc.entity.Airplane_Type;
import com.ss.flightmsvc.service.Airplane_TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Airplane_TypeController {
    @Autowired
    Airplane_TypeService airplane_TypeService;

    // read
    @RequestMapping(path = "/lms/airplane_type/{id}", method = RequestMethod.GET)
    public Airplane_Type getAirplane_TypeByID(@PathVariable int id){
        return airplane_TypeService.getAirplane_TypeByID(id);
    }
    // create
    @RequestMapping(path = "/lms/airplane_type", method = RequestMethod.POST)
    public void addAirplane_Type(@RequestBody Airplane_Type at){
        airplane_TypeService.addAirplane_Type(at);
    }
    // update
    @RequestMapping(path = "/lms/airplane_type", method = RequestMethod.PATCH)
    public void updateAirplane_TypeByID(@RequestBody Airplane_Type at){
        airplane_TypeService.updateAirplane_TypeByID(at);
    }
    //delete
    @RequestMapping(path = "/lms/airplane_type", method = {RequestMethod.DELETE})
    public void deleteAirplane_TypeByID(@RequestBody Airplane_Type at){
        airplane_TypeService.deleteAirplane_TypeByID(at);
    }
}
