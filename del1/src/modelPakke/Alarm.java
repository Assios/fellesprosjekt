package modelPakke;

import java.sql.*;


public class Alarm {


	private Date activationDate;
	private	Time activationTime;
	private String alarmMessage;
	private String brukernavn;
	private int avtaleID;


	/*
	 * Default constructor
	 */
	public Alarm(){
		activationDate = null;
		activationTime = null;
		alarmMessage = "";
		brukernavn = "";
	}


	/*
	 * Spesific constructor
	 */
	public Alarm(Date activationDate, Time activationTime, String alarmMessage, String brukernavn, int avtaleID){
		this.activationDate = activationDate;
		this.activationTime = activationTime;
		this.alarmMessage = alarmMessage;
		this.brukernavn = brukernavn;
		this.avtaleID = avtaleID;
	}
/*
 * Getters and setters
 */
	public Date getActivationDate() {
		return activationDate;
	}
	public Time getActivationTime() {
		return activationTime;
	}



	@SuppressWarnings("deprecation")
	public void setActivationTime(int year, int month, int date, int hrs, int min) {
		this.activationTime.setYear(year-1900);
		this.activationTime.setMonth(month);
		this.activationTime.setDate(date);
		this.activationTime.setHours(hrs);
		this.activationTime.setMinutes(min);
	}


	public String getAlarmMessage() {
		return alarmMessage;
	}


	public void setAlarmMessage(String alarmMessage) {
		this.alarmMessage = alarmMessage;
	}


	public String getBrukernavn() {
		return brukernavn;
	}
	public int getAvtaleID() {
		return avtaleID;
	}
	


	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
	}
	public void setAvtaleID(int avtaleID) {
		this.avtaleID = avtaleID;
	}
	
/*
 * toString
 */
	public String toString(){
		String s = "";
		s = "Title: " + avtaleID + " " + brukernavn + "\nMessage: " + alarmMessage + "\nActivation time: " + Integer.toString(activationTime.getHours()) + ":" + Integer.toString(activationTime.getMinutes());
		return s;
	}




}
