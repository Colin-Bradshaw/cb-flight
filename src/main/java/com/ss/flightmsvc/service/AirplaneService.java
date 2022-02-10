package com.ss.flightmsvc.service;

import com.ss.flightmsvc.dao.AirplaneDAO;
import com.ss.flightmsvc.dao.Airplane_TypeDAO;
import com.ss.flightmsvc.entity.Airplane;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AirplaneService {
    ConnectionUtil connUtil = new ConnectionUtil();

    public List<Airplane> readAirplanes(String sql, Object[] param) throws SQLException, ClassNotFoundException {
        Connection conn = connUtil.getConnection();
        try {
            AirplaneDAO aDAO = new AirplaneDAO(conn);
            ArrayList<Airplane> all= (ArrayList<Airplane>) aDAO.read(sql, param);
            return all;
        } catch (Exception e) {
            e.printStackTrace();
            if(conn!=null) {
                conn.rollback();
            }
        } finally {
            if(conn!=null) {
                conn.close();
            }
        }
        return null;
    }

    public Integer addAirplane(Integer type) throws ClassNotFoundException, SQLException{
        Connection conn = connUtil.getConnection();
        try {
            Airplane_TypeDAO atDAO = new Airplane_TypeDAO(conn);
            Integer ret = atDAO.saveWithPK("INSERT INTO airplane(type_id) VALUES (?)", (new Object[] {type}));
            conn.commit();
            return ret;
        } catch (Exception e) {
            e.printStackTrace();
            if(conn!=null) {
                conn.rollback();
            }
            return null;
        } finally {
            if(conn!=null) {
                conn.close();
            }
        }
    }
    public Boolean deleteAirplane(Integer id) throws ClassNotFoundException, SQLException {
        Connection conn = connUtil.getConnection();
        try {
            AirplaneDAO aDAO = new AirplaneDAO(conn);
            aDAO.save("DELETE FROM airplane WHERE id = ?", new Object[]{id});
            conn.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if(conn!=null) {
                conn.rollback();
            }
            return false;
        } finally {
            if(conn!=null) {
                conn.close();
            }
        }
    }
    public Boolean updateAirplane(Airplane a) throws ClassNotFoundException, SQLException{
        Connection conn = connUtil.getConnection();
        try {
            Airplane_TypeDAO atDAO = new Airplane_TypeDAO(conn);
            atDAO.save("UPDATE airplane SET type_id = (SELECT id FROM airplane_type WHERE id = ?) WHERE id = ?",
                    (new Object[] {a.getType_id(), a.getId()}));
            conn.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if(conn!=null) {
                conn.rollback();
            }
            return false;
        } finally {
            if(conn!=null) {
                conn.close();
            }
        }
    }
    public List<Airplane> getAirplaneByID(int id) {
        try {
            Airplane a =  readAirplanes("SELECT * FROM airplane WHERE id = ?", new Object[]{id}).get(0);
            return Arrays.asList(a);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Airplane> getAirplanes(String id) {
        try {
            return readAirplanes("SELECT * FROM airplane", null);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
