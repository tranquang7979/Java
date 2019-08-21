package Acitivity15.ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;

import Acitivity15.Student;

public class StudentListFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtName;
	private JLabel Address;
	private JTextField txtAddress;
	private JLabel lblId;
	private JTextField txtId;
	TableModelCustom model;
	Vector<String> columnNames = new Vector<String>();
	Vector<Student> rows = new Vector<Student>();	
	
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
		
		// CUSTOM MODEL, DEFINE CELL
		columnNames.add("Id");
		columnNames.add("Name");
		columnNames.add("Address");
		//model = new DefaultTableModel(rows, columnNames);
		model = new TableModelCustom(rows);		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(28, 52, 46, 14);
		contentPane.add(lblName);
		
		txtName = new JTextField();
		txtName.setBounds(85, 49, 86, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		Address = new JLabel("Address");
		Address.setBounds(28, 80, 46, 14);
		contentPane.add(Address);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(85, 77, 86, 20);
		contentPane.add(txtAddress);
		
		lblId = new JLabel("Id");
		lblId.setBounds(28, 24, 46, 14);
		contentPane.add(lblId);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(85, 21, 86, 20);
		contentPane.add(txtId);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(181, 76, 91, 23);
		contentPane.add(btnSave);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 109, 422, 154);
		contentPane.add(scrollPane);
		
		table = new JTable(model);
		scrollPane.setViewportView(table);
		

		TableColumn column = table.getColumnModel().getColumn(2);
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Snowboarding");
		comboBox.addItem("Rowing");
		comboBox.addItem("Chasing toddlers");
		comboBox.addItem("Speed reading");
		comboBox.addItem("Teaching high school");
		comboBox.addItem("None");
		column.setCellEditor(new DefaultCellEditor(comboBox));
		
		
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {				
				Student s = new Student();
				s.setId(txtId.getText());
				s.setName(txtName.getText());
				s.setAddress(txtAddress.getText());
				model.addRow(s);
			}
		});
	}
}
