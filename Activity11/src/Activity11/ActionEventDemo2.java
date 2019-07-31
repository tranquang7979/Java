package Activity11;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ActionEventDemo2 extends JFrame {

	JButton btn1, btn2;
	JTextField txt;

	public ActionEventDemo2() {
		btn1 = new JButton("Button 1");
		btn2 = new JButton("Button 2");
		txt = new JTextField(10);

		FlowLayout fl = new FlowLayout(FlowLayout.LEFT);
		setLayout(fl);

		add(btn1);
		add(btn2);
		add(txt);
		
		btn1.addActionListener(new Button1Listener());
		
		// cach viet vo danh
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Button 2 is clicked!!");	
				btn2.setText("Button 2 clicked");
			}
		});
		
		btn1.setActionCommand("b1");

		setSize(300, 200);
		setVisible(true);
		setTitle("Event Demo");
	}

	public static void main(String[] args) {
		ActionEventDemo2 d = new ActionEventDemo2();
	}

}
