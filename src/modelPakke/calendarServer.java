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
	ServerSocket providerSocket;
    Socket connection = null;
    ObjectOutputStream out;
    ObjectInputStream in;
    String message;
    int port;
    String serverAdress;

	
	public calendarServer(int port,String serverAdress)
	{
		this.port = port;
		this.serverAdress = serverAdress;
	}
	
	public void startServer()
	{
		try{
    		System.out.println("Waiting for connection3");

    		//1. creating a server socket
    		providerSocket = new ServerSocket(this.port,50,InetAddress.getByName(this.serverAdress));
    		//2. Wait for connection
    		System.out.println("Waiting for connection");
    		connection = providerSocket.accept();
    		System.out.println("Connection received from " + connection.getInetAddress().getHostName());
    		//3. get Input and Output streams
    		out = new ObjectOutputStream(connection.getOutputStream());
    		out.flush();
    		in = new ObjectInputStream(connection.getInputStream());
    		sendMessage("Connected");
    		//4. The two parts communicate via the input and output streams
    		do{
    			try{
    				message = (String)in.readObject();
    				System.out.println("client:"+connection.getLocalPort()+">" + message);
    				if (message.equals("dc"))
    					sendMessage("dc");
    				else{
    					sendMessage("melding mottat");
    				}
    			}
    			catch(ClassNotFoundException classnot){
    				System.err.println("Data received in unknown format");
    			}
    		}while(!message.equals("dc"));
    	}
    	catch(IOException ioException){
    		ioException.printStackTrace();
    	}
    	finally{
    		//4: Closing connection
    		try{
    			in.close();
    			out.close();
    			providerSocket.close();
    		}
    		catch(IOException ioException){
    			ioException.printStackTrace();
    		}
    	}
    }
    void sendMessage(String msg)
    {
    	try{
    		out.writeObject(msg);
    		out.flush();
    		System.out.println("server>" + msg);
    	}
    	catch(IOException ioException){
    		ioException.printStackTrace();
    	}
    }

	
	public static void main(String[] args) 
	{
		new calendarServer(7899, "78.91.18.220").startServer();
	}
}

