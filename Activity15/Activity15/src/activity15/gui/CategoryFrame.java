package activity15.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class CategoryFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txt_name;
	JLabel lbl_image = new JLabel("New label");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CategoryFrame frame = new CategoryFrame();
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
	public CategoryFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lbl_image.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		lbl_image.setIcon(new ImageIcon(CategoryFrame.class.getResource("/resources/noimage.jpg")));
		lbl_image.setBounds(30, 11, 146, 190);
		contentPane.add(lbl_image);
		
		txt_name = new JTextField();
		txt_name.setBounds(30, 212, 146, 20);
		contentPane.add(txt_name);
		txt_name.setColumns(10);
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser choose =new JFileChooser();
			    int result=	choose.showOpenDialog(null);
				
			    if(result == JFileChooser.APPROVE_OPTION){
			        
			    	File file  = choose.getSelectedFile();
			    	txt_name.setText(file.getName());
			    	
			    	try {
			   			      
			    	//save file to resources
			    	String path = CategoryFrame.class.getResource("/resources").getPath();
			    	System.out.println("path"+ path);
			    	
			    	//duong dan noi chua file duoc upload
			    	Path source = Paths.get(file.getAbsolutePath());
			    
			    	File destination = new File("D://"+txt_name.getText()); //create file blank
			   		FileOutputStream os =new FileOutputStream(destination);
					
			   		Files.copy(source, os);	
			   		os.close();
			   			   		
			   		// show label
			   		
			   		lbl_image.setIcon(new ImageIcon("D://"+txt_name.getText()));
			    	
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    	 	
			    	
			    
			    }				
			}
		});
		btnBrowse.setBounds(182, 211, 91, 23);
		contentPane.add(btnBrowse);
	}
}
