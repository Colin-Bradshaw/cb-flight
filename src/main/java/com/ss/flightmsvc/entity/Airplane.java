/**
 * 
 */
package com.ss.flightmsvc.entity;

/**
 * @author Colin Bradshaw
 *
 */
public class Airplane {
	private Integer id;
	private Integer type_id;
	
	public Airplane(int id, int type_id) {
		this.id = id;
		this.type_id = type_id;
	}
	
	@Override
	public String toString() {
		return "Airplane [id=" + id + ", type_id=" + type_id + "]";
	}

	public Object[] toArray(){
		return new Object[]{id, type_id};
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getType_id() {
		return type_id;
	}
	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}
	
}
