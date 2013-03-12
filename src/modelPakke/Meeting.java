package modelPakke;

import java.util.*;

public class Meeting {
  
	private Date startTime;
	private Date endTime;
	private String description;
	private User leader;
	private ArrayList<User> members;
	private Alarm alarm;
	private Room room;
	
	//constructor
	public Meeting(){
		
	}
	
	//returns the start time
	public Date getStartTime(){
		return startTime;
	}
	
	//returns the end time
	public Date getEndTime(){
		return endTime;
	}
	
	//sets the start time
	public void setStartTime(Date date){
		startTime=date;
	}
	
	//sets the end time
	public void setEndTime(Date date){
		endTime=date;
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
	
	
}
