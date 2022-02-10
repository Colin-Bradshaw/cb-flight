/**
 * 
 */
package com.ss.flightmsvc.entity;

/**
 * @author Colin Bradshaw
 *
 */
public class Route {
	private Integer id;
	private String origin_ID;
	private String destination_ID;
	
	public Route(int id, String origin_ID, String destination_ID) {
		this.id = id;
		this.origin_ID = origin_ID;
		this.destination_ID = destination_ID;
	}
	
	@Override
	public String toString() {
		return "Route [id=" + id + ", origin_ID=" + origin_ID + ", destination_ID=" + destination_ID + "]";
	}

	public Object[] toArray(){
		return new Object[]{id, origin_ID, destination_ID};
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrigin_ID() {
		return origin_ID;
	}
	public void setOrigin_ID(String origin_ID) {
		this.origin_ID = origin_ID;
	}
	public String getDestination_ID() {
		return destination_ID;
	}
	public void setDestination_ID(String destination_ID) {
		this.destination_ID = destination_ID;
	}
}
