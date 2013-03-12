package GUI;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JToggleButton;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class createNewMeetingPanel extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	public createNewMeetingPanel() {
		
		JLabel lblMemberList = new JLabel("Member list:");
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		JButton btnAdd = new JButton("Add");
		
		JButton btnDelete = new JButton("Delete");
		
		JLabel lblCreator = new JLabel("Creator:");
		
		JLabel lblCreatorName = new JLabel("New label");
		lblCreatorName.setEnabled(false);
		
		JLabel lblDate = new JLabel("Date:");
		
		JComboBox comboBox = new JComboBox();
		
		JLabel lblStart = new JLabel("Start:");
		
		JComboBox comboBox_1 = new JComboBox();
		
		JLabel lblEnd = new JLabel("End:");
		
		JComboBox comboBox_2 = new JComboBox();
		
		JLabel lblMeetingName = new JLabel("Meeting name:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblRoom = new JLabel("Room:");
		
		JComboBox comboBox_3 = new JComboBox();
		
		JLabel lblLocation = new JLabel("Other location:");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description:");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnNewButton_1 = new JButton("Cancel");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblMeetingName)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(btnDelete))
										.addComponent(list, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
										.addComponent(textField, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
									.addGap(31))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblMemberList)
									.addGap(101)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblCreator)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(lblStart)
												.addGap(28)
												.addComponent(lblEnd))
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
													.addComponent(lblCreatorName)
													.addGroup(groupLayout.createSequentialGroup()
														.addGap(1)
														.addComponent(lblDate))
													.addGroup(groupLayout.createSequentialGroup()
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(comboBox, 0, 97, Short.MAX_VALUE)))
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)))))
									.addGap(66)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblRoom)
										.addComponent(lblLocation)
										.addComponent(textField_1)
										.addComponent(comboBox_3, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
								.addComponent(lblDescription)
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnNewButton_1)))
							.addGap(277))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMeetingName)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMemberList)
						.addComponent(lblCreator))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(list, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblCreatorName)
							.addGap(19)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDate)
								.addComponent(lblRoom))
							.addGap(2)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(16)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblStart)
								.addComponent(lblEnd)
								.addComponent(lblLocation))
							.addGap(1)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(lblDescription)
							.addGap(16)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAdd)
						.addComponent(btnDelete)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addGap(89))
		);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		getContentPane().setLayout(groupLayout);
	}
}
