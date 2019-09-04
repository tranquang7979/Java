package Activity17.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Activity17.MyDBHelper;
import Models.BookViewModel;
import Models.TableForBookViewModel;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class BookManagement extends JFrame {

	private JPanel contentPane;
	private JTextField txtSearch;
	private JTable tblBook;
	private JScrollPane scrollPane;
	static BookManagement frame;

	TableForBookViewModel model;
	Vector<BookViewModel> rows = new Vector<BookViewModel>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new BookManagement();
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
	public BookManagement() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 762, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblBookName = new JLabel("Book name");
		lblBookName.setBounds(10, 63, 86, 14);
		contentPane.add(lblBookName);

		JLabel lblBookManagement = new JLabel("BOOK MANAGEMENT");
		lblBookManagement.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBookManagement.setBounds(134, 11, 192, 46);
		contentPane.add(lblBookManagement);

		txtSearch = new JTextField();
		txtSearch.setBounds(81, 60, 221, 20);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		txtSearch.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER){
					search();
				}
			}
		});

		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(313, 59, 91, 23);
		contentPane.add(btnSearch);
		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 92, 734, 170);
		contentPane.add(scrollPane);

		rows = new MyDBHelper().selectView();
		model = new TableForBookViewModel(rows);

		tblBook = new JTable(model);
		scrollPane.setViewportView(tblBook);

	}
	
	private void search() {
		rows = new MyDBHelper().searchViewByName(txtSearch.getText());
		model.refresh(rows);
		
		//rows.clear();
		//tblBook.updateUI();
	}
}
