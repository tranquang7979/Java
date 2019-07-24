package Activity11;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JFrameDemo extends JFrame{
	
	private JLabel lblTitle;	
	private JButton btnPlay;
	private JButton btnLeft;
	private JButton btnRight;
	private JButton btnBottom;
	
	public JFrameDemo() {

		lblTitle = new JLabel();
		lblTitle.setText("Classic Jumble Word");
		
		btnPlay = new JButton();
		btnPlay.setText("Play");

		btnLeft = new JButton("LEFT");
		btnRight = new JButton("RIGHT");
		btnBottom = new JButton("BOTTOM");
		
		getContentPane().add(lblTitle, BorderLayout.NORTH);
		getContentPane().add(btnPlay, BorderLayout.CENTER);
		getContentPane().add(btnLeft, BorderLayout.WEST);
		getContentPane().add(btnRight, BorderLayout.EAST);
		getContentPane().add(btnBottom, BorderLayout.SOUTH);
		
		setSize(500, 400);
		setVisible(true);
		setTitle("JFrame Demo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
	
	
	public static void main(String[] args) {
		JFrameDemo jf = new JFrameDemo();		
	}
}
