package modelPakke;

import java.io.*;
import java.net.*;
import java.security.*;
import java.util.Date;

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
    User testUser=new User("blackJack23","Jack", "jack@gmail.com","123456",new Date(22,22,22));

    doComms(Socket server) {
      this.server=server;
    }

    public void run () {
      input="";
      ObjectOutputStream out;
      ObjectInputStream in;
      
     try{
        // Get input from the client
    	  Object o;
    	  Request r;
    	  out = new ObjectOutputStream(server.getOutputStream());
    	  out.flush();
    	  in = new ObjectInputStream(server.getInputStream());
    	  String disconnect="dc";
    	  do{
        		o=in.readObject();
        		System.out.println("Recieved "+o);
    		  	/*
    		  	r=(Request)in.readObject();
        		System.out.println("Waiting for request");
       		 	System.out.println("recieved :"+r.getType()+" "+r.getPassword()+" from "+ server.getInetAddress());
       		 	switch(r.getType()){
       		 	case "login":out.writeObject(returnLoginResult(r.getUserName(),r.getPassword()));
       		 				break;
       		 				}
       		 	
       		 	*/	
       		 	
       		 	
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
    	if(userName.equals(getUsername()) && password.equals(getPassword()))
    		return "valid";
    	
    	else
    		return ("Access denied");	
    }
    
}
