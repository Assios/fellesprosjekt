package modelPakke;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.*;

public class testGUI extends JPanel implements ActionListener {
  JButton sendButton;
	JLabel sL;
	JTextArea fromServer;
	JList jL=new JList();
	calendarLogic cL=new calendarLogic();
	User u;
	Meeting m;
	Room r;
	
	public testGUI(){
		this.setLayout(getLayout());
		sendButton=new JButton("Send");
		sL=new JLabel("Recieved from server: ");
		fromServer=new JTextArea(25,25);
		add(sendButton);
		add(sL);
		add(fromServer);
		sendButton.addActionListener(this);
		u=new User("jimmy", "hadhagds",new Date(22,22,22));
		m=new Meeting(new Date(22,22,22),new Date(33,33,33));
		r=new Room(3, "rom");
		
		
	}
	
	public void actionPerformed(ActionEvent e) {   // This method is called by JButton.
		fromServer.setText( cL.connect(u));
    }
	
	 public static void main (String args[]) {
	        JFrame frame = new JFrame("Test");
	        frame.getContentPane().add(new testGUI());
	        frame.pack(); 
	        frame.setVisible(true);  
	    
	 }
}
