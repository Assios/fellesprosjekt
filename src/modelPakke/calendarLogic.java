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

