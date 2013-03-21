package DBconnection;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Vector;
import modelPakke.*;

public class KalenderSystemDB {
	private Properties p;
	private String testString;
	private Properties properties;
	
	public KalenderSystemDB(Properties propertie){
		this.p = propertie;
	} 
	
	public boolean loginCheck(String user, String pass) throws ClassNotFoundException, SQLException{
		DBConnection db=new DBConnection(p);
		db.initialize();
		String sql = "SELECT brukernavn, passord FROM ansatt WHERE brukernavn=? AND passord=?";
		PreparedStatement ps = db.preparedStatement(sql);
		ps.setString(1, user);
		ps.setString(2, pass);
		ResultSet rs = ps.executeQuery();
		

		if(!rs.next()){
			ps.close();
			db.close();
			return false;
		}
		ps.close();
		db.close();
		return true;
	}

	public Hashtable<String, User> getInvited(int avtaleID) 
	throws ClassNotFoundException, SQLException{
		Hashtable<String, modelPakke.User> users = new Hashtable<String, modelPakke.User>();
		DBConnection db = new DBConnection(p);
		String sql = "SELECT brukernavn, fornavn, etternavn, epost, dateOfBirth FROM ansatt, avtale, inviterte WHERE" +
				"ansatt.brukernavn=invitert.brukernavn AND avtale.avtaleID=invitert.avtaleID" +
				"AND avtale.avtaleID=" + avtaleID;
		db.initialize();
		ResultSet rs=db.makeSingleQuery(sql);
		rs.beforeFirst();
		while(rs.next()){
			String username = rs.getString("brukernavn");
			String fornavn = rs.getString("fornavn");
			String etternavn = rs.getString("etternavn");
			String email = rs.getString("epost");
			Date dateOfbirth = rs.getDate("dateOfbirth");
			
			users.put(username, new modelPakke.User(username, fornavn, etternavn, email, dateOfbirth));
		}
		return users;
	} 
	
	public Hashtable<String, User> getGroupMembers(int gruppeID) 
	throws ClassNotFoundException, SQLException{
		Hashtable<String, User> users = new Hashtable<String, User>();
		DBConnection db = new DBConnection(p);
		String sql = "SELECT ansatt.brukernavn, ansatt.fornavn, ansatt.etternavn," +
				", epost, dateOfBirth FROM gruppe, ansatt, medlemav WHERE " +
			"ansatt.brukernavn=medlemav.brukernavn AND medlemav.gruppeID = gruppe.gruppeID " +
			"AND gruppe.gruppeID=" + gruppeID;
		db.initialize();
		ResultSet rs=db.makeSingleQuery(sql);
		rs.beforeFirst();
		
		
		while(rs.next()){
			String username = rs.getString("brukernavn");
			String fornavn = rs.getString("fornavn");
			String etternavn = rs.getString("etternavn");
			String email = rs.getString("epost");
			Date dateOfbirth = rs.getDate("dateOfbirth");
			
			users.put(username, new modelPakke.User(username, fornavn, etternavn, email, dateOfbirth));
		}
		return users;
	} 
	
	public Hashtable<String, User> getUsers() 
	throws ClassNotFoundException, SQLException{
		Hashtable<String, User> users = new Hashtable<String, User>();
		DBConnection db = new DBConnection(p);
		String sql = "SELECT brukernavn, fornavn, etternavn, epost, dateOfBirth FROM ansatt"; 
		db.initialize();
		ResultSet rs=db.makeSingleQuery(sql);
		rs.beforeFirst();
		while(rs.next()){
			String username = rs.getString("brukernavn");
			String fornavn = rs.getString("fornavn");
			String etternavn = rs.getString("etternavn");
			String email = rs.getString("epost");
			Date dateOfbirth = rs.getDate("dateOfbirth");
			
			users.put(username, new modelPakke.User(username, fornavn, etternavn, email, dateOfbirth));
		}
		rs.close();
		db.close();
		return users;
	}
	
