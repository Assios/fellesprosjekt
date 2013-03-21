package modelPakke;




import java.sql.Date;
import java.sql.Time;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Vector;




public class Request implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 6803769161330198627L;
	String userName,password,avtaleNavn, leader,type,description,location;
	Time start, slutt;
	Date dato;
	Vector<String> invited;
	Object object;
	Room room;


	public Request(String t,String uN, String password, Object o) {
		this.type=t;
		this.userName=uN;
		this.password=password;
		object=o;
	}




	public Request(String t,String uN){
		type=t;
		this.userName=uN;
	}




	public Request(String t,String avtaleNavn, String leader, Time start, Time slutt, Date dato, Vector<String> invited, String description,String location,Room room){
		this.type=t;
		this.avtaleNavn=avtaleNavn;
		this.leader=leader;
		this.start=start;
		this.slutt=slutt;
		this.dato=dato;
		this.invited=invited;
		this.description=description;
		this.location=location;
		this.room=room;
	}




	public String getDescription(){
		return description;
	}


	public Vector<String> getInvited(){
		return invited;
	}

	
	public String getLocation(){
		return location;
	}


	public Date getDate(){
		return dato;
	}

	public Room getRoom(){
		return room;
	}


	public Time getEndTime(){
		return slutt;
	}




	public Time getStartTime(){
		return start;
	}




	public String getLeader(){
		return leader;
	}




	public String getAvtaleNavn(){
		return avtaleNavn;
	}




	public String getType(){
		return type;
	}




	public String getUserName(){
		return userName;
	}




	public String getPassword(){
		return password;
	}
}
