package modelPakke;

public class Room {

	private int size;
	private String name;
	
	// Constructor
	public Room(int size, String name) {
		super();
		this.size = size;
		this.name = name;
	}
	
	
	//Getters og setters
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	/*
	 * Her må vi ha en egen kalender som kan holde oversikt over når rommet er ledig 
	 * 
	 */
}
