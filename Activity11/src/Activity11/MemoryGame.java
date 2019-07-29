package Activity11;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MemoryGame extends JFrame {

	public MemoryGame() {
		
		setLayout(new FlowLayout());
		for(int i = 1; i <= 16; i++) {
			JButton btn = new JButton("Button " + (i < 10 ? "0" : "") + i);
			add(btn);
		}
				
		setSize(300,300);
		setVisible(true);
		setTitle("Memory Game");
	}
	
	public static void main(String[] args) {
		MemoryGame mg = new MemoryGame();		
	}
}
