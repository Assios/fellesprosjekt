package modelPakke;

import java.io.*;
import java.net.*;
import java.security.*;

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
	
	String disconnect="dc";
  private static int port=7899, maxConnections=4;
  
  
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

    doComms(Socket server) {
      this.server=server;
    }

    public void run () {

      input="";
      ObjectOutputStream out;
      ObjectInputStream in;
      
     try{
        // Get input from the client
    	  Object object;
    	  out = new ObjectOutputStream(server.getOutputStream());
    	  out.flush();
    	  in = new ObjectInputStream(server.getInputStream());
    	  
    	  

       
        	
        	do{
        		object=in.readObject();
        		System.out.println(object);
        		
        		System.out.println("Waiting for object");
       		 	System.out.println("recieved :"+String.valueOf(object)+"from "+ server.getInetAddress());
       		 	out.writeObject(object);
       		 	out.flush();
       		 	out.reset();
        	}while(String.valueOf(object)!="dc");	
        	 
        	closeConnection(out);        
        	
        
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
    
}

