package modelPakke;

import java.util.*;

public class Meeting {
  
	private Date startTime;
	private Date endTime;
	private String description;
	private String title;
	private String location;
	private User leader;
	private ArrayList<User> members;
	private Alarm alarm;
	private Room room;
	
	//constructor
	public Meeting(Date startTime, Date endTime, String title, String description, Room room, String location, ArrayList<User> members){
		this.startTime = startTime;
		this.endTime = endTime;
		this.startTime.setYear(startTime.getYear()-1900);
		this.endTime.setYear(endTime.getYear()-1900);
		this.title = title;
		this.description = description;
		this.room = room;
		this.location = location;
		this.members = members;
	}
	
	/* TIDEN SETTES PÅ DENNE FORMEN:
		year - a year after 1900
		month - a month between 0-11
		date - day of the month between 1-31
		hrs - hours between 0-23
		min - minutes between 0-59
	 */
	@SuppressWarnings("deprecation")
	public void setStartTime(int year, int month, int date, int hrs, int min) {
		this.startTime.setYear(year-1900);
		this.startTime.setMonth(month);
		this.startTime.setDate(date);
		this.startTime.setHours(hrs);
		this.startTime.setMinutes(min);
	}
	

	@SuppressWarnings("deprecation")
	public void setEndTime(int year, int month, int date, int hrs, int min) {
		this.endTime.setYear(year-1900);
		this.endTime.setMonth(month);
		this.endTime.setDate(date);
		this.endTime.setHours(hrs);
		this.endTime.setMinutes(min);
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	//returns the start time
	public Date getStartTime(){
		return startTime;
	}
	
	//returns the end time
	public Date getEndTime(){
		return endTime;
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
	
	
}
