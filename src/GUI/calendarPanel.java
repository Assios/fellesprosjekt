package GUI;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.BorderLayout;

public class calendarPanel extends JFrame{
	private JTable table;
	public calendarPanel() {
		
		table = new JTable();
		getContentPane().add(table, BorderLayout.CENTER);
	}

}
