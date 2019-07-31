package Activity11;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class LoginForm extends JFrame {

	JLabel lbl;
	JTextField txt;
	JLabel lblMsg;

	public LoginForm() {
		lbl = new JLabel("Yourname:");
		lblMsg = new JLabel();
		txt = new JTextField(10);

		lblMsg.setForeground(Color.RED);
		
		FlowLayout fl = new FlowLayout(FlowLayout.LEFT);
		setLayout(fl);

		add(lbl);
		add(txt);
		add(lblMsg);
		
		txt.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == 10)
				{
					String user = txt.getText();
					if(user.length() == 0)
						lblMsg.setText("Username is not left blank!!");
					else
						lblMsg.setText("");
				}
				
			}
		});;
		
		setSize(300, 200);
		setVisible(true);
		setTitle("Event Demo");
	}

	public static void main(String[] args) {
		LoginForm d = new LoginForm();
	}

}
