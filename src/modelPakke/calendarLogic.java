package modelPakke;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Time;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Vector;
import DBconnection.Events;
import DBconnection.TimeInterval;


import javax.swing.JComboBox;
import javax.swing.ListModel;


import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;


public class calendarLogic {
	XStream xs = new XStream();


	Socket serverConnection;
    ObjectOutputStream out;
    ObjectInputStream in;
    String fromServer;
    String disconnect="dc";
    ArrayList<Meeting> meetings=new ArrayList<Meeting>();
    ArrayList<User> availableUsers;
    Vector<String> invited=new Vector<String>();
    ArrayList<Room> rooms=new ArrayList<Room>();
    User user=new User();


	public calendarLogic() {
		
	}




	public String send(Object object){
		try{


			try{


				Gson gson = new Gson();
				User user = new User("sfsdf","John Doe","124124", "john@gmail.com", new Date(1992, 23, 05));
				String json = gson.toJson(user);
				out.writeObject(json);
	    			out.flush();


	    			fromServer=(String)in.readObject();
	    			return(fromServer);




	    	}
	    	catch(IOException ioException){
	    		return("Something went wrong with i/o");
	    	}


		} catch (Exception e) {
			// TODO: handle exception
			return("no connection");
		}




	}




	public void disConnect(){
		try {


			serverConnection.close();
			System.out.println("disconnected");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}


	public void connect() {
		try{//78.91.48.59
    		serverConnection = new Socket("127.0.0.1", 7899);
    		System.out.println("Connected to  78.91.16.62  in port 7899");
    		//2. get Input and Output streams
    		out = new ObjectOutputStream(serverConnection.getOutputStream());
    		in = new ObjectInputStream(serverConnection.getInputStream());
    		//3: Communicating with the server
		}
    		
    		catch(IOException ioException){
    			ioException.printStackTrace();
    		}
    	






	}




	public String requestLogin(String id, String password){
		Request r=new Request("login",id,password,null);
		Response resp;

		try{			
			try{	
					
					user.setUserName(id);
					out.writeObject(r);
					out.reset();
					out.flush();
	    			resp=(Response)in.readObject();
	    			availableUsers=new ArrayList<User>(resp.getUsers());
	    			return(resp.getResult());


	    	}
	    	catch(IOException ioException){
	    		return("Something went wrong with i/o");
	    	}


		} catch (Exception e) {
			e.printStackTrace();
			return("no connection");
		}


	}


	public void createCalendarEvent(String avtaleNavn, String leader, Time start, Time slutt, Date dato, String description){
		String oE="opprettEvent";
		

		Request r=new Request(oE,avtaleNavn,leader,start,slutt,dato,invited,description);
		try{			
			try{	
					out.writeObject(r);
					System.out.println("ddfgdf");
	    			out.flush();
	    	}
	    	catch(IOException ioException){


	    	}


		} catch (Exception e) {
			// TODO: handle exception


		}
	}

	public ArrayList<Room> getRooms(){
		return rooms;
	}
	
	public void updateRooms(){
		Request r=new Request("hentRom","");
		try {
			out.writeObject(r);
			
			out.flush();
			rooms=(ArrayList<Room>)in.readObject();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("no arraylist could be retrieved");
	}
	
	public boolean timeOverlaps(TimeInterval t1, TimeInterval t2){
		if(t1.getStart().getTime()>=t2.getSlutt().getTime() || t1.getSlutt().getTime()<=t2.getStart().getTime())
			return false;
		else
			return true;
	}
	
	public User getUser(){
		return user;
	}

	public ArrayList<Meeting> getEvents(){
		
		return meetings;
	}
	
	public ArrayList<User> getAvailableMembers(){
		return availableUsers;
	}

	public void updateMeetings(){
		System.out.println(user.getUserName()+" hher");
		Request r=new Request("hentEvents",user.getUserName());
		try {
			out.writeObject(r);
			
			out.flush();
			meetings=(ArrayList<Meeting>)in.readObject();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("no arraylist could be retrieved");

	}


	public JComboBox addDatesToJComboBox(JComboBox cb){
		int day,hour;
		Date dato;
		for(int i=0;i<12;i++){
			for(int j=0;j<30;j++){
				dato=new Date(2013,i,j);
				cb.addItem(dato);
			}
		}
		return cb;
	}


	public JComboBox addHoursToJComboBox(JComboBox cb){
		int hour=0;
		for(int i=0;i<24;i++){
			Time t=new Time(hour,00,00);
			cb.addItem(t);
			hour++;
		}
		return cb;
	}
	
	public void makeInvites(ArrayList<User> users){
		for(int i=0;i<users.size();i++){
			invited.add(users.get(i).getUserName());
		}
	}

	public String convertToJson(Object o){
		//return(xs.toJson(o));
		return("");
	}


}
