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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Point;
import java.awt.Dimension;

public class showMeetingInfoPanel extends JFrame{
	public showMeetingInfoPanel() {
		setTitle("Meeting");
		setMinimumSize(new Dimension(400, 350));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel lblMeetingheadline = new JLabel("meetingHeadline:");
		lblMeetingheadline.setHorizontalAlignment(SwingConstants.CENTER);
		lblMeetingheadline.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JLabel lblMemberList = new JLabel("Member list:");
		
		JList list = new JList();
		
		JLabel lblCreator = new JLabel("Creator:");
		
		JLabel lblCreatorVar = new JLabel("New label");
		lblCreatorVar.setEnabled(false);
		
		JLabel lblDate = new JLabel("Date:");
		
		JLabel lblDateVar = new JLabel("New label");
		lblDateVar.setEnabled(false);
		
		JLabel lblStart = new JLabel("Start:");
		
		JLabel lblStartVar = new JLabel("New label");
		lblStartVar.setEnabled(false);
		
		JLabel lblEnd = new JLabel("End:");
		
		JLabel lblEndVar = new JLabel("New label");
		lblEndVar.setEnabled(false);
		
		JLabel lblRoom = new JLabel("Room:");
		
		JLabel lblRoomVar = new JLabel("New label");
		lblRoomVar.setEnabled(false);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblMemberList))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(97)
							.addComponent(lblMeetingheadline))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(list, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblCreator)
										.addComponent(lblCreatorVar)
										.addComponent(lblDate)
										.addComponent(lblDateVar))
									.addGap(28)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblEndVar)
										.addComponent(lblEnd)
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblStartVar)
												.addComponent(lblStart))
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblRoomVar)
												.addComponent(lblRoom))))
									.addGap(18))
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(10)
									.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)))))
					.addGap(97))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMeetingheadline)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblMemberList)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(list, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblCreator)
										.addComponent(lblStart))
									.addGap(5)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblCreatorVar)
										.addComponent(lblStartVar)
										.addComponent(lblRoomVar))
									.addGap(9)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblDate)
										.addComponent(lblEnd))
									.addGap(3)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblDateVar)
										.addComponent(lblEndVar)))
								.addComponent(lblRoom))
							.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnOk)
					.addGap(18))
		);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		getContentPane().setLayout(groupLayout);
	}
	

}
