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
import java.awt.Point;
import java.awt.Dimension;
import modelPakke.*;


public class MainscreenPanel extends JFrame{
	//private JTable kalender;
	private calendarExample.Cal kalender;
	private calendarLogic cL;
	modelPakke.Calendar calendar;
	public MainscreenPanel(calendarLogic cl) {
		calendar = new modelPakke.Calendar(cl.getEvents(cl.getUser().getUserName()), cl.getUser());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(600, 400));
		setTitle("Mainframe");


		JLabel Kallender = new JLabel("Calendar");
		Kallender.setFont(new Font("Tahoma", Font.BOLD, 17));
		Kallender.setHorizontalAlignment(SwingConstants.CENTER);


		JLabel lblUser = new JLabel("user:");
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 10));


		JLabel navn = new JLabel(cL.getUser().getUserName());
		navn.setFont(new Font("Tahoma", Font.PLAIN, 10));


		JButton New = new JButton("New");
		New.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new createNewMeetingPanel(calendar).setVisible(true);
			}
		});


		JButton Edit = new JButton("Edit");
		Edit.setEnabled(false);
		Edit.setFont(new Font("Tahoma", Font.PLAIN, 10));


		JButton Detailes = new JButton("view");
		Detailes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new viewDayPanel(kalender.getActiveDate(), calendar).setVisible(true);
			}
		});
		Detailes.setFont(new Font("Tahoma", Font.PLAIN, 10));


		kalender = new calendarExample.Cal();
		
		kalender.setBorder(new LineBorder(new Color(0, 0, 0)));
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
								.addComponent(Edit, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
								.addComponent(New, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
								.addComponent(Detailes, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(kalender, GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(141)
							.addComponent(Kallender, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblUser)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(navn, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE))
						.addComponent(Kallender, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(New, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(Edit)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(Detailes))
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