	public Vector<Room> getRooms() throws ClassNotFoundException, SQLException{
		Vector<Room> rooms = new Vector<Room>();
		DBConnection db = new DBConnection(p);
		String sql = "SELECT * FROM rom"; 
		db.initialize();
		ResultSet rs=db.makeSingleQuery(sql);
		rs.beforeFirst();
		while(rs.next()){
			int romID = rs.getInt("romID");
			int size = rs.getInt("antall_plasser");
			String romNavn = rs.getString("romNavn");
			Room rom = new Room(romID, romNavn, size);
			rooms.add(rom);
		}
		rs.close();
		db.close();
		return rooms;
	}
	
	public Vector<Integer> getEvents(String string) throws ClassNotFoundException, SQLException{
		Vector<Integer> events = new Vector<Integer>();
		DBConnection db = new DBConnection(p);
		String sql = "SELECT avtaleID FROM invitert WHERE brukernavn='" + string + "' AND " +
				"erMed = 'godtatt'";
		db.initialize();
		ResultSet rs=db.makeSingleQuery(sql);
		rs.beforeFirst();
		while(rs.next()){
			events.add(rs.getInt(1));
		}
		return events;
	}
	
 	public Meeting getEvent(int avtaleID) throws ClassNotFoundException, SQLException{
		DBConnection db = new DBConnection(p);
		String sql = "SELECT * FROM avtale WHERE avtaleID =" + avtaleID;
		db.initialize();
		ResultSet rs=db.makeSingleQuery(sql);
		rs.beforeFirst();
		rs.next();
		
		String leader = rs.getString("avtaleLeder");
		String beskrivelse = rs.getString("beskrivelse");
		String avtaleNavn = rs.getString("avtaleNavn");
		String sted = rs.getString("sted");
		Time start = rs.getTime("starttid");
		Time slutt = rs.getTime("sluttid");
		Date dato = rs.getDate("dato");
		boolean isActive = rs.getBoolean("isActive");
		
		TimeInterval tid = new TimeInterval(start, slutt, dato);
		Meeting event = new Meeting(avtaleID, tid, avtaleNavn, beskrivelse, sted, isActive, leader);
		
	
		rs.close();
		db.close();
		return event;
	}
	
	public int createCalenderEvent(String avtaleNavn, String leader, Time start, Time slutt, Date dato, Vector<String> invited) 
	throws ClassNotFoundException, SQLException{
		DBConnection db=new DBConnection(p);
		String sql = "INSERT INTO avtale(avtaleNavn, avtaleLeder, starttid, sluttid, dato)" +
				"values(?, ?, ?, ?, ?)";
		db.initialize();
		PreparedStatement ps = db.preparedStatement(sql);
		ps.setString(1, avtaleNavn);
		ps.setString(2, leader);
		ps.setTime(3, start);
		ps.setTime(4, slutt);
		ps.setDate(5, dato);
		ps.executeUpdate();
		
		ResultSet rs = ps.getGeneratedKeys();
		rs.beforeFirst();
		rs.next();
		int avtaleID = rs.getInt(1);
		for(String user: invited){
			sql = "INSERT INTO inviterte(avtaleID, brukernavn) values(" + avtaleID + ", '" +
					user + "')";
			db.makeSingleUpdate(sql);
		}
		
		sql = "INSERT INTO inviterte(avtaleID, brukernavn, erMed) values(" + avtaleID + ", '" +
				leader + "', 'godtatt')";
		db.makeSingleUpdate(sql);
		rs.close();
		db.close();	
		
		return avtaleID;
	}

