/**
 * 
 */
package com.ss.flightmsvc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

/**
 * @author Colin Bradshaw
 *
 */
public class Flight {
	private Integer id;
	private Integer route_ID;
	private Integer airplane_ID;
	@JsonFormat(pattern= "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime departure_Time;
	private Integer reservedSeats;
	private Float seatPrice;

	public Flight(){}
	public Flight(int id, int route_ID, int airplane_ID, LocalDateTime depart, int res, float price) {
		this.id = id;
		this.route_ID = route_ID;
		this.airplane_ID = airplane_ID;
		this.departure_Time = depart;
		this.reservedSeats = res;
		this.seatPrice = price;
	}
	public Flight(int id, int route_ID, int airplane_ID, String depart, int res, float price) {
		this.id = id;
		this.route_ID = route_ID;
		this.airplane_ID = airplane_ID;
		this.departure_Time = LocalDateTime.parse(depart);
		this.reservedSeats = res;
		this.seatPrice = price;
	}
	
	@Override
	public String toString() {
		return "Flight [id=" + id + ", route_ID=" + route_ID + ", airplane_ID=" + airplane_ID + ", departure_Time="
				+ departure_Time + ", reservedSeats=" + reservedSeats + ", seatPrice=" + seatPrice + "]";
	}

	public Object[] toArray(){
		return new Object[]{id, route_ID, airplane_ID, departure_Time, reservedSeats, seatPrice};
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRoute_ID() {
		return route_ID;
	}
	public void setRoute_ID(Integer route_ID) {
		this.route_ID = route_ID;
	}
	public Integer getAirplane_ID() {
		return airplane_ID;
	}
	public void setAirplane_ID(Integer airplane_ID) {
		this.airplane_ID = airplane_ID;
	}
	public LocalDateTime getDeparture_Time() {
		return departure_Time;
	}
	public void setDeparture_Time(LocalDateTime departure_Time) {
		this.departure_Time = departure_Time;
	}
	public Integer getReservedSeats() {
		return reservedSeats;
	}
	public void setReservedSeats(Integer reservedSeats) {
		this.reservedSeats = reservedSeats;
	}
	public Float getseatPrice() {
		return seatPrice;
	}
	public void setseatPrice(Float seatPrice) {
		this.seatPrice = seatPrice;
	}
	
	
	
	
}
