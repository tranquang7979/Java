package Acitivity15.ui;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import Acitivity15.FileDemo;

public class ListFileFrame extends JFrame {

	private JPanel contentPane;
	JTree treeFiles = null;
	DefaultTreeModel model = null;
	DefaultMutableTreeNode root = new DefaultMutableTreeNode("E:\\TranDuyQuang\\eclipse-workspace\\Activity15\\src\\resources");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListFileFrame frame = new ListFileFrame();
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
	public ListFileFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTree tree = new JTree();
		tree.setBounds(10, 11, 133, 251);
		contentPane.add(tree);
		
		ArrayList<String> arr = new FileDemo().AccessFolder();
		
		for(String name : arr)
		{
			// create child node 
			DefaultMutableTreeNode node1 = new DefaultMutableTreeNode(name);
			root.add(node1); // add child node to root	
		}
		
		// binding root into model
		model = new DefaultTreeModel(root);
		treeFiles = new JTree(model);
		treeFiles.setBounds(188,11,92,233);
		contentPane.add(treeFiles);
	}
}
