package com.example.imei.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ImeiNum {
	
	
	@Id
	@Column(name= "id")
	private int id;
           
	@Column(name = "IMEINUMBER")
	public String imeinumber;

	public ImeiNum(int id, String imeinumber) {
		super();
		this.id = id;
		this.imeinumber = imeinumber;
	}

	public ImeiNum() {
		super();
		// TODO Auto-generated constructor stub
	}
	
  
	
}
