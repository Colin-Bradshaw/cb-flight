package com.ss.flightmsvc.service;

import com.ss.flightmsvc.dao.Airplane_TypeDAO;
import com.ss.flightmsvc.entity.Airplane_Type;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Airplane_TypeService {
    ConnectionUtil connUtil = new ConnectionUtil();

    public List<Airplane_Type> readAirplaneTypes(String sql, Object[] param) throws SQLException, ClassNotFoundException{
        Connection conn = connUtil.getConnection();
        Airplane_TypeDAO aDAO = new Airplane_TypeDAO(conn);
        ArrayList<Airplane_Type> all= (ArrayList<Airplane_Type>) aDAO.read(sql, param);
        return all;
    }
    public Integer addAirplaneType(Integer maxCapacity) throws ClassNotFoundException, SQLException{
        Connection conn = connUtil.getConnection();
        Airplane_TypeDAO atDAO = new Airplane_TypeDAO(conn);
        Integer ret = atDAO.saveWithPK("INSERT INTO airplane_type(max_capacity) VALUES (?)", (new Object[] {maxCapacity}));
        conn.commit();
        return ret;
    }
    public Boolean deleteAirplaneType(Integer id) throws ClassNotFoundException, SQLException {
        Connection conn = connUtil.getConnection();
        Airplane_TypeDAO atDAO = new Airplane_TypeDAO(conn);
        atDAO.save("DELETE FROM airplane_type WHERE id = ?", new Object[] {id});
        conn.commit();
        return true;
    }
    public Boolean updateAirplaneType(Airplane_Type a) throws ClassNotFoundException, SQLException{
        Connection conn = connUtil.getConnection();
        Airplane_TypeDAO atDAO = new Airplane_TypeDAO(conn);
        atDAO.save("UPDATE airplane_type SET max_capacity = ? WHERE id = ?",
                (new Object[] {a.getMax_capacity(), a.getId()}));
        conn.commit();
        return true;
    }


    public Airplane_Type getAirplane_TypeByID(int id) {
        try {
            return readAirplaneTypes("SELECT * FROM airplane_type WHERE id = ?", new Object[]{id}).get(0);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addAirplane_Type(Airplane_Type at) {
        try {
            addAirplaneType(at.getMax_capacity());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateAirplane_TypeByID(Airplane_Type at) {
        try {
            updateAirplaneType(at);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteAirplane_TypeByID(Airplane_Type at) {
        try {
            deleteAirplaneType(at.getId());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
