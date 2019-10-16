package com.patient;
import java.util.*;
public class patientTemplate {
public int patientID;
public long patientNumber;
public List<prescriptionTemplate> prescriptions;
public String patientName,patientEmail, patientAddr;
	public patientTemplate(int patientID, String patientName,String patientEmail,long patientNumber,String patientAddr) {
		// TODO Auto-generated constructor stub
		this.patientID=patientID;
		this.patientName=patientName;
		this.patientEmail=patientEmail;
		this.patientNumber=patientNumber;
		this.patientAddr=patientAddr;
		this.prescriptions=new ArrayList<>();
	}

}