	public void editCalenderEvent(int avtaleID, Time start, Time slutt, Date dato)
	throws ClassNotFoundException, SQLException{
		DBConnection db=new DBConnection(p);
		db.initialize();
		String sql = "UPDATE avtale SET starttid=?, sluttid=?,dato=? WHERE avtaleID=?";
		PreparedStatement ps = db.preparedStatement(sql);
		ps.setTime(1, start);
		ps.setTime(2, slutt);
		ps.setDate(3, dato);
		ps.setInt(4, avtaleID);
		ps.executeUpdate();
		
		sql = "SELECT avtaleleder FROM avtale WHERE avtaleID =" + avtaleID;
		ResultSet rs = db.makeSingleQuery(sql);
		rs.beforeFirst();
		rs.next();
		String avtaleLeder = rs.getString(1);
		String updateInvite = "UPDATE inviterte SET erMed=NULL WHERE avtaleID =" + avtaleID + " AND " +
				"brukernavn <> '" + avtaleLeder +"'";
		db.makeSingleUpdate(updateInvite);
		db.close();
		
	}
	
	public void editAvtaleNavn(int avtaleID, String avtaleNavn) throws ClassNotFoundException, SQLException{
		DBConnection db=new DBConnection(p);
		String sql = "UPDATE avtale SET avtaleNavn = '" + avtaleNavn + "' WHERE avtale.avtaleID =" + avtaleID;
		db.initialize();
		db.makeSingleUpdate(sql);
		db.close();
	}
	
	public void addDescription(int avtaleID, String description) throws ClassNotFoundException, SQLException{
		DBConnection db=new DBConnection(p);
		String sql = "UPDATE avtale SET beskrivelse = '" + description + "' WHERE avtale.avtaleID =" + avtaleID;
		db.initialize();
		db.makeSingleUpdate(sql);
		db.close();
	}
	
	public void addPlace(int avtaleID,String place) throws ClassNotFoundException, SQLException{
		DBConnection db=new DBConnection(p);
		String sql = "UPDATE avtale SET sted = '" + place + "' WHERE avtaleID=" + avtaleID;
		db.initialize();
		db.makeSingleUpdate(sql);
		db.close();
	}
	
	public void addRoomToEvent(int avtaleID, int romID) throws ClassNotFoundException, SQLException{
		DBConnection db=new DBConnection(p);
		
		Meeting event = getEvent(avtaleID);
		Time start = event.getStartTime();
		Time slutt = event.getEndTime();
		Date dato = event.getDate();
		
		String sql = "UPDATE reservasjoner SET avtaleID =" + avtaleID +
				" WHERE romID =" + romID + " AND starttid = '" + start +"'" +
				" AND sluttid = '" + slutt +"' AND dato = '" + dato + "'";
		db.initialize();
		db.makeSingleUpdate(sql);
		db.close();
	}

	public void deleteCalenderEvent(int avtaleID) throws ClassNotFoundException, SQLException{
		DBConnection db=new DBConnection(p);
		String sql = "UPDATE avtale SET isActive = 0 WHERE avtaleID =" + avtaleID;
		db.initialize();
		db.makeSingleUpdate(sql);
		String updateInvite = "UPDATE inviterte SET erMed='slettet' WHERE avtaleID =" + avtaleID;
		db.makeSingleUpdate(updateInvite);
		db.close();		
	}
	
	public void answerInvite(String username, int avtaleID ,boolean answer)
	throws ClassNotFoundException, SQLException{
		DBConnection db=new DBConnection(p);
		String sql = new String();
		if(answer){
			sql = "UPDATE inviterte SET erMed='godtatt' WHERE brukernavn = '" + username +
					"' AND avtaleID =" + avtaleID;
		}
		else{
			sql = "UPDATE inviterte SET erMed='avvist' WHERE brukernavn = '" + username +
					"' AND avtaleID =" + avtaleID;;
		}
		db.initialize();
		db.makeSingleUpdate(sql); 
		db.close();
	}
	
