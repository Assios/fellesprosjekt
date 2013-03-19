package DBconnection;

import java.sql.Time;
import java.sql.Date;

public class TimeInterval {
	private Time start;
	private Time slutt;
	private Date dato;
	public Time getStart(){
		return start;
	}
	public Time getSlutt(){
		return slutt;
	}
	public Date getDato(){
		return dato;
	}
	public TimeInterval(Time start, Time slutt, Date dato){
		this.start = start;
		this.slutt = slutt;
		this.dato = dato;
	}
}
