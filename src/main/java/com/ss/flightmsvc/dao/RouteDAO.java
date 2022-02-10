/**
 * 
 */
package com.ss.flightmsvc.dao;

import com.ss.flightmsvc.entity.Route;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Colin Bradshaw
 *
 */
public class RouteDAO extends BaseDAO<Route> {
	public RouteDAO(){

	}
	public RouteDAO(Connection conn){
		super(conn);
	}


	@Override
	protected List<Route> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		ArrayList<Route> rt = new ArrayList<Route>();
		while(rs.next()) {
			rt.add(new Route(rs.getInt("id"), rs.getString("origin_id"), rs.getString("destination_id")));
		}
		return rt;
	}
}
