/**
 * 
 */
package com.ss.flightmsvc.dao;

import com.ss.flightmsvc.entity.Airplane;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Colin Bradshaw
 *
 */
public class AirplaneDAO extends BaseDAO<Airplane> {

	public AirplaneDAO(){

	}
	public AirplaneDAO(Connection conn){
		super(conn);
	}

	@Override
	protected List<Airplane> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		ArrayList<Airplane> ap = new ArrayList<Airplane>();
		while(rs.next()) {
			ap.add(new Airplane(rs.getInt("id"), rs.getInt("type_id")));
		}
		return ap;
	}
}
