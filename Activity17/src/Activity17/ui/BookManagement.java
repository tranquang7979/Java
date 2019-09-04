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

	TableForBookViewModel model;
	Vector<BookViewModel> rows = new Vector<BookViewModel>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookManagement frame = new BookManagement();
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
		setBounds(100, 100, 450, 300);
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

		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(313, 59, 91, 23);
		contentPane.add(btnSearch);
		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				rows = new MyDBHelper().searchViewByName(txtSearch.getText());
				model.refresh(rows);
			}
		});

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 92, 422, 170);
		contentPane.add(scrollPane);

		rows = new MyDBHelper().selectView();
		model = new TableForBookViewModel(rows);

		tblBook = new JTable(model);
		scrollPane.setViewportView(tblBook);

	}
}
