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
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;


import com.thoughtworks.xstream.XStream;

public class calendarServer {
	private int port;
	private String serverAdress;
	private XStream xs = new XStream();
	
	public calendarServer(int port,String serverAdress)
	{
		this.port = port;
		this.serverAdress = serverAdress;
	}
	
	public void startServer()
	{
		try 
		{	
			//Start listening on the ports and adress provided in the constructor
			ServerSocket serverSocket = new ServerSocket(this.port,50,InetAddress.getByName(this.serverAdress));
			System.out.println("WAITING FOR CONNECTIONS ON "+this.serverAdress+":"+this.port);
			
			//Get a new fresh socket for communicating with the client, we dont use the serversocket
			Socket clientSocket = serverSocket.accept();
			//Print out the adress and socket of the client socket. You will see that the port is different, this is because the serversocket uses the 7899
			//port, so the client is assigned an unused port
			System.out.println("CONNECTED TO CLIENT ON "+clientSocket.getRemoteSocketAddress());
			OutputStream clientOutputStream = clientSocket.getOutputStream();
			//This is commented in the HelloWorldClient class
			InputStream clientInputStream = clientSocket.getInputStream();
			ObjectOutputStream oos = new ObjectOutputStream(clientOutputStream);
			ObjectInputStream ois = new ObjectInputStream(clientInputStream); 
			PrintWriter outToClient = new PrintWriter(clientOutputStream,true);
			System.out.println("WAITING FOR MESSAGE FROM CLIENT");
			
			String fromClient=String.valueOf(ois.readObject());
			System.out.println("from client "+clientSocket.getInetAddress()+""+fromClient);
			oos.writeObject(fromClient);
			outToClient.write("Melding mottat");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void connectToDatabase(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		}
	 
		System.out.println("MySQL JDBC Driver Registered!");
		Connection connection = null;
	 
		try {
			connection = DriverManager
			.getConnection("jdbc:mysql://127.0.0.1:3306/mydb","root", "password");
	 
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}
	 
		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}

	}
	
	public static void main(String[] args) 
	{
		new calendarServer(7899, "78.91.18.220").startServer();
	}
}

