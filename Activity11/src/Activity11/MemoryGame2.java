package Activity11;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MemoryGame2 extends JFrame {

	public MemoryGame2() {

		setLayout(null);

		int width = 50;
		int height = 50;
		int x = 5;
		int y = 5;
		for (int i = 0; i < 4; i++) {

			for(int j = 0; j < 4; j++) {
				JButton btn = new JButton("");
				btn.setIcon(new ImageIcon(MemoryGame2.class.getResource("/images/apple-logo.png")));
				btn.setBounds(width*i+x*(i+1), height*j+y*(j+1), width, height);
				add(btn);				
			}

		}

		int frameWidth = width*4+x*5+5;
		int frameHeight = height * 4 + y*5*2;
		setSize(frameWidth, frameHeight);
		setVisible(true);
		setTitle("Memory Game");
	}

	public static void main(String[] args) {
		MemoryGame2 mg = new MemoryGame2();
	}
}
