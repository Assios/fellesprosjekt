package GUI;

//lol
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class addMembersToMeeting extends JFrame{
	public addMembersToMeeting() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setMinimumSize(new Dimension(420, 320));
		setLocation(new Point(800, 400));
		
		JList availableList = new JList();
		availableList.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		
		JList addedList = new JList();
		addedList.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		
		JButton btnRight = new JButton(">>");
		btnRight.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		
		JButton btnLeft = new JButton("<<");
		btnLeft.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		
		JLabel lblAvailableMembers = new JLabel("Available members:");
		
		JLabel lblMembersInMeeting = new JLabel("Members in meeting:");
		
		JButton btnOK = new JButton("OK");
		btnOK.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
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

}
