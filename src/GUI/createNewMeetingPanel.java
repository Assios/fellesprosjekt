package GUI;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.AbstractListModel;

public class createNewMeetingPanel extends JFrame{
	private JTextField meetingNameField;
	private JTextField locationField;
	public createNewMeetingPanel() {
		
		JLabel lblMeetingName = new JLabel("Meeting name:");
		
		meetingNameField = new JTextField();
		meetingNameField.setColumns(10);
		
		JLabel lblMemberList = new JLabel("Member list:");
		
		JList memberList = new JList();
		memberList.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		JButton btnAdd = new JButton("Add");
		
		JButton btnDelete = new JButton("Delete");
		
		JLabel lblUser = new JLabel("User:");
		
		JLabel userVar = new JLabel("New label");
		userVar.setEnabled(false);
		
		JLabel lblDate = new JLabel("Date:");
		
		JComboBox dateCombo = new JComboBox();
		
		JLabel lblStart = new JLabel("Start:");
		
		JLabel lblEnd = new JLabel("End:");
		
		JComboBox startCombo = new JComboBox();
		
		JComboBox endCombo = new JComboBox();
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblDescription = new JLabel("Description:");
		
		JLabel lblRoom = new JLabel("Room:");
		
		JComboBox roomCombo = new JComboBox();
		
		JLabel lblLocation = new JLabel("Location:");
		
		locationField = new JTextField();
		locationField.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		
		JButton btnCancel = new JButton("Cancel");
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
		
		JTextArea descriptionArea = new JTextArea();
		descriptionArea.setLineWrap(true);
		scrollPane.setViewportView(descriptionArea);
		getContentPane().setLayout(groupLayout);
	}
}
