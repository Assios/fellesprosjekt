package GUI;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class editMeetingPanel extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	public editMeetingPanel() {
		
		JLabel lblUser = new JLabel("User:");
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setEnabled(false);
		
		JLabel lblMemberList = new JLabel("Member list:");
		
		JList list = new JList();
		
		JButton btnNewButton = new JButton("Add");
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.setEnabled(false);
		
		JLabel lblMeetingName = new JLabel("Meeting name:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblDate = new JLabel("Date:");
		
		JComboBox comboBox = new JComboBox();
		
		JLabel lblStart = new JLabel("Start:");
		
		JComboBox comboBox_1 = new JComboBox();
		
		JLabel lblEnd = new JLabel("End:");
		
		JComboBox comboBox_2 = new JComboBox();
		
		JLabel lblRoom = new JLabel("Room:");
		
		JComboBox roomCombo = new JComboBox();
		
		JLabel lblLocation = new JLabel("Location:");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description:");
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnCancel = new JButton("Cancel");
		
		JButton btnSave = new JButton("Save");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblUser)
								.addComponent(lblNewLabel)
								.addComponent(lblMemberList)
								.addComponent(list, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
							.addGap(35)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDescription)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblStart)
									.addGap(27)
									.addComponent(lblEnd))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblDate)
										.addComponent(textField)
										.addComponent(lblMeetingName)
										.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGap(86)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblLocation)
										.addComponent(roomCombo, 0, 107, Short.MAX_VALUE)
										.addComponent(lblRoom)
										.addComponent(textField_1)))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(btnSave)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(btnCancel))
									.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(151, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUser)
						.addComponent(lblMeetingName)
						.addComponent(lblRoom))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(roomCombo, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMemberList)
						.addComponent(lblDate)
						.addComponent(lblLocation))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(list, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(14)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblStart)
								.addComponent(lblEnd))
							.addGap(2)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addComponent(lblDescription)
							.addGap(7)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1)
						.addComponent(btnCancel)
						.addComponent(btnSave))
					.addContainerGap(89, Short.MAX_VALUE))
		);
		
		JTextArea textDescription = new JTextArea();
		scrollPane.setViewportView(textDescription);
		getContentPane().setLayout(groupLayout);
	}
}
