/**
 * 
 */
package com.ss.flightmsvc.dao;

import com.ss.flightmsvc.entity.Airplane_Type;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Colin Bradshaw
 *
 */
@Service
public class Airplane_TypeDAO extends BaseDAO<Airplane_Type>{

	public Airplane_TypeDAO(Connection conn){
		super(conn);
	}

	@Override
	protected List<Airplane_Type> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		ArrayList<Airplane_Type> at = new ArrayList<Airplane_Type>();
		while(rs.next()) {
			at.add(new Airplane_Type(rs.getInt("id"), rs.getInt("max_capacity")));
		}
		return at;
	}
}
