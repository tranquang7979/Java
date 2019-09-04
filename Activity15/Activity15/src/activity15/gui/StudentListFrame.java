package activity15.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Vector;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class StudentListFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txt_id;
	private JTextField txt_name;
	private JTextField txt_address;
	JScrollPane scrollPane = new JScrollPane();
	DefaultTableModel model ;
	
	Vector<String> columNames = new Vector<String>();

	Vector<Vector> data =new Vector<Vector>();
	
	private JTable table;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentListFrame frame = new StudentListFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StudentListFrame() {
		
		columNames.add("StudentId");
		columNames.add("StudentName");
		columNames.add("StudentAddress");
		
		//student1
		Vector<String> s1=new Vector<String>();
		s1.add("01");
		s1.add("An");
		s1.add("1234");
		
		//student2
				Vector<String> s2=new Vector<String>();
				s2.add("02");
				s2.add("Binh");
				s2.add("123456");
		
				data.add(s1);
				data.add(s2);
				
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(92, 11, 235, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("StudentId");
		lblNewLabel_1.setBounds(10, 66, 101, 14);
		contentPane.add(lblNewLabel_1);
		
		txt_id = new JTextField();
		txt_id.setBounds(121, 63, 206, 20);
		contentPane.add(txt_id);
		txt_id.setColumns(10);
		
		JLabel lblStudentname = new JLabel("StudentName");
		lblStudentname.setBounds(10, 94, 101, 14);
		contentPane.add(lblStudentname);
		
		txt_name = new JTextField();
		txt_name.setColumns(10);
		txt_name.setBounds(121, 91, 206, 20);
		contentPane.add(txt_name);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(10, 122, 101, 14);
		contentPane.add(lblAddress);
		
		txt_address = new JTextField();
		txt_address.setColumns(10);
		txt_address.setBounds(121, 119, 206, 20);
		contentPane.add(txt_address);
		
		JButton btn_save = new JButton("Save");
		btn_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String id =txt_id.getText();
				String name = txt_name.getText();
				String address=txt_address.getText();
				
				
				Vector<String> row = new Vector<String>();
				row.add(id);
				row.add(name);
				row.add(address);
				
				model.addRow(row);
				
				
				
			}
		});
		btn_save.setBounds(121, 150, 91, 23);
		contentPane.add(btn_save);
		
		JLabel lblStudentList = new JLabel("Student List");
		lblStudentList.setBounds(10, 206, 139, 14);
		contentPane.add(lblStudentList);
		
		
		model =new DefaultTableModel(data, columNames);
		table = new JTable(model);
		table.setBounds(0, 0,400 , 100);
		
		scrollPane.setBounds(10, 244, 422, 149);
		contentPane.add(scrollPane);
		scrollPane.add(table);
		scrollPane.setViewportView(table);
		
		
//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//				{null, null, null},
//				{null, null, null},
//			},
//			new String[] {
//				"StudentId", "StudentName", "Address"
//			}
//		));
//		table.getColumnModel().getColumn(0).setPreferredWidth(196);
//		table.getColumnModel().getColumn(1).setPreferredWidth(154);
//		table.getColumnModel().getColumn(2).setPreferredWidth(152);
		
	}
}
