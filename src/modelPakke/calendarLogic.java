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
import java.util.Date;

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
				
					out.writeObject(convertToXML(object));
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

	public void connect(Object object) {
		try{
			
    		//1. creating a socket to connect to the server
    		serverConnection = new Socket("78.91.19.238", 7899);
    		System.out.println("Connected to 78.91.19.238  in port 7899");
    		//2. get Input and Output streams
    		out = new ObjectOutputStream(serverConnection.getOutputStream());
    		in = new ObjectInputStream(serverConnection.getInputStream());
    		//3: Communicating with the server
		}
    		
    		catch(IOException ioException){
    			ioException.printStackTrace();
    			System.out.println("Hh");
    		}
    	



	}
	
	
	
	
	
	public String convertToXML(Object o){
		return(xs.toXML(o));
	}
}



