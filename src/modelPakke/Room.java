package modelPakke;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Date;

public class Room {

	private int size;
	private String name;
	private PropertyChangeSupport propChangeSupp;
	private ArrayList<Date> roomTaken;
	
	// Constructor
	public Room(int size, String name) {
		this.size = size;
		this.name = name;
		propChangeSupp = new PropertyChangeSupport(this);
	}
	
	
	//Getters og setters
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		int oldSize = this.size;
		this.size = size;
		PropertyChangeEvent event = new PropertyChangeEvent(this, "date", oldSize, size);
		propChangeSupp.firePropertyChange(event);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		String oldName = this.name;
		this.name = name;
		PropertyChangeEvent event = new PropertyChangeEvent(this, "name", oldName, name);
		propChangeSupp.firePropertyChange(event);
	}
	
	//roomTaken
	@SuppressWarnings("deprecation")
	public void addTaken(int year, int month, int date, int hrs, int min) {
		Date roomDate = null;
		roomDate.setYear(year-1900);
		roomDate.setMonth(month);
		roomDate.setDate(date);
		roomDate.setHours(hrs);
		roomDate.setMinutes(min);
		roomTaken.add(roomDate);
	}
	
	public void removeTaken(Date date) {
		this.roomTaken.remove(this.roomTaken.indexOf(date));
	}
	
	/*
	 * Her må vi ha en egen kalender som kan holde oversikt over når rommet er ledig 
	 * 
	 */
}
