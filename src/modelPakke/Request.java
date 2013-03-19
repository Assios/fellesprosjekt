package modelPakke;

import java.sql.Date;
import java.sql.Time;
import java.sql.Date;
import java.util.Vector;

public class Request implements java.io.Serializable {
	String userName,password,avtaleNavn, leader;
	Time start, slutt;
	Date dato;
	Vector<String> invited;
	Object object;
	String type;
	
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
	
	public Request(String t,String avtaleNavn, String leader, Time start, Time slutt, Date dato, Vector<String> invited){
		this.type=t;
		this.avtaleNavn=avtaleNavn;
		this.leader=leader;
		this.start=start;
		this.slutt=slutt;
		this.dato=dato;
		this.invited=invited;
	}
	
	
	public Vector<String> getInvited(){
		return invited;
	}
	
	public Date getDate(){
		return dato;
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
