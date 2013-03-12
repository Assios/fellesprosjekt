package GUI;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;

public class createNewMeetingPanel extends JFrame{
	private JTextField textField;
	public createNewMeetingPanel() {
		
		JLabel lblMeetingName = new JLabel("Meeting name:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblMemberList = new JLabel("Member list:");
		
		JList list = new JList();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(list, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
						.addComponent(lblMeetingName)
						.addComponent(lblMemberList)
						.addComponent(textField))
					.addContainerGap(688, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMeetingName)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblMemberList)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(142, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
}