	public Vector<TimeInterval> getOccupiedRoomTime(int romID) throws ClassNotFoundException, SQLException{
		DBConnection db=new DBConnection(p);
		
		String sql="SELECT starttid, sluttid, dato FROM reservasjoner WHERE romID =" + romID;
		
		db.initialize();
		Vector<TimeInterval> time = new Vector<TimeInterval>(); 
		ResultSet rs=db.makeSingleQuery(sql);
		rs.beforeFirst();
		while(rs.next()) 
		{
			Time start = rs.getTime(1);
			Time slutt = rs.getTime(2);
			Date dato = rs.getDate(3);
			time.add(new TimeInterval(start, slutt, dato));
		}
		rs.close();
		db.close();
		return time;
	}
	
	public void bookRoom(int romID, Time start, Time slutt, Date dato) throws ClassNotFoundException, SQLException{
		DBConnection db=new DBConnection(p);
		db.initialize();
		String sql = "INSERT INTO reservasjoner(romID, starttid, sluttid, dato)" +
				"values(?,?,?,?)";
		PreparedStatement ps = db.preparedStatement(sql);
		ps.setInt(1, romID);
		ps.setTime(2, start);
		ps.setTime(3, slutt);
		ps.setDate(4, dato);
		ps.executeUpdate();
		
		db.close();
	}
	
	public void setAlarm(String brukernavn, int avtaleID, Time tid, Date dato, String beskjed) throws ClassNotFoundException, SQLException{
		DBConnection db=new DBConnection(p);
		db.initialize();
		String sql = "INSERT INTO alarm(brukernavn, avtaleID, tid, dato,beskjed)" +
				"values(?, ?, ?, ?, ?)";
		PreparedStatement ps = db.preparedStatement(sql);
		ps.setString(1, brukernavn);
		ps.setInt(2, avtaleID);
		ps.setTime(3, tid);
		ps.setDate(4, dato);
		ps.setString(5, beskjed);
		ps.executeUpdate();
		
		db.close();
	}
	
	public Alarm getAlarm(String brukernavn, int avtaleID) throws ClassNotFoundException, SQLException{
		DBConnection db=new DBConnection(p);
		db.initialize();
		String sql = "SELECT beskjed, tid, dato FROM alarm WHERE avtaleID =? AND brukernavn=?";
		PreparedStatement ps = db.preparedStatement(sql);
		ps.setInt(1, avtaleID);
		ps.setString(2, brukernavn);
		ResultSet rs = ps.executeQuery();
		rs.beforeFirst();
		if(rs.next()){
			Date dato = rs.getDate("dato");
			Time tid = rs.getTime("tid");
			String message = rs.getString("beskjed");
			Alarm alarm = new Alarm(dato, tid, message, brukernavn, avtaleID);
			return alarm;
		}
		return null;
	}
	
	public static void main(String args[]) {
		Properties p=new Properties();
		try {
			p.load(new FileInputStream(new File("config.properties")));
			KalenderSystemDB t=new KalenderSystemDB(p);
			//TESTING AV FUNKSJONENE;
				//check login as And Andersen (Donald_Duck)
					System.out.println(t.loginCheck("Donald_Duck", "password"));
				//Lage Event fra 1000 til 1400 den 16.05.13
					
					Vector<String> inviterte = new Vector<String>();
					inviterte.add("oleo");
					inviterte.add("jensj");
					inviterte.add("Stiner");
					int avtaleID = t.createCalenderEvent( "meeting","Donald_Duck", new Time(10, 0, 0), new Time(14, 0, 0), new Date(2013-1900, 5, 16), inviterte);
					t.addDescription(avtaleID,"add description for testing");
					t.addPlace(avtaleID, "rom 120");
					t.answerInvite("Oleo", avtaleID, true);
				// Han vil endre tid
					t.editCalenderEvent(avtaleID, new Time(17, 0, 0), new Time(22, 0, 0), new Date(2013-1900, 5, 17));
					t.answerInvite("jensj", avtaleID, true);
					t.deleteCalenderEvent(1);
			
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
