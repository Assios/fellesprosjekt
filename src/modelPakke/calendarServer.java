package modelPakke;

import java.io.*;
import java.net.*;
import java.security.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import java.sql.Date;
import java.sql.Time;
import java.util.Properties;

import DBconnection.*;

/**
 * Title:        Sample Server
 * Description:  This utility will accept input from a socket, posting back to the socket before closing the link.
 * It is intended as a template for coders to base servers on. Please report bugs to brad at kieser.net
 * Copyright:    Copyright (c) 2002
 * Company:      Kieser.net
 * @author B. Kieser
 * @version 1.0
 */

public class calendarServer {
	
  private static int port=7899, maxConnections=10;
  
  // Listen for incoming connections and handle them
  public static void main(String[] args) {
    int i=0;

    try{
      ServerSocket listener = new ServerSocket(port);
      Socket server;
      System.out.println("Waiting for connection on port :"+port);
      while((i++ < maxConnections) || (maxConnections == 0)){
        doComms connection;

        server = listener.accept();
        doComms conn_c= new doComms(server);
        Thread t = new Thread(conn_c);
        t.start();
      }
    } catch (IOException ioe) {
      System.out.println("IOException on socket listen: " + ioe);
      ioe.printStackTrace();
    }
  }

}

class doComms implements Runnable {
    private Socket server;
    private String line,input;
    private Properties prop=new Properties();
   Vector<Integer> eventIndices;
   ArrayList<Events> events;
    KalenderSystemDB kDb;

    User testUser;

    doComms(Socket server) {
      this.server=server;
    }

    public void run () {
      input="";
      ObjectOutputStream out;
      ObjectInputStream in;
      
     try{
    	

        // Get input from the client
    	 prop.setProperty("url","jdbc:mysql://mysql.stud.ntnu.no/tonyc_kalendersystem");
    	 prop.setProperty("jdbcDriver","com.mysql.jdbc.Driver");
    	 prop.setProperty("user","tonyc_test");
    	 prop.setProperty("password","password");
    	 kDb=new KalenderSystemDB(prop);
    	 Object o;
    	  Request r;
    	  out = new ObjectOutputStream(server.getOutputStream());
    	  in = new ObjectInputStream(server.getInputStream());
    	  String disconnect="dc";
    	  	do{
    		  	r=(Request)in.readObject();
        		System.out.println("Waiting for request");
       		 	System.out.println("recieved :"+r.getType()+" "+r.getPassword()+" from "+ server.getInetAddress());
       		 	switch(r.getType()){
       		 	case "login":out.writeObject(returnLoginResult(r.getUserName(),r.getPassword()));
       		 	System.out.println("hh");
       		 				break;
       		 	case "opprettEvent": System.out.println("hit");
       		 		int id;
       		 		id=kDb.createCalenderEvent(r.getAvtaleNavn(), r.getLeader(),r.getStartTime(), r.getEndTime(), r.getDate(), r.getInvited());
       		 		
       		 		kDb.addDescription(id, r.getDescription());
       		 		System.out.println("Hittttt");
       		 	break;
       		 	case "hentEvents": eventIndices=kDb.getEvents(r.getUserName());
       		
       		 				Iterator i = eventIndices.iterator();
       		 				
       		 				while (i.hasNext()) {
       		 					events.add(kDb.getEvent(new Integer(i.next().toString())));
       		 				}
       		 				out.writeObject(events);
       		 	}
       		 	
       		 	
       		 	
       		 	out.flush();
    	  	}while(in!=null);
        
      } catch(Exception e){
    	  System.out.println("IOException on socket listen: " + e);
	      e.printStackTrace();
      }
    }
    
    public void closeConnection(ObjectOutputStream os){
    	try {
    		String disconnect="dc";
    		os.writeObject(disconnect);
			server.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    public String getUsername(){
    	//foreløpig kode til db connection settes opp
    	return testUser.getUserName();
    }
    
    public String getPassword(){
    	//foreløpig kode til db connection settes opp
    	return testUser.getPassword();
    }
    
    public String returnLoginResult(String userName, String password){
    	try {
			if(kDb.loginCheck(userName, password))
				return "valid";
			
			else
				return ("Access denied");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ("Access denied");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ("Access denied");

		}	
    }
    
}

