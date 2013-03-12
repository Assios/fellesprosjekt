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

public class createNewMeetingPanel extends JFrame{
	private JTextField textField;
	public createNewMeetingPanel() {
		
		JLabel lblMeetingName = new JLabel("Meeting name:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblMemberList = new JLabel("Member list:");
		
		JList list = new JList();
		
		JButton btnNewButton = new JButton("Add");
		
		JButton btnNewButton_1 = new JButton("Delete");
		
		JLabel lblUser = new JLabel("User:");
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setEnabled(false);
		
		JLabel lblNewLabel_1 = new JLabel("Date:");
		
		JComboBox comboBox = new JComboBox();
		
		JLabel lblStart = new JLabel("Start:");
		
		JLabel lblEnd = new JLabel("End:");
		
		JComboBox comboBox_1 = new JComboBox();
		
		JComboBox comboBox_2 = new JComboBox();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblUser)
								.addComponent(lblNewLabel)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(list, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
									.addComponent(lblMemberList)))
							.addGap(31)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
								.addComponent(lblMeetingName)
								.addComponent(comboBox, 0, 99, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblStart)
										.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblEnd)
										.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))))))
					.addGap(547))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblUser)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel)
					.addGap(17)
					.addComponent(lblMemberList)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(list, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(15)
									.addComponent(lblStart)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(16)
									.addComponent(lblEnd)))
							.addGap(182)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(119, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblMeetingName)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_1)
					.addGap(405))
		);
		getContentPane().setLayout(groupLayout);
	}
}
