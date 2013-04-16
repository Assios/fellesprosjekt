package GUI;


//lol

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.util.ArrayList;

import modelPakke.*;


public class addMembersToMeeting extends JFrame{
	calendarLogic cL;
	ArrayList<User> addedArrayL=new ArrayList<User>();
	ArrayList<User> availableArrayL;
	JList availableList;
	JList addedList;
	JButton btnRight;
	JButton btnLeft;
	JLabel lblAvailableMembers;
	JLabel lblMembersInMeeting;
	JButton btnOK;
	JButton btnCancel;
	public addMembersToMeeting(calendarLogic cL) {
		this.cL=cL;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setMinimumSize(new Dimension(420, 320));
		setLocation(new Point(800, 400));
		
		availableArrayL=(ArrayList<User>)cL.getAvailableMembers().clone();
		/*
		availableArrayL=new ArrayList<User>();
		User u1,u2,u3,u4,u5;
		
		u1=new User("u1","dsdff","fdsgdsf", "dfgdg", new Date(100));
		u2=new User("u2","dsdff","fdsgdsf", "dfgdg", new Date(100));
		u3=new User("u3","dsdff","fdsgdsf", "dfgdg", new Date(100));
		u4=new User("u4","dsdff","fdsgdsf", "dfgdg", new Date(100));
		u5=new User("u5","dsdff","fdsgdsf", "dfgdg", new Date(100));

		availableArrayL.add(u1);
		availableArrayL.add(u2);
		availableArrayL.add(u3);
		availableArrayL.add(u4);
		availableArrayL.add(u5);
		*/
		
		availableList = new JList(availableArrayL.toArray());
		
		availableList.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		

		addedList = new JList(addedArrayL.toArray());
		addedList.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		

		btnRight = new JButton(">>");
		btnRight.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		btnRight.addActionListener(new addAction()); 


		btnLeft = new JButton("<<");
		btnLeft.addActionListener(new removeAction());
		btnLeft.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));


		lblAvailableMembers = new JLabel("Available members:");


		lblMembersInMeeting = new JLabel("Members in meeting:");


		btnOK = new JButton("OK");
		btnOK.addActionListener(new saveAction());
		btnOK.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));


		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		makeLayout();
	}

	
	 
	 public void makeLayout(){
		 GroupLayout groupLayout = new GroupLayout(getContentPane());
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(availableList, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(btnRight)
											.addComponent(btnLeft)))
									.addComponent(lblAvailableMembers))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblMembersInMeeting)
									.addComponent(addedList, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)))
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(127)
								.addComponent(btnOK, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnCancel)))
						.addContainerGap(25, Short.MAX_VALUE))
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addContainerGap(17, Short.MAX_VALUE)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblAvailableMembers)
									.addComponent(lblMembersInMeeting))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(availableList, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
									.addComponent(addedList, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)))
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(80)
								.addComponent(btnRight)
								.addGap(18)
								.addComponent(btnLeft)
								.addGap(76)))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnCancel)
							.addComponent(btnOK))
						.addContainerGap())
			);
			getContentPane().setLayout(groupLayout);
	 }
	 
	 class removeAction implements ActionListener{
		 public void actionPerformed(ActionEvent e){
			 
			 int selectedIndex=addedList.getSelectedIndex();
			 if(selectedIndex>=0){
			 System.out.println(selectedIndex);
			 	availableArrayL.add(addedArrayL.get(selectedIndex));
	            addedArrayL.remove(selectedIndex);
	            addedList.setListData(addedArrayL.toArray());
	            availableList.setListData(availableArrayL.toArray());
	            System.out.println("hh");
			 }
		 }
	 }
	 
	 class addAction implements ActionListener {
	        public void actionPerformed(ActionEvent e) {
	        	if(availableList.getSelectedIndex()>=0){
	        	 System.out.println(availableList.getSelectedIndex());
	            addedArrayL.add((User)availableList.getSelectedValue());
	            availableArrayL.remove((User)availableList.getSelectedValue());
	            addedList.setListData(addedArrayL.toArray());
	            availableList.setListData(availableArrayL.toArray());
	        	}
	        }
	    } 
	 
	 class saveAction implements ActionListener{
		 public void actionPerformed(ActionEvent e){
			 cL.makeInvites(addedArrayL);
			 dispose();
		 }
	 }
}
