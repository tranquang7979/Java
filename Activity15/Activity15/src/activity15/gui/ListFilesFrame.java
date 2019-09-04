package activity15.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.JTree;

public class ListFilesFrame extends JFrame {

	private JPanel contentPane;
	JTree tree_files =null;
	DefaultTreeModel model;
	
	DefaultMutableTreeNode root =new DefaultMutableTreeNode(new String("D:\\Baitap"));
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListFilesFrame frame = new ListFilesFrame();
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
	public ListFilesFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTree tree = new JTree();
		tree.setBounds(10, 11, 126, 233);
		contentPane.add(tree);
		
		//code here
		
		model =new DefaultTreeModel(root);
		
		
		try{
			String path="D:\\Baitap";
			
			File f= new File(path);
			
			System.out.println("Name: " +f.getName());
			System.out.println("Parent: " +f.getParent());
			// liet ke tat ca thu muc con va file 
			
			File[] names =  f.listFiles();
			
			for(File s : names){
			
				if( s.isFile()){
					System.out.println(s.getName() + "--> is File" + s.getAbsolutePath());
					
				}else{
					System.out.println(s.getName() + "--> is Directory" +s.getAbsolutePath());
				}
				
				
				DefaultMutableTreeNode node =new DefaultMutableTreeNode(s.getName());
				root.add(node);
				
				
			}
			
		}catch (Exception e) {}
		
		//child
//		DefaultMutableTreeNode node1 =new DefaultMutableTreeNode("A");
//		DefaultMutableTreeNode node2 =new DefaultMutableTreeNode("B");
//		
//		root.add(node1);
//		root.add(node2);
		tree_files =new JTree(model);
		
		tree_files.setBounds(188, 11, 92, 233);
		contentPane.add(tree_files);
	}
}
