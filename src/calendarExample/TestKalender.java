package calendarExample;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;

public class TestKalender {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame f = new JFrame("Cal");
	      Container c = f.getContentPane();
	      c.setLayout(new FlowLayout());
	      Cal noe = new Cal(2013, 3-1, 19);
	      c.add(noe);
	      f.pack();
	      f.setVisible(true);
	      

	}

}
