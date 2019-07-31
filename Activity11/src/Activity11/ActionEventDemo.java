package Activity11;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ActionEventDemo extends JFrame implements ActionListener, KeyListener {

	JButton btn1, btn2;
	JTextField txt;

	public ActionEventDemo() {
		btn1 = new JButton("Button 1");
		btn2 = new JButton("Button 2");
		txt = new JTextField(10);

		FlowLayout fl = new FlowLayout(FlowLayout.LEFT);
		setLayout(fl);

		add(btn1);
		add(btn2);
		add(txt);

		btn1.addActionListener(this);
		btn2.addActionListener(this);
		txt.addKeyListener(this);

		btn1.setActionCommand("b1");
		btn2.setActionCommand("b2");

		setSize(300, 200);
		setVisible(true);
		setTitle("Event Demo");
	}

	public static void main(String[] args) {
		ActionEventDemo d = new ActionEventDemo();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String cmd = e.getActionCommand();
		if (cmd.equals("b1"))
			JOptionPane.showMessageDialog(null, "Button 1 is clicked!!");
		else
			JOptionPane.showMessageDialog(null, "Button 2 is clicked!!");

		JButton btn = (JButton) e.getSource();
		if (btn.getText().equals("Button 1"))
			JOptionPane.showMessageDialog(null, "Button 1 is clicked!!");
		else
			JOptionPane.showMessageDialog(null, "Button 2 is clicked!!");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() != 10)
			JOptionPane.showMessageDialog(null, "keyPressed: code (" + e.getKeyCode() + ") - char(" + e.getKeyChar() + ")");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() != 10)
			JOptionPane.showMessageDialog(null, "keyPressed: code (" + e.getKeyCode() + ") - char(" + e.getKeyChar() + ")");
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getKeyCode() != 10)
			JOptionPane.showMessageDialog(null, "keyPressed: code (" + e.getKeyCode() + ") - char(" + e.getKeyChar() + ")");
	}

}
