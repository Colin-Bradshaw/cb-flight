/**
 * 
 */
package com.ss.flightmsvc.entity;

/**
 * @author Colin Bradshaw
 *
 */
public class Airplane_Type {
	private Integer id;
	private Integer max_capacity;
	
	public Airplane_Type(int id, int max_capacity) {
		this.id = id;
		this.max_capacity = max_capacity;
	}

	public Object[] toArray(){
		return new Object[]{id, max_capacity};
	}
	public String toString() {
		return id.toString() + " " + max_capacity.toString();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMax_capacity() {
		return max_capacity;
	}
	public void setMax_capacity(Integer max_capacity) {
		this.max_capacity = max_capacity;
	}
	
}
