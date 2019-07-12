package Activity06.TransparentWindow;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Paint;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GradientWindow extends JFrame {
	public GradientWindow() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    // Make sure the frame is undecorated
	    this.setUndecorated(true);
	    this.setBackground(new Color(0, 0, 0, 0));
	    this.setSize(200, 200);
	    // Center it on the screen
	    this.setLocationRelativeTo(null);

	    this.getContentPane().setLayout(new GridLayout(0, 1));
	    this.add(new TranslucentJPanel(Color.RED));
	    JButton closeButton = new JButton("Close");
	    this.add(closeButton);
	    closeButton.addActionListener(e -> System.exit(0));
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			GradientWindow frame = new GradientWindow();
			frame.setVisible(true);
		});
	}
}

class TranslucentJPanel extends JPanel {
	  private int red = 240;
	  private int green = 240;
	  private int blue = 240;

	  public TranslucentJPanel(Color bgColor) {
	    this.red = bgColor.getRed();
	    this.green = bgColor.getGreen();
	    this.blue = bgColor.getBlue();
	  }

	  @Override
	  protected void paintComponent(Graphics g) {
	    int width = this.getWidth();
	    int height = this.getHeight();
	    float startPointX = 0.0f;
	    float startPointY = 0.0f;
	    float endPointX = width;
	    float endPointY = 0.0f;
	    Color startColor = new Color(red, green, blue, 255);
	    Color endColor = new Color(red, green, blue, 0);

	    Paint paint = new GradientPaint(startPointX, startPointY, startColor,
	        endPointX, endPointY, endColor);

	    Graphics2D g2D = (Graphics2D) g;
	    g2D.setPaint(paint);
	    g2D.fillRect(0, 0, width, height);

	  }
	}
