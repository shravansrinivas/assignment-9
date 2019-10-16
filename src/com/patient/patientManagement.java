package com.patient;
import java.util.*;
public class patientManagement {
	static List<patientTemplate> patientsList;
	static int vindex=-1,dindex=-1,uindex=-1,snindex=-1;
	static boolean flag=false,sflag=false,dflag=false;
	public patientManagement() {
		patientsList=new ArrayList<>();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		patientManagement p=new patientManagement();
		Scanner inp=new Scanner(System.in);
		while(true)
		{
			System.out.println("Enter your choice:");
			System.out.println("1.Add a patient");
			System.out.println("2.View Patient record(Details and Prescriptions)");
			System.out.println("3.Update Patient Info(Can add new prescription here)");
			System.out.println("4.Delete a patient record");
			System.out.println("5.Search(By patient or Medicine)");
			System.out.println("6.Exit");
			int choice=inp.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter New ID for Patient:");
				int ID=inp.nextInt();
				System.out.println("Enter Name:");
				String name=inp.next();
				System.out.println("Enter Email");
				String Email=inp.next();
				System.out.println("Enter Phone #:");
				long phone=inp.nextLong();
				System.out.println("Enter Address:");
				String addr=inp.next();
				patientTemplate newPatient=new patientTemplate(ID,name,Email,phone,addr);
				patientsList.add(newPatient);
				break;
			case 2:
				if(patientsList.size()==0) {
					System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println();
					System.out.println("\t\t\t\t\t\t\tNo records to view");
					System.out.println();
					System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
					
						}
				else {
					System.out.println("Enter ID of Patient to view:");
					int viewID=inp.nextInt();
					
				for(int i=0;i<patientsList.size();i++)
				{
					if(patientsList.get(i).patientID==viewID)
						{vindex=i;
					flag=true;
					break;}
				}
				if(flag)
				{System.out.println("Patient Details");
					System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println();
					System.out.format("%5s %30s %20s %10s %50s","ID","Name","Email","Phone #", "Address");
					System.out.println();
					System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println();
					System.out.format("%5d %30s %20s %10s %50s",patientsList.get(vindex).patientID,patientsList.get(vindex).patientName,patientsList.get(vindex).patientEmail,patientsList.get(vindex).patientNumber,patientsList.get(vindex).patientAddr);
				System.out.println();
				if(patientsList.get(vindex).prescriptions.size()!=0)
				{System.out.println();System.out.println();
					System.out.println("Patient Details");
					System.out.println();System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
					System.out.format("%5s %30s %40s %10s %50s","PID","Name","Date","Type","Desc");
					System.out.println();System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
					
					for(prescriptionTemplate prescription:patientsList.get(vindex).prescriptions)
						{System.out.println();
					System.out.format("%5d %30s %40s %10s %50s",prescription.presID,prescription.name,prescription.presDate,prescription.type,prescription.desc);
				System.out.println();
				}}
				else
				{
					System.out.println();System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
					
					System.out.println("\t\t\tNo record Found, Add prescriptions first");
					System.out.println();System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
					
				}
				}
				else
				{
					System.out.println("Recheck ID, patient not found");
				}}
				break;
			case 3:
				System.out.println("Enter ID of Patient to Update records:");
				int updateID=inp.nextInt();
				uindex=-1;
				for(int i=0;i<patientsList.size();i++)
				{
					if(patientsList.get(i).patientID==updateID)
						{uindex=i;
					flag=true;
					break;}
				}
				if(flag) {
					System.out.println("Do you want to add prescriptions or update personal details?\n1.Prescription(new) \n2.Personal Details");
					int updateChoice=inp.nextInt();
					
					switch(updateChoice) {
					case 1:
						System.out.println("Enter New ID for Prescription:");
						int presID=inp.nextInt();
						System.out.println("Enter Name");
						String pname=inp.next();
						System.out.println("Enter Date for prescription:");
						System.out.println("Year?");
						int year=inp.nextInt();
						System.out.println("Month?");
						int month=inp.nextInt();
						System.out.println("Day?");
						int day=inp.nextInt();
						
						Date date=new Date(year,month-1,day);
						System.out.println("Enter Type");
						String type=inp.next();
						System.out.println("Enter Description");
						String desc=inp.next();
						prescriptionTemplate newPrescription=new prescriptionTemplate(presID,pname,date,type,desc);
						patientsList.get(uindex).prescriptions.add(newPrescription);
						
						System.out.println("Prescription added!");
						break;
					case 2:
						System.out.println("Enter Modified ID for Patient:");
						ID=inp.nextInt();
						System.out.println("Enter Name:");
						name=inp.next();
						System.out.println("Enter Email");
						Email=inp.next();
						System.out.println("Enter Phone #:");
						phone=inp.nextLong();
						System.out.println("Enter Address:");
						addr=inp.next();
						patientsList.remove(uindex);
						patientTemplate modifiedPatient=new patientTemplate(ID, name, Email, phone, addr);
						patientsList.add(modifiedPatient);
						System.out.println("Details Updated!");
						break;
						
					
				}}
					else
					{
						System.out.println("Recheck ID, patient not found");
					}
				break;
			case 4:
				System.out.println("Enter ID of Patient to delete:");
				int deleteID=inp.nextInt();
				for(int i=0;i<patientsList.size();i++)
				{
					if(patientsList.get(i).patientID==deleteID)
						dindex=i;
					flag=true;
					break;
				}
				if(flag)
					{patientsList.remove(dindex);
					System.out.println("Record removed");
					}
				else System.out.println("Recheck ID, patient not found");		
				break;
			case 5:	
				System.out.println("What to search?");
				System.out.println("1.Search by Patient Name");
				System.out.println("2.By Medicine name");
				System.out.println("3.By Dates");
				int searchChoice=inp.nextInt();
				switch(searchChoice) {
				case 1: 
					System.out.println("Enter Name:");
					String sname=inp.next();
					System.out.println();System.out.println();
					System.out.println("Search Results");
					System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println();
					System.out.format("%5s %30s %20s %10s %50s","ID","Name","Email","Phone #", "Address");
					System.out.println();
					System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println();
					for(int i=0;i<patientsList.size();i++)
					{
						if(patientsList.get(i).patientName.compareToIgnoreCase(sname)==0)
						{	sflag=true;
							System.out.format("%5d %30s %20s %10s %50s",patientsList.get(i).patientID,patientsList.get(i).patientName,patientsList.get(i).patientEmail,patientsList.get(i).patientNumber,patientsList.get(i).patientAddr);
							System.out.println();
							if(patientsList.get(vindex).prescriptions.size()!=0)
							{System.out.println();System.out.println();
								System.out.println("Patient Details");
								System.out.println();System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
								System.out.format("%5s %30s %40s %10s %50s","PID","Name","Date","Type","Desc");
								System.out.println();System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
								
								for(prescriptionTemplate prescription:patientsList.get(vindex).prescriptions)
									{System.out.println();
								System.out.format("%5d %30s %40s %10s %50s",prescription.presID,prescription.name,prescription.presDate,prescription.type,prescription.desc);
							System.out.println();
							}}
							else
							{
								System.out.println();System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
								
								System.out.println("\t\t\tNo record Found, Add prescriptions first");
								System.out.println();System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
								
							}
							}
						
						}
					if(!flag) {
					
						System.out.println("\t\t\tNo search record Found");
						System.out.println();System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
						
					}			
					
				break;
				case 2:
					System.out.println("Enter Medicine Name:");
					sname=inp.next();
					System.out.println();System.out.println();
					System.out.println("Search Results");
					System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println();
					System.out.format("%5s %30s %20s %10s %50s","ID","Name","Email","Phone #", "Address");
					System.out.println();
					System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println();
					for(int i=0;i<patientsList.size();i++)
					{
						for(int j=0;j<patientsList.get(i).prescriptions.size();j++)
						if(patientsList.get(i).prescriptions.get(j).name.compareTo(sname)==0)
						{	sflag=true;
						System.out.println();System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
						System.out.format("%5d %30s %20s %10s %50s",patientsList.get(i).patientID,patientsList.get(i).patientName,patientsList.get(i).patientEmail,patientsList.get(i).patientNumber,patientsList.get(i).patientAddr);
							System.out.println();
							
							}
						
						}
					if(!flag) {
					
						System.out.println("\t\t\tNo search record Found");
						System.out.println();System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
						
					}			
					
				break;
				case 3:
				
					System.out.println("Enter Beginning Date:");
					System.out.println("Year?");
					int year=inp.nextInt();
					System.out.println("Month?");
					int month=inp.nextInt();
					System.out.println("Day?");
					int day=inp.nextInt();
					
					Date Bdate=new Date(year,month-1,day);
					System.out.println("Enter Ending Date:");
					System.out.println("Year?");
					year=inp.nextInt();
					System.out.println("Month?");
					month=inp.nextInt();
					System.out.println("Day?");
					day=inp.nextInt();
					
					Date Edate=new Date(year,month-1,day);
					
					
					System.out.println();System.out.println();
					System.out.println("Search Results");
					System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println();
					System.out.println();System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
					System.out.format("%50s %5s %30s %40s %10s %50s","Patient Name","PID","Name","Date","Type","Desc");
					System.out.println();System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println();
					for(patientTemplate patient:patientsList) {
						for(prescriptionTemplate prescription:patient.prescriptions)
						{
							if((prescription.presDate.after(Bdate)&&(prescription.presDate.before(Edate))))
									{
								System.out.println();System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
								System.out.format("%20s %5d %30s %20s %10s %50s",patient.patientName,prescription.presID,prescription.name,prescription.presDate,prescription.type,prescription.desc);
										System.out.println();
										dflag=true;
										
									}
						}
					}
					if(!dflag) {
						System.out.println("\t\t\tNo search record Found");
						System.out.println();System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
						
					}
					
			case 6:
				System.exit(0);
				break;
				
			
	}

}
}
}
	

}