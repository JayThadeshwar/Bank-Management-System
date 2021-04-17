package bank;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import java.awt.Button;
import java.awt.Color;
import java.sql.*;
import java.io.*;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import java.awt.SystemColor;
import javax.swing.ScrollPaneConstants;

import crud.FdCrud;
import database.BankDb;
import javax.swing.JButton;

public class Loan {

	private JFrame frame;
	static private JTextField accno_input;
	static private JTextField mincome_input;
	static private JTextField etype_input;
	static private JTextField lamount_input;
	private static JTextField dur_input;
	static private JTextField city_input;
	private static JList list;
	private static String e;
	final JLabel label = new JLabel();

	void makeVisible(boolean val) {
		frame.setVisible(val);
	}

	public static String getIndex(int n) {
		if (n == 0) {
			e = "Pvt/MNC Job";
			return e;
		} else if (n == 1) {
			e = "Government Job";
			return e;
		} else {
			e = "Proprietorship/ Partnership/ LLP";
			return e;
		}
	}

	public static void insert_loan(int ch) {
		String acc = accno_input.getText();
		String in = mincome_input.getText();
		String et = getIndex(ch);
		String am = lamount_input.getText();
		String duration = dur_input.getText();
		int dur = Integer.parseInt(duration);
		String ct = city_input.getText();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = BankDb.getConnection();
			String ins_loan = "insert into loan(accno,income,etype,lamount,duration,city,type) values(" + "'" + acc
					+ "','" + in + "','" + et + "','" + am + "'," + dur + ",'" + ct + "','Home');";
			st = con.createStatement();
			int up = st.executeUpdate(ins_loan);
			System.out.println(up);
			con.commit();
		} catch (Exception e) {
			System.out.println("Exception =" + e);
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (Exception e) {
				System.out.println("Exception in closing" + e);
			}
		}
	}

	public static boolean grantLoan() {
		String am = lamount_input.getText();
		int amount = Integer.parseInt(am);
		System.out.println("Loan Amount=" + amount);
		String in = mincome_input.getText();
		int income = Integer.parseInt(in);
		String duration = dur_input.getText();
		int dur = Integer.parseInt(duration);
		System.out.println("Income=" + income);
		int check = (income * 52);
		System.out.println("Check value=" + check);
		if ((amount <= check) && (dur <= 30) && (income >= 10000)) {
			return true;
		} else {
			return false;
		}
	}

	boolean validateData(JTextField accno_input, JTextField mincome_input, JTextField etype_input,
			JTextField lamount_input, JTextField dur_input, JTextField city_input, int ch) {
		String acc = accno_input.getText();
		String min = mincome_input.getText();
		String etype = getIndex(ch);
		String lamount = lamount_input.getText();
		String dur = dur_input.getText();
		String city = city_input.getText();

		if (acc.isEmpty() || min.isEmpty() || etype.isEmpty() || lamount == null || dur.isEmpty() || city.isEmpty()) {
			return false;
		} else if (acc.matches("[a-zA-Z0-9]+")) {

			if (min.matches("[0-9]+")) {

				if (etype.matches("[a-zA-Z/ -]+")) {

					if (lamount.matches("[0-9]+")) {

						if (dur.matches("[0-9]+")) {

							if (city.matches("[a-zA-Z]+")) {

								return true;
							}
						}
					}
				}
			}
			return false;
		} else {
			return false;
		}
	}

	/**
	 * Create the application.
	 */
	public Loan() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 18));
		frame.setBounds(100, 100, 1000, 520);
		frame.setTitle("Home Loan Application");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Home Loan Application");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblNewLabel.setBounds(351, 32, 298, 25);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Account Number:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(319, 100, 135, 19);
		frame.getContentPane().add(lblNewLabel_1);

		accno_input = new JTextField();
		accno_input.setBounds(485, 101, 203, 20);
		frame.getContentPane().add(accno_input);
		accno_input.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Net Monthly Income:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(319, 143, 150, 19);
		frame.getContentPane().add(lblNewLabel_1_1);

		mincome_input = new JTextField();
		mincome_input.setColumns(10);
		mincome_input.setBounds(485, 144, 203, 20);
		frame.getContentPane().add(mincome_input);

		String choice[] = { "Pvt/MNC Job", "Government Job", "Proprietorship/ Partnership/ LLP" };

		JLabel lblNewLabel_1_1_1 = new JLabel("Employer Type:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(334, 185, 135, 19);
		frame.getContentPane().add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Desired Loan Amount:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(307, 244, 169, 19);
		frame.getContentPane().add(lblNewLabel_1_1_1_1);

		lamount_input = new JTextField();
		lamount_input.setColumns(10);
		lamount_input.setBounds(485, 245, 203, 20);
		frame.getContentPane().add(lamount_input);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Duration(in years)");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_1.setBounds(334, 286, 142, 19);
		frame.getContentPane().add(lblNewLabel_1_1_1_1_1);

		dur_input = new JTextField();
		dur_input.setColumns(10);
		dur_input.setBounds(485, 287, 203, 20);
		frame.getContentPane().add(dur_input);

		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Property City:");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_1_1.setBounds(334, 320, 142, 19);
		frame.getContentPane().add(lblNewLabel_1_1_1_1_1_1);

		city_input = new JTextField();
		city_input.setColumns(10);
		city_input.setBounds(485, 321, 203, 20);
		frame.getContentPane().add(city_input);

		JLabel acc_valid = new JLabel("");
		acc_valid.setBounds(485, 119, 86, 19);
		frame.getContentPane().add(acc_valid);
		DefaultListModel DLM = new DefaultListModel();
		DLM.addElement("Pvt/MNC Job");
		DLM.addElement("Government Job");
		DLM.addElement("Proprietorship/ Partnership/ LLP");

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(485, 175, 203, 59);
		frame.getContentPane().add(scrollPane);

		JList list_1 = new JList();
		scrollPane.setViewportView(list_1);
		list_1.setBackground(SystemColor.scrollbar);
		list_1.setModel(DLM);
		list_1.setSelectedIndex(0);
		int ch = list_1.getSelectedIndex();

		Button button = new Button("Submit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean val = validateData(accno_input, mincome_input, etype_input, lamount_input, dur_input,
						city_input, ch);
				if (val == true) {
					String acNo = accno_input.getText();
					boolean acc = FdCrud.checkAccountNumber(acNo);
					if (acc) {
						boolean loangrant = grantLoan();
						if (loangrant) {
							JOptionPane.showMessageDialog(frame, "Loan can be granted!", "Message",
									JOptionPane.PLAIN_MESSAGE);
							int result = JOptionPane.showConfirmDialog(frame, "Do you want to apply for loan?",
									"Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
							if (result == JOptionPane.YES_OPTION) {
								insert_loan(ch);
								// System.out.println("Data inserted");
							} else if (result == JOptionPane.NO_OPTION) {
								System.out.println("Exit");
							}
						} else {
							JOptionPane.showMessageDialog(frame, "Loan cannot be granted!", "Message",
									JOptionPane.PLAIN_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(frame, "Account does not exist!", "Message",
								JOptionPane.PLAIN_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(frame, "Invalid Input!", "Message", JOptionPane.PLAIN_MESSAGE);
				}

			}
		});
		button.setBounds(424, 387, 102, 39);
		frame.getContentPane().add(button);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HomeScreen hs = new HomeScreen();
				hs.setVisible(true);
				makeVisible(false);
			}
		});
		btnBack.setBounds(35, 12, 117, 25);
		frame.getContentPane().add(btnBack);
	}
}
