package Activity11;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ActionEventDemo3 extends JFrame {

	JLabel lblHome, lblServices, lblFAQs;

	public ActionEventDemo3() {
		lblHome = new JLabel("HOME");
		lblServices = new JLabel("SERVICES");
		lblFAQs = new JLabel("FAQs");

		FlowLayout fl = new FlowLayout(FlowLayout.LEFT);
		setLayout(fl);

		add(lblHome);
		add(lblServices);
		add(lblFAQs);
		
		lblHome.addMouseListener(new LabelListener(lblHome));
		lblServices.addMouseListener(new LabelListener(lblServices));
		lblFAQs.addMouseListener(new LabelListener(lblFAQs));
		
		setSize(300, 200);
		setVisible(true);
		setTitle("Event Demo");
	}

	public static void main(String[] args) {
		ActionEventDemo3 d = new ActionEventDemo3();
	}

}
