package GUI;


import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.AbstractListModel;

import DBconnection.TimeInterval;

import java.awt.Point;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Vector;
import java.sql.Time;
import java.sql.Date;
import modelPakke.*;


public class createNewMeetingPanel extends JFrame{
	private JTextField meetingNameField;
	private JTextField locationField;
	private calendarLogic cL;
	private Vector<String> invited= new Vector<String>();
	JButton btnDelete;
	JLabel lblUser;
	JLabel userVar;
	JLabel lblDate;
	JLabel room1,room2,room3,room4,room5;
	JComboBox dateCombo;
	JComboBox startCombo;
	JComboBox endCombo;
	 JTextArea descriptionArea;
	 JComboBox roomCombo;
	public createNewMeetingPanel(calendarLogic cl) {
		cL=cl;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setMinimumSize(new Dimension(500, 450));
		setLocation(new Point(800, 400));

		cL.updateRooms();

		JLabel lblMeetingName = new JLabel("Meeting name:");

		
		meetingNameField = new JTextField();
		meetingNameField.setColumns(10);


		JLabel lblMemberList = new JLabel("Member list:");


		JList memberList = new JList();
		memberList.setModel(new AbstractListModel() {
			public int getSize() {
				return invited.size();
			}
			public Object getElementAt(int index) {
				return invited.get(index);
			}
		});
		
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new GUI.addMembersToMeeting(cL).setVisible(true);
				System.out.println("dafuq");
			}
		});


		btnDelete = new JButton("Delete");

		descriptionArea = new JTextArea();
		
		lblUser = new JLabel("User:");


		userVar = new JLabel("New label");
		userVar.setEnabled(false);


		lblDate = new JLabel("Date:");


		dateCombo = new JComboBox();
		cL.addDatesToJComboBox(dateCombo);

		JLabel lblStart = new JLabel("Start:");
		

		JLabel lblEnd = new JLabel("End:");


		startCombo = new JComboBox();
		cL.addHoursToJComboBox(startCombo);

		endCombo = new JComboBox();
		cL.addHoursToJComboBox(endCombo);

		JScrollPane scrollPane = new JScrollPane();


		JLabel lblDescription = new JLabel("Description:");


		JLabel lblRoom = new JLabel("Room:");

		roomCombo = new JComboBox(cL.getRooms().toArray());
		
		
		
		JLabel lblLocation = new JLabel("Location:");


		locationField = new JTextField();
		locationField.setColumns(10);


		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					cL.createCalendarEvent((Room)roomCombo.getSelectedItem(),meetingNameField.getText(), cL.getUser().getUserName(), (Time)startCombo.getSelectedItem(), (Time)endCombo.getSelectedItem(),(Date)dateCombo.getSelectedItem(),descriptionArea.getText(),locationField.getText());
				
				dispose();
			}
		});


		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnAdd, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(140)
							.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblUser)
								.addComponent(userVar)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(memberList, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
									.addComponent(lblMemberList)))
							.addGap(31)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDescription)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addComponent(lblMeetingName)
											.addComponent(dateCombo, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addGroup(groupLayout.createSequentialGroup()
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
													.addComponent(lblStart)
													.addComponent(startCombo, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
													.addComponent(lblEnd)
													.addComponent(endCombo, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))
											.addComponent(meetingNameField))
										.addComponent(lblDate))
									.addGap(40)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(locationField, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
										.addComponent(lblLocation)
										.addComponent(roomCombo, 0, 114, Short.MAX_VALUE)
										.addComponent(lblRoom))))))
					.addGap(8))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblUser)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(userVar)
							.addGap(17)
							.addComponent(lblMemberList)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMeetingName)
								.addComponent(lblRoom))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(meetingNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(roomCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDate)
								.addComponent(lblLocation))
							.addGap(6)))
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(memberList, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(dateCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(15)
											.addComponent(lblStart)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(startCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(endCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(16)
											.addComponent(lblEnd)))
									.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
									.addComponent(lblDescription)
									.addGap(5))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(locationField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAdd)
						.addComponent(btnDelete)
						.addComponent(btnCancel)
						.addComponent(btnSave))
					.addGap(113))
		);


		
		descriptionArea.setLineWrap(true);
		scrollPane.setViewportView(descriptionArea);
		getContentPane().setLayout(groupLayout);
	}
}
