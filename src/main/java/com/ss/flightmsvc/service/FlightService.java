package com.ss.flightmsvc.service;


import com.ss.flightmsvc.dao.FlightDAO;
import com.ss.flightmsvc.entity.Flight;
import com.ss.flightmsvc.service.ConnectionUtil;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FlightService {
    ConnectionUtil connUtil = new ConnectionUtil();

    public List<Flight> getFlightByID(int id) {
        List<Flight> flights = null;
        try {
            flights = readFlights("SELECT * FROM flight", null);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        for (Flight f: flights){
            if(f.getId() == id){
                return Arrays.asList(f);
            }
        }
        return null;
    }

    public List<Flight> getFlights(String id) {
        // user value provided is not used, just display all

        List<Flight> flights = null;
        try {
            flights = readFlights("SELECT * FROM flight", null);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return flights;
    }

    public List<Flight> readFlights(String sql, Object[] param) throws SQLException, ClassNotFoundException {
        Connection conn = connUtil.getConnection();
        FlightDAO fDAO = new FlightDAO(conn);
        List<Flight> all=  fDAO.read(sql, param);
        return all;
    }
    public Boolean addFlight(Flight f) throws ClassNotFoundException, SQLException  {
        Connection conn = connUtil.getConnection();
        FlightDAO fDAO = new FlightDAO(conn);
        fDAO.save("INSERT INTO flight SET id = ?, route_id = (SELECT id FROM route WHERE id = ?),"
                        + "airplane_id = (SELECT id FROM airplane WHERE id = ?),"
                        + "departure_time = ?, reserved_seats = ?, seat_price = ?",
                (new Object[] {f.getId(), f.getRoute_ID(), f.getAirplane_ID(),
                        f.getDeparture_Time().toLocalDate() +  " " + f.getDeparture_Time().toLocalTime(),
                        f.getReservedSeats(), f.getseatPrice()}));
        return true;

    }
    public Boolean updateFlight(Flight f1, Flight f2) throws ClassNotFoundException, SQLException {
        Connection conn = connUtil.getConnection();
        try {
            FlightDAO fDAO = new FlightDAO(conn);
            fDAO.save("UPDATE flight SET id = ?, route_id = (SELECT id FROM route WHERE id = ?),"
                            + "airplane_id = (SELECT id FROM airplane WHERE id = ?),"
                            + "departure_time = ?, reserved_seats = ?, seat_price = ? WHERE id = ?",
                    (new Object[] {f2.getId(), f2.getRoute_ID(), f2.getAirplane_ID(),
                            f2.getDeparture_Time().toLocalDate() + " " + f2.getDeparture_Time().toLocalTime(),
                            f2.getReservedSeats(), f2.getseatPrice(), f1.getId()}));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if(conn!=null) {
                conn.close();
            }
        }
    }
    public Boolean deleteFlight(Flight f)  throws ClassNotFoundException, SQLException{
        Connection conn = connUtil.getConnection();
        try {
            FlightDAO fDAO = new FlightDAO(conn);
            fDAO.save("DELETE FROM flight WHERE id = ?", new Object[]{f.getId()});
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if(conn!=null) {
                conn.close();
            }
        }
    }
}
