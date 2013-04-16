package modelPakke;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Date;


public class Room implements java.io.Serializable {


	private int size;
	private String name;
	private int ID;
	private PropertyChangeSupport propChangeSupp;
	private ArrayList<Date> roomTaken;


	// Constructor
	public Room(int id, String name, int size) {
		this.size = size;
		this.name = name;
		this.setID(id);
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

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}


	/*
	 * Her m� vi ha en egen kalender som kan holde oversikt over n�r rommet er ledig 
	 * 
	 */
}

