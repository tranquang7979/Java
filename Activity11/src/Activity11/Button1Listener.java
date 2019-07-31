package Activity11;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Button1Listener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JOptionPane.showMessageDialog(null, "Button 1 is clicked!!");	
		
		JButton btn = (JButton)arg0.getSource();
		btn.setText("Button clicked");
	}

}
