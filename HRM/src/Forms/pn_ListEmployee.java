package Forms;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import java.awt.Font;

public class pn_ListEmployee extends JPanel {
	private JTextField txtKeyword;
	private JTextField txtPageNo;

	/**
	 * Create the panel.
	 */
	public pn_ListEmployee() {
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 67, 498, 252);
		
		JLabel lblTitle = new JLabel("TITLE LIST");
		lblTitle.setBounds(10, 11, 96, 14);
		
		JLabel lblKeyword = new JLabel("Keywords:");
		lblKeyword.setBounds(10, 36, 61, 14);
		
		txtKeyword = new JTextField();
		txtKeyword.setBounds(70, 33, 357, 23);
		txtKeyword.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(437, 32, 71, 23);
		setLayout(null);
		add(scrollPane_1);
		add(lblTitle);
		add(lblKeyword);
		add(txtKeyword);
		add(btnSearch);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Pagingnation", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 330, 498, 44);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblTotalPage = new JLabel("1,000");
		lblTotalPage.setFont(new Font("Dialog", Font.BOLD, 10));
		lblTotalPage.setBounds(70, 18, 35, 14);
		panel.add(lblTotalPage);
		
		JLabel lbll = new JLabel("Total page:");
		lbll.setFont(new Font("Dialog", Font.PLAIN, 10));
		lbll.setBounds(10, 18, 61, 14);
		panel.add(lbll);
		
		JButton btnFirst = new JButton("<<");
		btnFirst.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnFirst.setBounds(204, 11, 52, 23);
		panel.add(btnFirst);
		
		JButton btnPrev = new JButton("<");
		btnPrev.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPrev.setBounds(266, 11, 52, 23);
		panel.add(btnPrev);
		
		txtPageNo = new JTextField();
		txtPageNo.setBounds(328, 12, 35, 23);
		panel.add(txtPageNo);
		txtPageNo.setHorizontalAlignment(SwingConstants.CENTER);
		txtPageNo.setText("100");
		txtPageNo.setColumns(10);
		
		JButton btnNext = new JButton(">");
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNext.setBounds(374, 11, 52, 23);
		panel.add(btnNext);
		
		JButton btnLast = new JButton(">>");
		btnLast.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLast.setBounds(436, 11, 52, 23);
		panel.add(btnLast);

	}
}
