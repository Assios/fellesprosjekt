package modelPakke;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;


import javax.swing.*;

import com.google.gson.Gson;


public class testGUI extends JPanel{
  JButton sendButton;
	JButton connectButton;
	JButton disconnectButton;
	JLabel sL;
	JTextArea fromServer;
	calendarLogic cL=new calendarLogic();
	String userJson;
	Meeting m;
	Room r;


	public testGUI(){
			this.setLayout(getLayout());
		sendButton=new JButton("Send");
		connectButton=new JButton("Connect");
		disconnectButton=new JButton("Disconnect");
		sL=new JLabel("Recieved from server: ");
		fromServer=new JTextArea(25,25);
		add(sendButton);
		add(connectButton);
		add(disconnectButton);
		add(sL);
		add(fromServer);
		//JSON converter
		Gson gson = new Gson();
		User user = new User("John Doe", "john@gmail.com", new Date(1992, 23, 05));
		
		userJson = gson.toJson(user);
		
		r=new Room(3, "rom");
		connectButton.addActionListener(new connectButtonAction());
		disconnectButton.addActionListener(new disconnectButtonAction());
		sendButton.addActionListener(new sendButtonAction());

	}





	class sendButtonAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {        
				cL.send(userJson);
        }
    }


	class disconnectButtonAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {        
            	cL.disConnect();
        }
    }


	class connectButtonAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try{
            	cL.connect(userJson);
            }
            catch(Exception e1){
            	System.out.println("no connection");
            }
        }
    }
	 public static void main (String args[]) {
	        JFrame frame = new JFrame("Test");
	        frame.getContentPane().add(new testGUI());
	        frame.pack(); 
	        frame.setVisible(true);  

	 }
}

