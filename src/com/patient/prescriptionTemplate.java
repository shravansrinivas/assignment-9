package com.patient;
import java.util.Date;

public class prescriptionTemplate {
public int presID;
public String type, desc,name;
public Date presDate;
	public prescriptionTemplate(int presID, String name, Date presDate, String type, String desc) {
	this.presID=presID;
	this.name=name;
	this.presDate=presDate;
	this.type=type;
	this.desc=desc;
		// TODO Auto-generated constructor stub
	}

}
