* Created on Oct 27, 2004
 */
package no.ntnu.fp.net.co;

import java.io.EOFException;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import no.ntnu.fp.net.admin.Log;
import no.ntnu.fp.net.cl.ClException;
import no.ntnu.fp.net.cl.ClSocket;
import no.ntnu.fp.net.cl.KtnDatagram;
import no.ntnu.fp.net.cl.KtnDatagram.Flag;
import no.ntnu.fp.net.co.AbstractConnection.State;

/**
 * Implementation of the Connection-interface. <br>
 * <br>
 * This class implements the behaviour in the methods specified in the interface
 * {@link Connection} over the unreliable, connectionless network realised in
 * {@link ClSocket}. The base class, {@link AbstractConnection} implements some
 * of the functionality, leaving message passing and error handling to this
 * implementation.
 * 
 * @author Sebjørn Birkeland and Stein Jakob Nordbø
 * @see no.ntnu.fp.net.co.Connection
 * @see no.ntnu.fp.net.cl.ClSocket
 */
public class ConnectionImpl extends AbstractConnection {

    /** Keeps track of the used ports for each server port. */
    private static Map<Integer, Boolean> usedPorts = Collections.synchronizedMap(new HashMap<Integer, Boolean>());
    private ConnectionImpl conn;
    /**
     * Initialise initial sequence number and setup state machine.
     * 
     * @param myPort
     *            - the local port to associate with this connection
     */
    public ConnectionImpl(int myPort) {
      //EGEN KODE
      super();
    	super.myPort=myPort;
       //EGEN KODE
    }

    private String getIPv4Address() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        }
        catch (UnknownHostException e) {
            return "127.0.0.1";
        }
    }

    /**
     * Establish a connection to a remote location.
     * 
     * @param remoteAddress
     *            - the remote IP-address to connect to
     * @param remotePort
     *            - the remote portnumber to connect to
     * @throws IOException
     *             If there's an I/O error.
     * @throws java.net.SocketTimeoutException
     *             If timeout expires before connection is completed.
     * @see Connection#connect(InetAddress, int)
     */
    public void connect(InetAddress remoteAddress, int remotePort) throws IOException,
            SocketTimeoutException {
        //throw new NotImplementedException();
       //EGEN KODE
    	try{
    		
    		KtnDatagram packet=constructInternalPacket(Flag.SYN);    	
    		super.remoteAddress=remoteAddress.getHostAddress();
        	super.remotePort=remotePort;
       
        	simplySendPacket(packet);
        	state=state.SYN_SENT;
        	KtnDatagram ackPacket=receiveAck(true);   	
        	sendAck(ackPacket,false);
        	state=state.ESTABLISHED;
    	}
    	catch(IOException ioe){
    		Log.writeToLog(packet, "IOException: Something went wrong"
                    + "with input/output", "ConnectionImpl");
    	}
    	catch(ClExcepetion cle){
    		Log.writeToLog(packet, "CLException: Could not establish a "
                    + "connection to the specified address/port!", "ConnectionImpl");
    	}
    	catch (EOFException eofe){
    		Log.writeToLog(ackPacket, "CLException: Could not establish a "
                    + "connection to the specified address/port!", "ConnectionImpl");
    	}
    	//SLUTT EGEN KODE
    }

    /**
     * Listen for, and accept, incoming connections.
     * 
     * @return A new ConnectionImpl-object representing the new connection.
     * @see Connection#accept()
     */
    public Connection accept() throws IOException, SocketTimeoutException {
        //throw new NotImplementedException();
       //EGEN KODE
    	boolean noSynReceivedYet=true,noAckReceivedYet=true;
        KtnDatagram synPacket,ackPacket;
        while(noSynReceivedYet){
            packet=receivePacket(true);
            if(synPacket!=null){
            	if(synPacket.getFlag()==Flag.SYN){
            		state=state.SYN_SENT;
            		sendAck(synPacket,true);
            		noSynReceivedYet=false;
            	}
            		
            }
        }
        while(noAckReceivedYet){
        	ackPacket=receivePacket(true);
        	if(ackPacket!=null && ackPacket.getFlag()==Flag.ACK){
        			noAckReceivedYet=false;
        			state = state.ESTABLISHED;       			
        	}
        }
        Connection conn=new ConnectionImpl(ackPacket.getSrc_port);
        conn.
        //SLUTT EGEN KODE
    }

    /**
     * Send a message from the application.
     * 
     * @param msg
     *            - the String to be sent.
     * @throws ConnectException
     *             If no connection exists.
     * @throws IOException
     *             If no ACK was received.
     * @see AbstractConnection#sendDataPacketWithRetransmit(KtnDatagram)
     * @see no.ntnu.fp.net.co.Connection#send(String)
     */
    public void send(String msg) throws ConnectException, IOException {
        throw new NotImplementedException();
    }

    /**
     * Wait for incoming data.
     * 
     * @return The received data's payload as a String.
     * @see Connection#receive()
     * @see AbstractConnection#receivePacket(boolean)
     * @see AbstractConnection#sendAck(KtnDatagram, boolean)
     */
    public String receive() throws ConnectException, IOException {
        throw new NotImplementedException();
        
    }

    /**
     * Close the connection.
     * 
     * @see Connection#close()
     */
    public void close() throws IOException {
        throw new NotImplementedException();
    }

    /**
     * Test a packet for transmission errors. This function should only called
     * with data or ACK packets in the ESTABLISHED state.
     * 
     * @param packet
     *            Packet to test.
     * @return true if packet is free of errors, false otherwise.
     */
    protected boolean isValid(KtnDatagram packet) {
        throw new NotImplementedException();
    }
}