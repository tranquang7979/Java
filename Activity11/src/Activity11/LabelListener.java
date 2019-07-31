package Activity11;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public class LabelListener implements MouseListener {

	private JLabel _lbl;

	public LabelListener(JLabel lbl) {
		_lbl = lbl;
		_lbl.setFont(new Font("Times New Roman", Font.TRUETYPE_FONT, 20));
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {
		_lbl.setForeground(Color.BLACK);
		_lbl.setFont(new Font("Times New Roman", Font.TRUETYPE_FONT, 20));
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		_lbl.setForeground(Color.RED);
		_lbl.setFont(new Font("Times New Roman", Font.BOLD, 25));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//JLabel lbl = (JLabel) e.getSource();
		//if (lbl.getText().equals("HOME")) {
		if(_lbl.getText().equals("HOME")) {
			MemoryGame2 mg = new MemoryGame2();
			mg.setVisible(true);
		}
	}

}
