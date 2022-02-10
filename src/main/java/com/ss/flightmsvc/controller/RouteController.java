package com.ss.flightmsvc.controller;


import com.ss.flightmsvc.entity.Route;
import com.ss.flightmsvc.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class RouteController {
    @Autowired
    RouteService routeService;

    // read
    @RequestMapping(path = "/lms/route/{id}", method = RequestMethod.GET)
    public List<Route> getRouteByID(@PathVariable String id){
        try{
            Integer.parseInt(id);
            return routeService.getRouteByID(Integer.parseInt(id));
        } catch (NumberFormatException n){
            return routeService.getRoutes(id);
        }

    }
    // create
    @RequestMapping(path = "/lms/route", method = RequestMethod.POST)
    public void addRoute(@RequestBody Route r){
        try {
            routeService.addRoute(r);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    // update
    @RequestMapping(path = "/lms/route", method = RequestMethod.PATCH)
    public void updateRoute(@RequestBody Route r){
        try {
            routeService.updateRoute(r);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    //delete
    @RequestMapping(path = "/lms/route", method = {RequestMethod.DELETE})
    public void deleteRoute(@RequestBody Route r){
        try {
            routeService.deleteRoute(r);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
