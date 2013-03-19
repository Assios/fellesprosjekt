package GUI;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import java.awt.Cursor;
import java.awt.Color;
import javax.swing.border.LineBorder;

import calendarExample.Cal;

import java.awt.Point;
import java.awt.Dimension;

public class MainscreenPanel extends JFrame{
	//private JTable kalender;
	private JPanel kalender;
	public MainscreenPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(600, 300));
		setTitle("Mainframe");
		
		JLabel Month = new JLabel("Month");
		Month.setFont(new Font("Tahoma", Font.BOLD, 17));
		Month.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel Uke = new JLabel("Uke");
		Uke.setHorizontalAlignment(SwingConstants.CENTER);
		Uke.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblUser = new JLabel("user:");
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JLabel navn = new JLabel("username'");
		navn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JButton New = new JButton("New");
		New.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new createNewMeetingPanel().setVisible(true);
			}
		});
		
		JButton Edit = new JButton("Edit");
		Edit.setEnabled(false);
		Edit.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JButton Detailes = new JButton("Details");
		Detailes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//new showMeetingInfoPanel(new modelPakke.Meeting().setVisible(true);
				//maa ha tilgang til databasen
			}
		});
		Detailes.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		kalender = new JPanel();
		kalender.add(new Cal(2013, 3-1, 19));
		
		
		JButton Left = new JButton("<<");
		
		JButton Right = new JButton(">>");
		
		JButton Delete = new JButton("Delete");
		Delete.setEnabled(false);
		Delete.setFont(new Font("Tahoma", Font.PLAIN, 10));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(lblUser)
							.addComponent(navn, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(Delete, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(Detailes, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE))
								.addComponent(Edit, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
								.addComponent(New, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(Left)
							.addGap(103)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(Month, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(10)
									.addComponent(Uke, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
									.addComponent(Right))))
						.addComponent(kalender, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblUser)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(navn, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(Right)
							.addGap(10))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(Month, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(Uke)
							.addGap(18))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(Left)
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(New, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(Edit)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(Detailes)
								.addComponent(Delete, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
						.addComponent(kalender, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35))
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
