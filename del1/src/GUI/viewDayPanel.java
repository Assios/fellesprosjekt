package GUI;

import java.util.Date;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;

import modelPakke.calendarLogic;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class viewDayPanel extends JFrame {
	
	public viewDayPanel(Date day, modelPakke.Calendar calendar) {
		final modelPakke.Calendar Calendar = calendar;

		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JButton btnEdit = new JButton("edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//new editMeetingPanel(selected meeting).setVisible(true);
			}
		});
		
		JButton btnAdd = new JButton("add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new createNewMeetingPanel(Calendar).setVisible(true);
			}
		});
		
		JList list = new JList(Calendar.getMeetingsOfDay(day).toArray());
		
		JButton btnInfo = new JButton("info");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAdd)
						.addComponent(btnOk)
						.addComponent(btnInfo)
						.addComponent(btnEdit))
					.addContainerGap(216, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(list, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
							.addGap(67))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnAdd)
							.addPreferredGap(ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
							.addComponent(btnEdit)
							.addGap(23)
							.addComponent(btnInfo)
							.addGap(24)
							.addComponent(btnOk)
							.addGap(68))))
		);
		getContentPane().setLayout(groupLayout);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
