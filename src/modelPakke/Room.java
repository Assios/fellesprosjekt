package modelPakke;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;

public class Room {

	private int size;
	private String name;
	private PropertyChangeSupport propChangeSupp;
	
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
	
	
	/*
	 * Her må vi ha en egen kalender som kan holde oversikt over når rommet er ledig 
	 * 
	 */
}
