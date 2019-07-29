package Activity11;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;

public class JTabDemo extends JFrame {

	JTabbedPane tabPane;
	JMenuBar menuBar;

	//test	
	public JTabDemo() {

		menuBar = new JMenuBar();

		JMenu menu = new JMenu("File");
		JMenuItem item = new JMenuItem("New");
		menu.add(item);
		item = new JMenuItem("Open");
		menu.add(item);
		menuBar.add(menu);

		menu = new JMenu("Edit");
		item = new JMenuItem("Copy");
		menu.add(item);
		item = new JMenuItem("Paste");
		menu.add(item);
		menuBar.add(menu);

		menu = new JMenu("Exit");
		item = new JMenuItem("Close");
		menu.add(item);
		menuBar.add(menu);

		setJMenuBar(menuBar);

		tabPane = new JTabbedPane();
		tabPane.addTab("Application", null);
		tabPane.addTab("Users", null);
		tabPane.addTab("Process", null);
		tabPane.setSize(200, 200);
		add(tabPane, BorderLayout.CENTER);

		setSize(300, 200);
		setVisible(true);
		setTitle("Demo");

	}

	public static void main(String[] args) {
		JTabDemo d = new JTabDemo();
	}
}
