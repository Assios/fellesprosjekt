package modelPakke;

import java.util.*;

public class Calendar {
	private ArrayList<Meeting> meetings;
	private User user;
	
	public Calendar(){
		
	}
	
	public Meeting getMeeting(int i){
		return meetings.get(i);
	}
	
	public ArrayList<Meeting> getMeetingList(){
		return meetings;
	}
	
	public void addMeeting(Meeting meeting){
		meetings.add(meeting);
	}
	
	public void removeMeeting(Meeting meeting){
		meetings.remove(meeting);
	}
	
	public boolean hasMeeting(Date day){
		for (Meeting s : meetings){
		    if (s.getDate().getYear() == day.getYear() && s.getDate().getMonth() == day.getMonth() && s.getDate().getDay() == day.getDay()){
		    	return true;
		    }
		}return false;    	
	}
	public ArrayList<Meeting> getMeetingsOfDay(Date day){
		ArrayList<Meeting> meetingsToDay = new ArrayList();
		for (Meeting s : meetings){
		    if (s.getDate().getYear() == day.getYear() && s.getDate().getMonth() == day.getMonth() && s.getDate().getDay() == day.getDay()){
		    	meetingsToDay.add(s);
		    }
			
		}return meetingsToDay;
	}
}
