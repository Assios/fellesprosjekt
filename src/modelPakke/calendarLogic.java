package modelPakke;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Date;

import com.thoughtworks.xstream.XStream;

public class calendarLogic {
  XStream xs = new XStream();
	
	private final static String HOST = "LocalHost";
	private final static int PORT = 4447;
	private String host = HOST;
	private int port = PORT;
	private boolean connection;
	private String username;
	boolean wait=true;
	private PrintWriter outToServer;
	private String responseFromServer;
	private String noConnection="no connection";

	
	public calendarLogic() {
	}




	public void setUserName(String username) {
		this.username = username;
	}




	public boolean getConnectionStatus() {
		return this.connection;
	}



	
	

	public String connect(Object object) {
		try {
			Socket serverConnection = new Socket(InetAddress.getByName("78.91.18.220"),7899);
			System.out.println("CONNECTED TO SERVER");
			
			//Get a reference to the inputstream of the socket, in order to get the data from the other end (this is esentially a stream of bytes)
			InputStream serverInputStream = serverConnection.getInputStream();
			
			//Wrap the raw inputstream into a character stream (from raw bytes to characters)
			InputStreamReader inFromServer = new InputStreamReader(serverInputStream);
			
			//Wrap the character streams into a buffer that enables us to read out one line at a time
			BufferedReader StringFromServer = new BufferedReader(inFromServer);
			ObjectInputStream ois = new ObjectInputStream(serverInputStream);  
			//Get a reference to the outputstream of the socket, in order to send data
			OutputStream serverOutputStream = serverConnection.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(serverOutputStream);
			//Wrap the outputstream into a convenient printwriter object, it enables us to send Strings by using the println method
			System.out.println("SEND SOMETHING NICE TO THE SERVER");
			
			//Read user input (we let the user say something to the server)
			
			
				//get user input
			
				oos.writeObject(convertToXML(object));
				//send the input string
				
				//get for the response from the server
				responseFromServer = String.valueOf(ois.readObject());
				serverConnection.close();
				return responseFromServer ;

				//print the response
				
		} catch (Exception e) {
			// TODO: handle exception
			return noConnection;
		}
		


	}


	
	
	public String convertToXML(Object o){
		return(xs.toXML(o));
	}
}
