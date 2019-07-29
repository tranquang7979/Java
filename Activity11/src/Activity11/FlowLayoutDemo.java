package Activity11;

import java.awt.ComponentOrientation;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FlowLayoutDemo extends JFrame {
	
	public FlowLayoutDemo() {
		
		setSize(300,200);
		setVisible(true);
		setTitle("FlowLayoutDemo");
		
		/* 1: center
		 * 2: right to left
		 * 3: left to right
		 * */
		setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
		//setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		for(int i = 0; i < 10; i++)
		{
			JButton btn = new JButton("Button " + i);
			add(btn);
		}
		
		
	}
	
	public static void main(String args[]) {
		FlowLayoutDemo d = new FlowLayoutDemo();
	}
}
