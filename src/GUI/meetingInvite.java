package GUI;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class meetingInvite extends JFrame{
	public meetingInvite() {
		setTitle("Meeting");
		
		JLabel lblStyremte = new JLabel("meetingTitle:");
		lblStyremte.setHorizontalAlignment(SwingConstants.CENTER);
		lblStyremte.setVerticalAlignment(SwingConstants.TOP);
		lblStyremte.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblMemberList = new JLabel("Member list:");
		
		JList memberList = new JList();
		
		JLabel lblDate = new JLabel("Date:");
		
		JLabel dateVar = new JLabel("New label");
		dateVar.setEnabled(false);
		
		JLabel lblStart = new JLabel("Start:");
		
		JLabel startVar = new JLabel("New label");
		startVar.setEnabled(false);
		
		JLabel lblEnd = new JLabel("End:");
		
		JLabel endVar = new JLabel("New label");
		endVar.setEnabled(false);
		
		JLabel lblLocation = new JLabel("Location:");
		
		JLabel locationVar = new JLabel("New label");
		locationVar.setEnabled(false);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnAccept = new JButton("Accept");
		
		JButton btnDecline = new JButton("Decline");
		
		JLabel lblRoom = new JLabel("Room:");
		
		JLabel lblRoomVar = new JLabel("New label");
		lblRoomVar.setEnabled(false);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMemberList)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(memberList, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblStyremte)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnAccept)
									.addGap(18)
									.addComponent(btnDecline))
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(lblDate)
											.addComponent(dateVar)
											.addComponent(lblLocation)
											.addComponent(locationVar))
										.addGap(18)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(endVar)
											.addComponent(lblEnd)
											.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
													.addComponent(lblStart)
													.addComponent(startVar))
												.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
													.addComponent(lblRoomVar)
													.addComponent(lblRoom)))))
									.addComponent(scrollPane, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)))))
					.addGap(68))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblStyremte)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblMemberList)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(memberList, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblDate)
									.addGap(3)
									.addComponent(dateVar)
									.addGap(11)
									.addComponent(lblLocation)
									.addGap(2)
									.addComponent(locationVar))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblStart)
										.addComponent(lblRoom))
									.addGap(3)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(startVar)
										.addComponent(lblRoomVar))
									.addGap(11)
									.addComponent(lblEnd)
									.addGap(2)
									.addComponent(endVar)))
							.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAccept)
						.addComponent(btnDecline))
					.addContainerGap())
		);
		
		JTextArea descriptionArea = new JTextArea();
		descriptionArea.setLineWrap(true);
		scrollPane.setViewportView(descriptionArea);
		getContentPane().setLayout(groupLayout);
	}
}
