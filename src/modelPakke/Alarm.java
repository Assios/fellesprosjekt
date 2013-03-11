package modelPakke;

import java.util.Date;

public class Alarm {
	
	private Date activationTime;
	private String alarmMessage;
	private String alarmTitle;
	
	/*
	 * Default constructor
	 */
	public Alarm(){
		activationTime = null;
		alarmMessage = "";
		alarmTitle = "";
	}
	
	/*
	 * Spesific constructor
	 */
	public Alarm(Date activationTime, String alarmMessage, String alarmTitle){
		this.activationTime = activationTime;
		this.alarmMessage = alarmMessage;
		this.alarmTitle = alarmTitle;
	}
/*
 * Getters and setters
 */
	public Date getActivationTime() {
		return activationTime;
	}

	public void setActivationTime(Date activationTime) {
		this.activationTime = activationTime;
	}

	public String getAlarmMessage() {
		return alarmMessage;
	}

	public void setAlarmMessage(String alarmMessage) {
		this.alarmMessage = alarmMessage;
	}

	public String getAlarmTitle() {
		return alarmTitle;
	}

	public void setAlarmTitle(String alarmTitle) {
		this.alarmTitle = alarmTitle;
	}
/*
 * toString
 */
	public String toString(){
		String s = "";
		s = "Title: " + alarmTitle + "\nMessage: " + alarmMessage + "\nActivation time: " + activationTime.toString();
		return s;
	}
	

}

