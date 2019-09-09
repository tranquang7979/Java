package Activity18.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.SwingConstants;

public class Counting extends JFrame implements Runnable {

	private JPanel contentPane;
	private JTextField txtNumber;
	private JButton btnStart;
	private JButton btnPause;
	private JButton btnResume;
	private JButton btnStop;

	Thread th;
	private int count = 0;
	private Counting app = null;
	private JLabel lblTime;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Counting frame = new Counting();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Counting() {

		app = this;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 223, 190);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtNumber = new JTextField();
		txtNumber.setHorizontalAlignment(SwingConstants.CENTER);
		txtNumber.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtNumber.setText("1");
		txtNumber.setBounds(10, 8, 192, 36);
		contentPane.add(txtNumber);
		txtNumber.setColumns(10);

		btnStart = new JButton("Start");
		btnStart.setBounds(10, 55, 91, 23);
		contentPane.add(btnStart);
		btnStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (th == null)
					th = new Thread(app);
				th.start();
				btnStart.setEnabled(false);
				btnPause.setEnabled(true);
				btnResume.setEnabled(false);
				btnStop.setEnabled(true);
			}
		});

		btnPause = new JButton("Pause");
		btnPause.setBounds(111, 55, 91, 23);
		contentPane.add(btnPause);
		btnPause.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (th != null)
					th.suspend();

				btnPause.setEnabled(false);
				btnResume.setEnabled(true);
			}
		});

		btnResume = new JButton("Resume");
		btnResume.setBounds(10, 89, 91, 23);
		contentPane.add(btnResume);
		btnResume.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (th != null)
					th.resume();

				btnPause.setEnabled(true);
				btnResume.setEnabled(false);
			}
		});

		btnStop = new JButton("Stop");
		btnStop.setBounds(111, 89, 91, 23);
		contentPane.add(btnStop);
		btnStop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (th != null) {
					count = 0;
					th.stop();
					th = null;
				}
				btnStart.setEnabled(true);
				btnPause.setEnabled(false);
				btnResume.setEnabled(false);
				btnStop.setEnabled(false);
			}
		});

		btnStart.setEnabled(true);
		btnPause.setEnabled(false);
		btnResume.setEnabled(false);
		btnStop.setEnabled(false);

		lblTime = new JLabel("00:00:00");
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTime.setBounds(10, 123, 192, 33);
		contentPane.add(lblTime);
	}

	@Override
	public void run() {
		while (true) {
			count++;
			txtNumber.setText("" + count);

			Date currentTime = new Date();
			int hour = currentTime.getHours();
			int minute = currentTime.getMinutes();
			int second = currentTime.getSeconds();
			String text = (hour < 10 ? "0" : "") + hour 
					 + ":" + (minute < 10 ? "0" : "") + minute
					 + ":" + (second < 10 ? "0" : "") + second;
			lblTime.setText(text);

			try {
				Thread.sleep(1000);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
