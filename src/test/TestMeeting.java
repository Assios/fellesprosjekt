package test;

import modelPakke.Meeting;
import modelPakke.Room;
import modelPakke.User;
import junit.framework.TestCase;

public class TestMeeting extends TestCase {
	
	public void testMeeting() throws Exception {
		Meeting meeting = new Meeting();
		meeting.setStartTime(2013, 3, 19, 0, 0);
		meeting.setEndTime(2013, 3, 19, 4, 0);
		meeting.setDescription("Møtetest");
		Room room = new Room(4,"45");
		meeting.setRoom(room);
		User user = new User();
		meeting.addMember(user);
		// denne avtalen skal automatisk komme opp i databasen nå.
		//Gjør en spørring mot databasen.
		Meeting meeting2 = new Meeting();//=resultat av spørring
		assertTrue(meeting.equals(meeting2));
		
	}
}
