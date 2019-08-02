package EmployeeBookApp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class EmployeeBookFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txt_EmployeeName;
	private JTextField txt_EmployeeID;
	private JTextField txt_Email;
	private JTextField txtDepartment;
	private JTextField txtNameSupervisor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeBookFrame frame = new EmployeeBookFrame();
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
	public EmployeeBookFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 522, 583);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmployeeName = new JLabel("Employee Name:");
		lblEmployeeName.setBounds(10, 92, 92, 14);
		contentPane.add(lblEmployeeName);
		
		txt_EmployeeName = new JTextField();
		txt_EmployeeName.setBounds(106, 89, 234, 20);
		contentPane.add(txt_EmployeeName);
		txt_EmployeeName.setColumns(10);
		
		JLabel lblEmployeeId = new JLabel("Employee ID:");
		lblEmployeeId.setBounds(350, 92, 72, 14);
		contentPane.add(lblEmployeeId);
		
		txt_EmployeeID = new JTextField();
		txt_EmployeeID.setBounds(422, 89, 79, 20);
		contentPane.add(txt_EmployeeID);
		txt_EmployeeID.setColumns(10);
		
		JLabel lblSex = new JLabel("Sex:");
		lblSex.setBounds(8, 124, 85, 14);
		contentPane.add(lblSex);
		
		JRadioButton rdo_Male = new JRadioButton("Male");
		rdo_Male.setBounds(105, 122, 64, 23);
		contentPane.add(rdo_Male);
		
		JRadioButton rdo_Female = new JRadioButton("Female");
		rdo_Female.setBounds(187, 122, 109, 23);
		contentPane.add(rdo_Female);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 160, 72, 14);
		contentPane.add(lblEmail);
		
		txt_Email = new JTextField();
		txt_Email.setColumns(10);
		txt_Email.setBounds(106, 157, 395, 20);
		contentPane.add(txt_Email);
		
		JLabel lblDepartment = new JLabel("Department:");
		lblDepartment.setBounds(10, 198, 92, 14);
		contentPane.add(lblDepartment);
		
		txtDepartment = new JTextField();
		txtDepartment.setColumns(10);
		txtDepartment.setBounds(106, 195, 395, 20);
		contentPane.add(txtDepartment);
		
		JLabel lblNameOfImmediate = new JLabel("Name of Immediate Supervisor:");
		lblNameOfImmediate.setBounds(10, 229, 182, 14);
		contentPane.add(lblNameOfImmediate);
		
		txtNameSupervisor = new JTextField();
		txtNameSupervisor.setColumns(10);
		txtNameSupervisor.setBounds(195, 226, 306, 20);
		contentPane.add(txtNameSupervisor);
		
		JLabel lblProblemCategory = new JLabel("Problem Category:");
		lblProblemCategory.setBounds(10, 271, 109, 14);
		contentPane.add(lblProblemCategory);
		
		JCheckBox chk_Infrastructure = new JCheckBox("Infrastructure");
		chk_Infrastructure.setBounds(131, 267, 109, 23);
		contentPane.add(chk_Infrastructure);
		
		JCheckBox chk_Food = new JCheckBox("Food");
		chk_Food.setBounds(242, 267, 54, 23);
		contentPane.add(chk_Food);
		
		JCheckBox chk_Cab = new JCheckBox("Cab");
		chk_Cab.setBounds(325, 267, 54, 23);
		contentPane.add(chk_Cab);
		
		JCheckBox chk_WorkEnvironment = new JCheckBox("Work Environment");
		chk_WorkEnvironment.setBounds(381, 267, 132, 23);
		contentPane.add(chk_WorkEnvironment);
		
		JLabel lblPleaseDescribeThe = new JLabel("Please describe the details of your grievances:");
		lblPleaseDescribeThe.setBounds(10, 311, 265, 14);
		contentPane.add(lblPleaseDescribeThe);
		
		JTextArea txt_DescribeDetail = new JTextArea();
		txt_DescribeDetail.setBounds(10, 336, 491, 58);
		contentPane.add(txt_DescribeDetail);
		
		JTextArea txt_DescribeSettlement = new JTextArea();
		txt_DescribeSettlement.setBounds(10, 430, 491, 53);
		contentPane.add(txt_DescribeSettlement);
		
		JLabel lblPleaseListThe = new JLabel("Please list the settlement you are requesting:");
		lblPleaseListThe.setBounds(10, 405, 265, 14);
		contentPane.add(lblPleaseListThe);
		
		JLabel lblTheComplaintForm = new JLabel("THE COMPLAINT FORM");
		lblTheComplaintForm.setHorizontalAlignment(SwingConstants.CENTER);
		lblTheComplaintForm.setForeground(UIManager.getColor("Button.darkShadow"));
		lblTheComplaintForm.setFont(new Font("Courier", Font.BOLD, 25));
		lblTheComplaintForm.setBounds(10, 11, 491, 53);
		contentPane.add(lblTheComplaintForm);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(410, 506, 91, 38);
		contentPane.add(btnCancel);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(305, 507, 91, 38);
		contentPane.add(btnSubmit);
	}
}
