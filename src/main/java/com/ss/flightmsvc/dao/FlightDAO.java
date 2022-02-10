/**
 * 
 */
package com.ss.flightmsvc.dao;

import com.ss.flightmsvc.entity.Flight;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Colin Bradshaw
 *
 */
public class FlightDAO extends BaseDAO<Flight> {
	public FlightDAO(){

	}
	public FlightDAO(Connection conn){
		super(conn);
	}

	@Override
	protected List<Flight> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		ArrayList<Flight> fli = new ArrayList<Flight>();
		while(rs.next()) {
			fli.add(new Flight(rs.getInt("id"), rs.getInt("route_id"), rs.getInt("airplane_id"), (LocalDateTime.parse(rs.getString("departure_time").replace(' ', 'T'))), rs.getInt("reserved_seats"), rs.getInt("seat_price")));
		}
		return fli;
	}
}
