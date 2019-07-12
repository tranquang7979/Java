package Activity06.TransparentWindow;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class TransparentWindow extends JFrame {
	public TransparentWindow() {
		super();
		JButton closeButton = new JButton("Close");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setUndecorated(true);
		this.setOpacity(0.80f);
		this.setSize(200, 200);
		// Center it on the screen
		this.setLocationRelativeTo(null);
		this.add(closeButton, BorderLayout.SOUTH);
		closeButton.addActionListener(e -> System.exit(0));
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			TransparentWindow frame = new TransparentWindow();
			frame.setVisible(true);
		});
	}
}
