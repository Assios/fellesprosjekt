package modelPakke;

import java.util.*;
import java.sql.*;
import java.sql.Date;

public class Meeting {
	
	private Time startTime;
	private Time endTime;
	private Date date;
	private String description;
	private String title;
	private String location;
	private User leader;
	private ArrayList<User> members;
	private Alarm alarm;
	private Room room;
	private Integer ID;
	
	//constructor
	public Meeting(Time startTime, Time endTime, String title, String description, Room room, String location, ArrayList<User> members, Date date, Integer ID){
		this.startTime = startTime;
		this.endTime = endTime;
		this.startTime.setYear(startTime.getYear()-1900);
		this.endTime.setYear(endTime.getYear()-1900);
		this.title = title;
		this.description = description;
		this.room = room;
		this.location = location;
		this.members = members;
		this.date = date;
		this.ID = ID;
	}
	

	public Meeting(){
		this.startTime = null;
		this.endTime = null;
		this.title = null;
		this.description = null;
		this.room = null;
		this.location = null;
		this.members = null;
	}
	
	/* TIDEN SETTES PÅ DENNE FORMEN:
		year - a year after 1900
		month - a month between 0-11
		date - day of the month between 1-31
		hrs - hours between 0-23
		min - minutes between 0-59
	 */
	@SuppressWarnings("deprecation")
	public void setStartTime(int hrs) {
		this.startTime = new Time(hrs,0,0);
	}
	

	@SuppressWarnings("deprecation")
	public void setEndTime(int hrs) {
		this.endTime = new Time(hrs,0,0);
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	//returns the start time
	public Time getStartTime(){
		return startTime;
	}
	
	//returns the end time
	public Time getEndTime(){
		return endTime;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}
	
	//adds a user to the list members
	public void addMember(User user){
		members.add(user);
	}
	
	//returns the list of users, members
	public ArrayList<User> getMemberList(){
		return members;
	}
	
	//returns the user at position i in members
	public User getMember(int i){
		return members.get(i);
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public User getLeader() {
		return leader;
	}

	public void setLeader(User leader) {
		this.leader = leader;
	}

	public Alarm getAlarm() {
		return alarm;
	}

	public void setAlarm(Alarm alarm) {
		this.alarm = alarm;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	
	private boolean compareMembers(Meeting meeting){
		if (this.members.size() == meeting.members.size()){
			for(int i = 0; i < meeting.members.size();i++){
				if(meeting.members.get(i) != this.members.get(i)){
					return false;
				}
			}
			return true;
		}
		return false;
		
	}
	
	public boolean equals(Meeting meeting){
		if(
			this.alarm == meeting.alarm &&
			this.room == meeting.room &&
			this.leader == meeting.leader &&
			this.location == meeting.location &&
			this.description == meeting.description &&
			this.title == meeting.title &&
			compareMembers(meeting)){
			return true;
		}
		return false;
				
	}
	
	
}
