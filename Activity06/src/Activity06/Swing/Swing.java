package Activity06.Swing;

import java.awt.Container;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import static java.awt.GraphicsDevice.WindowTranslucency.PERPIXEL_TRANSLUCENT;
import static java.awt.GraphicsDevice.WindowTranslucency.PERPIXEL_TRANSPARENT;
import static java.awt.GraphicsDevice.WindowTranslucency.TRANSLUCENT;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Swing {
	public static void main(String[] args) {
		JFrame frame = new JFrame("My JFrame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = frame.getContentPane();

		// Add a close button
		JButton closeButton = new JButton("Close");
		contentPane.add(closeButton);

		// Create a JButton
		JButton okButton = new JButton("OK");
		// Set okButton as the default button
		frame.getRootPane().setDefaultButton(okButton);

		// set the size of the frame 300 x 200
		// frame.setBounds(50, 50, 300, 200);

		// Calculates and sets appropriate size for the frame
		frame.pack();

		// frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

		setWindowEvents(frame);

		setTranslucent();
		
		frame.setVisible(true);
	}
	
	static void setTranslucent() {
	    GraphicsEnvironment graphicsEnv = GraphicsEnvironment
	        .getLocalGraphicsEnvironment();

	    GraphicsDevice graphicsDevice = graphicsEnv.getDefaultScreenDevice();

	    boolean isSupported = graphicsDevice
	        .isWindowTranslucencySupported(PERPIXEL_TRANSPARENT);
	    System.out.println("PERPIXEL_TRANSPARENT  supported: " + isSupported);

	    isSupported = graphicsDevice.isWindowTranslucencySupported(TRANSLUCENT);
	    System.out.println("TRANSLUCENT  supported: " + isSupported);

	    isSupported = graphicsDevice
	        .isWindowTranslucencySupported(PERPIXEL_TRANSLUCENT);
	    System.out.println("PERPIXEL_TRANSLUCENT  supported: " + isSupported);
	  }

	static void setWindowEvents(JFrame frame) {
		frame.addWindowListener(new WindowListener() {
			@Override
			public void windowOpened(WindowEvent e) {
				System.out.println("JFrame has  been  made visible first  time");
			}

			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("JFrame is closing.");
			}

			@Override
			public void windowClosed(WindowEvent e) {
				System.out.println("JFrame is closed.");
			}

			@Override
			public void windowIconified(WindowEvent e) {
				System.out.println("JFrame is  minimized.");
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				System.out.println("JFrame is restored.");
			}

			@Override
			public void windowActivated(WindowEvent e) {
				System.out.println("JFrame is activated.");
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				System.out.println("JFrame is deactivated.");
			}
		});

		// Use the WindowAdapter class to intercept only the window closing event
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("JFrame is closing.");
			}
		});
	}
}
