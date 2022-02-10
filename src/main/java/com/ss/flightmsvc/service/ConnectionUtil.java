/**
 * 
 */
package com.ss.flightmsvc.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Colin Bradshaw
 *
 */
@Service
public class ConnectionUtil {
	public final String driver = "com.mysql.cj.jdbc.Driver";
	public String url = "jdbc:mysql://MySQL:3306/utopia";
	public final String username = "root";
	public final String password = "A1l1ngAgedAlb@tross";

	@Bean
	public Connection getConnection() {
		if (System.getenv("DB-LOC") != null){
			url = System.getenv("DB-LOC");
			System.out.println(url);
		}
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);
			conn.setAutoCommit(Boolean.FALSE);
			return conn;
		} catch (ClassNotFoundException c){
			c.printStackTrace();
		} catch (SQLException s){
			s.printStackTrace();
		}
		return null;
	}

}
