package Forms;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class pn_ListEmployee extends JPanel {
	private JTextField textField;
	private JTextField txtPageNo;

	/**
	 * Create the panel.
	 */
	public pn_ListEmployee() {
		setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 67, 430, 278);
		add(scrollPane_1);
		
		JLabel lblTitle = new JLabel("TITLE LIST");
		lblTitle.setBounds(10, 11, 96, 14);
		add(lblTitle);
		
		JLabel lblKeyword = new JLabel("Keywords:");
		lblKeyword.setBounds(10, 36, 61, 14);
		add(lblKeyword);
		
		textField = new JTextField();
		textField.setBounds(70, 33, 290, 23);
		add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(369, 32, 71, 23);
		add(btnSearch);
		
		txtPageNo = new JTextField();
		txtPageNo.setBounds(196, 354, 52, 23);
		add(txtPageNo);
		txtPageNo.setColumns(10);
		
		JButton btnNext = new JButton(">");
		btnNext.setBounds(262, 354, 52, 23);
		add(btnNext);
		
		JButton btnLast = new JButton(">>");
		btnLast.setBounds(324, 354, 52, 23);
		add(btnLast);
		
		JButton btnPrev = new JButton("<");
		btnPrev.setBounds(134, 353, 52, 23);
		add(btnPrev);
		
		JButton btnFirst = new JButton("<<");
		btnFirst.setBounds(72, 353, 52, 23);
		add(btnFirst);

	}
}
