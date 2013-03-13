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
		
		JLabel lblStyremte = new JLabel("meetingTitle:");
		lblStyremte.setHorizontalAlignment(SwingConstants.CENTER);
		lblStyremte.setVerticalAlignment(SwingConstants.TOP);
		lblStyremte.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblMemberList = new JLabel("Member list:");
		
		JList list = new JList();
		
		JLabel lblNewLabel = new JLabel("Date:");
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setEnabled(false);
		
		JLabel lblStart = new JLabel("Start:");
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setEnabled(false);
		
		JLabel lblEnd = new JLabel("End:");
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setEnabled(false);
		
		JLabel lblLocation = new JLabel("Location:");
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setEnabled(false);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnAccept = new JButton("Accept");
		
		JButton btnDecline = new JButton("Decline");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblMemberList))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(list, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(lblNewLabel)
											.addComponent(lblNewLabel_1)
											.addComponent(lblLocation)
											.addComponent(lblNewLabel_4))
										.addPreferredGap(ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(lblNewLabel_3)
											.addComponent(lblEnd)
											.addComponent(lblNewLabel_2)
											.addComponent(lblStart)))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblStyremte)
										.addPreferredGap(ComponentPlacement.RELATED))))))
					.addContainerGap(68, GroupLayout.PREFERRED_SIZE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(101, Short.MAX_VALUE)
					.addComponent(btnAccept)
					.addGap(18)
					.addComponent(btnDecline)
					.addGap(100))
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
						.addComponent(list, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(lblStart))
							.addGap(3)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2))
							.addGap(11)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEnd)
								.addComponent(lblLocation))
							.addGap(2)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_4))
							.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAccept)
						.addComponent(btnDecline))
					.addContainerGap())
		);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		getContentPane().setLayout(groupLayout);
	}
}
