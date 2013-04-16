package test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import DBconnection.DBConnection;
import modelPakke.Meeting;
import modelPakke.Room;
import modelPakke.User;
import junit.framework.TestCase;

public class TestMeeting extends TestCase {
	
	private Properties p;
	
	public void testMeeting() throws Exception {
		Meeting meeting = new Meeting();
		meeting.setStartTime(1);
		meeting.setEndTime(3);
		meeting.setDescription("Møtetest");
		Room room = new Room(1337,"45",4);
		meeting.setRoom(room);
		User user = new User();
		meeting.addMember(user);
		// denne avtalen skal automatisk komme opp i databasen nå.
		//Gjør en spørring mot databasen.
		p = new Properties();
		DBConnection db=new DBConnection(p);
		db.initialize();
		String sql = "SELECT * FROM rom, reservasjon WHERE rom.romID = reservasjon.romID AND rom.romID = 45";
		PreparedStatement ps = db.preparedStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		assertTrue(rs.next());
		
	}
}

