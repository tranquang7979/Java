package game;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Game extends JFrame implements Runnable {

	private JPanel contentPane;
	JPanel bottom_panel = new JPanel();
	JLabel lbl_time = new JLabel("120");
	int count=120;
	Thread th;

	boolean isStop=false;
	
	int W=100;
	int H=100;
	int wx=5;
	int hy=5;
	
	int Screen_X=W*4+wx*5 + 5;
	int Screen_Y = H*4+hy*5 +5;
	
	String [] images = {"0","1","2","3","4","5","6","7",
			            "8","9","10","11","12","13","14","15"};
	
	
	List<String> lst_images = Arrays.asList(images);
	
	
	
	int current=0;
	String first, second;
	JButton btn_first, btnSecond;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game frame = new Game();
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
	public Game() {
		//shuffle 
		Collections.shuffle(lst_images);
		//test
		for(String img : lst_images ){
			System.out.println(img);
		}
		
		
		
		setTitle("MEMORY GAME");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 597);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel top_panel = new JPanel();
		top_panel.setBounds(0, 0, 442, 68);
		contentPane.add(top_panel);
		top_panel.setLayout(null);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				startThread();
			}
		});
		btnPlay.setBounds(341, 11, 91, 46);
		top_panel.add(btnPlay);
		
		JLabel lblTime = new JLabel("TIME(s)");
		lblTime.setBounds(10, 26, 46, 14);
		top_panel.add(lblTime);
		lbl_time.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		lbl_time.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lbl_time.setBounds(73, 11, 241, 46);
		top_panel.add(lbl_time);
		
		
		bottom_panel.setLayout(null);
		bottom_panel.setSize(Screen_X+15,Screen_Y+40);
        bottom_panel.setBounds(0, 79, Screen_X+15, Screen_Y+40);
        
        int index=0;
        for(int j=0;j<4;j++){
			
			for(int i=0;i<4;i++){
				JButton btn =new JButton();
				btn.setName(lst_images.get(index));
				index++;
				
				btn.setBounds(W*i+wx*(i+1), H*j+hy*(j+1), W, H);
				btn.setIcon(new ImageIcon(Game.class.getResource("/images/start.png")));
				btn.setHorizontalAlignment(SwingConstants.CENTER);
				bottom_panel.add(btn);
				
				
				//su kien
				btn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						processButton(e);
					
					}
				});
				
			}
			
		}
               
        
		contentPane.add(bottom_panel);
		
	}
	
	private void processButton(ActionEvent e){
		
		JButton btn = (JButton)e.getSource();
		String name = btn.getName();
		
		//JOptionPane.showMessageDialog(null, name);
		
		if(current==0)
		{
		   first =name;
		   btn_first =btn;
		   //mo hinh
		   btn.setIcon(new ImageIcon(Game.class.getResource("/images/"+first+".png")));
		   current++;
		}else if(current == 1){
			
			second =name;
			btnSecond = btn;
			//mo hinh
			 System.out.println("first" + first + ":" +second);
			
			 btn.setIcon(new ImageIcon(Game.class.getResource("/images/"+second +".png")));
			 current=0;
			//kiem tra 2 hinh giong nhau ko
			
			 
			 int i = Integer.parseInt(first);
			 int j = Integer.parseInt(second);
			 
			 if(i+j == 15){
				 
				 //cap hinh giong nhau ==> diem
				 
			 }else{
				 
				 System.out.println("reset hinh");
				 // bat hinh mac dinh cho ca 2 button
				 btn_first.setIcon(new ImageIcon(Game.class.getResource("/images/start.png")));
				 
				 btnSecond.setIcon(new ImageIcon(Game.class.getResource("/images/start.png")));
				 bottom_panel.updateUI();
			 }
			
		}
		
	}
	
	private void startThread(){
		if(th==null){
			
			th=new Thread(this);
			th.start();
		}
	}
	
	private void stopThread(){
		
		JOptionPane.showMessageDialog(null, "Game over!!!");
		
		if(th!=null){
			th=null;
			count=120;
			
			
		}
		
	}

	@Override
	public void run() {
		
		while(!isStop){
			count--;
			lbl_time.setText(""+count);
			
			if(count==0){
				isStop=true;
				stopThread();
				
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}
}
