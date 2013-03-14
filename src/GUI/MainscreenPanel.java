package GUI;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
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

public class MainscreenPanel extends JFrame{
	private JTable kalender;
	public MainscreenPanel() {
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
			}
		});
		
		JButton Edit = new JButton("Edit");
		Edit.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JButton Detailes = new JButton("Details");
		Detailes.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		kalender = new JTable();
		kalender.setForeground(Color.BLACK);
		kalender.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		kalender.setRowSelectionAllowed(false);
		kalender.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		kalender.setToolTipText("");
		kalender.setModel(new DefaultTableModel(
			new Object[][] {
				{"Time", "Mandag", "Tirsdag", "Onsdag", "Torsdag", "Fredag", "L\u00F8rdag", "S\u00F8ndag"},
				{"09-10", null, null, null, null, null, null, null},
				{"10-11", null, null, null, null, null, null, null},
				{"11-12", null, null, null, null, null, null, null},
				{"12-13", null, null, null, null, null, null, null},
				{"13-14", null, null, null, null, null, null, null},
				{"14-15", null, null, null, null, null, null, null},
				{"15-16", null, null, null, null, null, null, null},
				{"16-17", null, null, null, null, null, null, null},
			},
			new String[] {
				"Time", "Mandag", "Tirsdag", "Onsdag", "Torsdag", "Fredag", "L\u00F8rdag", "S\u00F8ndag"
			}
		));
		kalender.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JButton Left = new JButton("<<");
		
		JButton Right = new JButton(">>");
		
		JButton Delete = new JButton("Delete");
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
