package GUI;


import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Point;
import modelPakke.*;


public class loginPanel extends JFrame{
	private JPasswordField passwordField;
	private JTextField usernameField;
	private calendarLogic cL;
	public loginPanel() {
		setTitle("Login");
		setLocation(new Point(800, 400));
		setMinimumSize(new Dimension(200, 200));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		passwordField = new JPasswordField();

		cL=new calendarLogic();
		cL.connect();
		usernameField = new JTextField();
		usernameField.setColumns(10);


		JLabel lblUsername = new JLabel("Username:");


		JLabel lblPassword = new JLabel("Password:");


		JButton btnLogIn = new JButton("Log in");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String result=cL.requestLogin(usernameField.getText(),String.valueOf(passwordField.getPassword()));
				if(result.equals("valid")){
					cL.updateMeetings();
					if(cL.getEvents()!=null){
						new GUI.MainscreenPanel(cL).setVisible(true);
					}
					else
						System.out.println("...");
					
				}
				else{
					JOptionPane.showMessageDialog(null,result);
					usernameField.setText("");
					passwordField.setText("");
				}
				dispose();
			}
		});




		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnLogIn)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnCancel))
						.addComponent(lblPassword)
						.addComponent(lblUsername)
						.addComponent(passwordField)
						.addComponent(usernameField))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblUsername)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(usernameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPassword)
					.addGap(5)
					.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLogIn)
						.addComponent(btnCancel))
					.addGap(48))
		);
		getContentPane().setLayout(groupLayout);
	}
}
