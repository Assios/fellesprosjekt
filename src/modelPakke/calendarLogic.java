package modelPakke;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;package modelPakke;

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
		try{
			
    		//1. creating a socket to connect to the server
    		serverConnection = new Socket("78.91.16.62", 7899);
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
		
		try{			
			try{	
					out.writeObject(r);
	    			out.reset();
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
	
	public void createCalendarEvent(String avtaleNavn, String leader, Time start, Time slutt, Date dato, Vector<String> invited){
		String oE="opprettEvent";
		
		Request r=new Request(oE,avtaleNavn,leader,start,slutt,dato,invited);
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
	
	
	
	public JComboBox addHoursToJComboBox(JComboBox cb){
		int hour=0;
		for(int i=0;i<24;i++){
			Time t=new Time(hour,00,00);
			cb.addItem(t);
			hour++;
		}
		return cb;
	}
	
	public String convertToJson(Object o){
		//return(xs.toJson(o));
		return("");
	}

}

import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

public class calendarLogic {
	XStream xs = new XStream();

	Socket serverConnection;
    ObjectOutputStream out;
    ObjectInputStream in;
    String fromServer;
    String disconnect="dc";



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
		try{

    		//1. creating a socket to connect to the server
    		serverConnection = new Socket("78.91.16.62", 7899);
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

		try{			
			try{	
					out.writeObject(r);
	    			out.reset();
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


	public String convertToJson(Object o){
		//return(xs.toJson(o));
		return("");
	}

}
