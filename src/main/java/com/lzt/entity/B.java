package com.lzt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tset_name",catalog="hibernate")
public class B {
	private Integer id;
	private String doorName;
	
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	@Override
	public String toString() {
		return "B [id=" + id + ", doorName=" + doorName + "]";
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDoorName() {
		return doorName;
	}
	public void setDoorName(String doorName) {
		this.doorName = doorName;
	}
	
	

}
