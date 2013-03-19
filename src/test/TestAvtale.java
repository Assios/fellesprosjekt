package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;

import DBconnection.DBConnection;
import DBconnection.KalenderSystemDB;

import modelPakke.Calendar;
import modelPakke.Meeting;
import modelPakke.Room;
import junit.framework.TestCase;

public class TestAvtale extends TestCase {

	public void testAvtale() throws Exception {
		Meeting avtale = new Meeting();
		avtale.setID(1);
		avtale.setStartTime(1);
		avtale.setEndTime(3);
		avtale.setDescription("Møtetest");
		Room room = new Room(4,"45");
		avtale.setRoom(room);
		// denne avtalen skal automatisk komme opp i databasen nå
		//gjør en spørring mot databasen
		
		Properties p=new Properties();
		try {
			p.load(new FileInputStream(new File("config.properties")));
			KalenderSystemDB t=new KalenderSystemDB(p);
		}
			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DBConnection db = new DBConnection(p);
			String sql = "SELECT * FROM avtale WHERE avtaleID =" + avtale.getID();
			db.initialize();
			ResultSet rs=db.makeSingleQuery(sql);
			rs.beforeFirst();
			rs.next();
			int id = rs.getInt("avtaleID");
			assertTrue(id == avtale.getID());
			
		
		
	}
}
