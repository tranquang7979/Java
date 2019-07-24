import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Calculator extends JFrame {

	private JPanel contentPane;
	private static JTextField txtA;
	private static float a = 0;
	private static OperatorType operator = OperatorType.ADD;
	private static CalcAction ca = new CalcAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
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
	public Calculator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtA = new JTextField();
		txtA.setHorizontalAlignment(SwingConstants.RIGHT);
		txtA.setText("0");
		txtA.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtA.setBounds(20, 8, 201, 45);
		contentPane.add(txtA);
		txtA.setColumns(10);
		
		JButton btn7 = new JButton("7");
		btn7.setBounds(20, 64, 41, 23);
		btn7.addActionListener(e -> { btnNumberEvent("7"); });
		contentPane.add(btn7);
		
		JButton button = new JButton("8");
		button.setBounds(68, 64, 41, 23);
		button.addActionListener(e -> { btnNumberEvent("8"); });
		contentPane.add(button);
		
		JButton button_1 = new JButton("9");
		button_1.setBounds(119, 64, 41, 23);
		button_1.addActionListener(e -> { btnNumberEvent("9"); });
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("4");
		button_2.setBounds(20, 98, 41, 23);
		button_2.addActionListener(e -> { btnNumberEvent("4"); });
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("5");
		button_3.setBounds(68, 98, 41, 23);
		button_3.addActionListener(e -> { btnNumberEvent("5"); });
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("6");
		button_4.setBounds(119, 98, 41, 23);
		button_4.addActionListener(e -> { btnNumberEvent("6"); });
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("1");
		button_5.setBounds(20, 132, 41, 23);
		button_5.addActionListener(e -> { btnNumberEvent("1"); });
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("2");
		button_6.setBounds(68, 132, 41, 23);
		button_6.addActionListener(e -> { btnNumberEvent("2"); });
		contentPane.add(button_6);
		
		JButton button_7 = new JButton("3");
		button_7.setBounds(119, 132, 41, 23);
		button_7.addActionListener(e -> { btnNumberEvent("3"); });
		contentPane.add(button_7);
		
		JButton button_8 = new JButton("0");
		button_8.setBounds(20, 166, 41, 23);
		button_8.addActionListener(e -> { btnNumberEvent("0"); });
		contentPane.add(button_8);
		
		JButton button_9 = new JButton(".");
		button_9.setBounds(68, 166, 41, 23);
		button_9.addActionListener(e -> { btnNumberEvent("."); });
		contentPane.add(button_9);
		
		JButton button_10 = new JButton("+");
		button_10.setForeground(Color.BLUE);
		button_10.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_10.setBounds(170, 64, 51, 23);
		button_10.addActionListener(e -> { setOperatorType(OperatorType.ADD); });
		contentPane.add(button_10);
		
		JButton button_11 = new JButton("-");
		button_11.setForeground(Color.BLUE);
		button_11.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_11.setBounds(170, 98, 51, 23);
		button_11.addActionListener(e -> { setOperatorType(OperatorType.SUB); });
		contentPane.add(button_11);
		
		JButton button_12 = new JButton("*");
		button_12.setForeground(Color.BLUE);
		button_12.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_12.setBounds(170, 132, 51, 23);
		button_12.addActionListener(e -> { setOperatorType(OperatorType.MUL); });
		contentPane.add(button_12);
		
		JButton button_14 = new JButton("/");
		button_14.setForeground(Color.BLUE);
		button_14.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_14.setBounds(170, 166, 51, 23);
		button_14.addActionListener(e -> { setOperatorType(OperatorType.DIV); });
		contentPane.add(button_14);

		JButton button_13 = new JButton("=");
		button_13.setForeground(Color.BLUE);
		button_13.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_13.setBounds(119, 166, 41, 23);
		button_13.addActionListener(e -> { setResult(); });
		contentPane.add(button_13);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnClear.setBounds(20, 200, 201, 23);
		btnClear.addActionListener(e -> { clear(); });
		contentPane.add(btnClear);
	}
	
	private static void btnNumberEvent(String num) {
		float currentNo = getInput();
		txtA.setText((currentNo == 0 ? "" : Float.valueOf(currentNo)) + num);
	}

	private static float getInput() {
		return Float.parseFloat(txtA.getText());
	}
	private static void setOperatorType(OperatorType type) {
		a = getInput();
		operator = type;
		txtA.setText("0");	
	}
	
	private static void clear() {
		a = 0;
		operator = OperatorType.ADD;
		txtA.setText("0");
	}
	
	private static void calc() {
		switch(operator)
		{
			case ADD:
				a = ca.sum(a, getInput());
				break;
			case SUB:
				a = ca.sub(a, getInput());
				break;
			case MUL:
				a = ca.mul(a, getInput());
				break;
			case DIV:
				a = ca.div(a, getInput());
				break;
		}
	}
	private static void setResult() {
		calc();
		txtA.setText(String.valueOf(a));
	}
}
