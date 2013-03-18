package modelPakke;






import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;


import javax.swing.*;


public class testGUI extends JPanel{
  JButton sendButton;
	JButton connectButton;
	JButton disconnectButton;
	JLabel sL;
	JTextArea fromServer;
	JList jL=new JList();
	calendarLogic cL=new calendarLogic();
	ListSelectionModel listSelectionModel;
	User u;
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
		u=new User("jimmy", "hadhagds",new Date(22,22,22));
		//Meeting starting 13.03.2013 at 20:30, ending 21:00
		m=new Meeting(new Date(2013, 03,13, 20, 30), new Date(2013,03,13, 21, 00));
		r=new Room(3, "rom");


		jL.setCellRenderer(new calendarListCellRenderer());
		jL.getCellRenderer().getListCellRendererComponent(jL, u, 0, true,true);
		add(jL);
		connectButton.addActionListener(new connectButtonAction());
		disconnectButton.addActionListener(new disconnectButtonAction());
		sendButton.addActionListener(new sendButtonAction());






	}


	public void setModel(DefaultListModel defaultLModel){
		jL.setModel(defaultLModel);
		jL.setCellRenderer(new calendarListCellRenderer());
		listSelectionModel=jL.getSelectionModel();
		//listSelectionModel.addListSelectionListener(new SharedListSelectionHandler());
	}


	class sendButtonAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {        
            	cL.send(u);
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
            	cL.connect(u);
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

