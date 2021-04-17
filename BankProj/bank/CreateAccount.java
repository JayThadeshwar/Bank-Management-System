package bank;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import bankutil.DateLabelFormatter;
import bankutil.GenerateAccNo;
import bankutil.PopUps;
import crud.AccountCrud;
import model.Account;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;
import java.util.Properties;
import java.awt.event.ActionEvent;

public class CreateAccount {

	private JFrame frmCreateAccount;
	private JTextField textField_5;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JDatePickerImpl datePicker;
	private int acType;

	void makeVisible(boolean val) {
		frmCreateAccount.setVisible(val);
	}

	public CreateAccount(int ac) {
		acType = ac;
		initialize();
	}

	private void initialize() {
		frmCreateAccount = new JFrame();
		frmCreateAccount.getContentPane().setBackground(Color.WHITE);
		frmCreateAccount.setTitle("Create Account");
		frmCreateAccount.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 18));
		frmCreateAccount.setBounds(100, 100, 1000, 520);
		frmCreateAccount.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCreateAccount.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Name ");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel.setBounds(29, 112, 73, 31);
		frmCreateAccount.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Email ");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(29, 149, 73, 31);
		frmCreateAccount.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Phone No ");
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(29, 181, 122, 40);
		frmCreateAccount.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Gender ");
		lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(29, 223, 103, 31);
		frmCreateAccount.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Aadhar No ");
		lblNewLabel_4.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(29, 307, 116, 31);
		frmCreateAccount.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Pan No ");
		lblNewLabel_5.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(29, 265, 85, 31);
		frmCreateAccount.getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Date of Birth ");
		lblNewLabel_6.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(492, 135, 133, 31);
		frmCreateAccount.getContentPane().add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Area");
		lblNewLabel_7.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(492, 172, 116, 31);
		frmCreateAccount.getContentPane().add(lblNewLabel_7);

		textField_5 = new JTextField();
		textField_5.setForeground(Color.BLACK);
		textField_5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField_5.setColumns(10);
		textField_5.setBounds(148, 114, 316, 26);
		frmCreateAccount.getContentPane().add(textField_5);

		JLabel lblNewLabel_8 = new JLabel("Personal Details");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_8.setBounds(374, 36, 251, 40);
		frmCreateAccount.getContentPane().add(lblNewLabel_8);

		textField = new JTextField();
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField.setColumns(10);
		textField.setBounds(148, 151, 316, 26);
		frmCreateAccount.getContentPane().add(textField);

		textField_1 = new JTextField();
		textField_1.setForeground(Color.BLACK);
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(148, 188, 316, 26);
		frmCreateAccount.getContentPane().add(textField_1);

		textField_2 = new JTextField();
		textField_2.setForeground(Color.BLACK);
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(148, 225, 316, 26);
		frmCreateAccount.getContentPane().add(textField_2);

		textField_3 = new JTextField();
		textField_3.setForeground(Color.BLACK);
		textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField_3.setColumns(10);
		textField_3.setBounds(148, 309, 316, 26);
		frmCreateAccount.getContentPane().add(textField_3);

		textField_4 = new JTextField();
		textField_4.setForeground(Color.BLACK);
		textField_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField_4.setColumns(10);
		textField_4.setBounds(148, 267, 316, 26);
		frmCreateAccount.getContentPane().add(textField_4);

		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.setBounds(632, 135, 316, 26);
		datePicker.setBackground(Color.LIGHT_GRAY);
		frmCreateAccount.getContentPane().add(datePicker);

		textField_7 = new JTextField();
		textField_7.setForeground(Color.BLACK);
		textField_7.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField_7.setColumns(10);
		textField_7.setBounds(632, 172, 316, 26);
		frmCreateAccount.getContentPane().add(textField_7);

		JLabel lblNewLabel_7_1 = new JLabel("City");
		lblNewLabel_7_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_7_1.setBounds(492, 209, 116, 31);
		frmCreateAccount.getContentPane().add(lblNewLabel_7_1);

		JLabel lblNewLabel_7_2 = new JLabel("State");
		lblNewLabel_7_2.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_7_2.setBounds(492, 247, 116, 31);
		frmCreateAccount.getContentPane().add(lblNewLabel_7_2);

		textField_8 = new JTextField();
		textField_8.setForeground(Color.BLACK);
		textField_8.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField_8.setColumns(10);
		textField_8.setBounds(632, 209, 316, 26);
		frmCreateAccount.getContentPane().add(textField_8);

		textField_9 = new JTextField();
		textField_9.setForeground(Color.BLACK);
		textField_9.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField_9.setColumns(10);
		textField_9.setBounds(632, 247, 316, 26);
		frmCreateAccount.getContentPane().add(textField_9);

		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Account acc = getAccount();
				AccountCrud acrud = new AccountCrud();
				if (acc == null) {
					PopUps.showFailureMsg(frmCreateAccount, "Invalid input.", "Validation failed");
				} else {
					acrud.insertAccount(acc, HomeScreen.currCustomer.getId());
					JOptionPane.showMessageDialog(frmCreateAccount, "Account Created", "Message",
							JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		btnNewButton.setBounds(420, 369, 103, 34);
		frmCreateAccount.getContentPane().add(btnNewButton);

		textField_10 = new JTextField();
		textField_10.setForeground(Color.BLACK);
		textField_10.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField_10.setColumns(10);
		textField_10.setBounds(632, 284, 316, 26);
		frmCreateAccount.getContentPane().add(textField_10);

		JLabel lblNewLabel_7_2_1 = new JLabel("Pincode");
		lblNewLabel_7_2_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_7_2_1.setBounds(492, 284, 116, 31);
		frmCreateAccount.getContentPane().add(lblNewLabel_7_2_1);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SavingsAccountInfo sai = new SavingsAccountInfo(acType);
				sai.makeVisible(true);
				makeVisible(false);
			}
		});
		btnBack.setBounds(29, 12, 117, 25);
		frmCreateAccount.getContentPane().add(btnBack);
	}

	Account getAccount() {
		String name = textField_5.getText();
		String email = textField.getText();
		String con = textField_1.getText();
		java.util.Date dt = (java.util.Date) datePicker.getModel().getValue();
		Date dob;
		if(dt != null)
			dob = new java.sql.Date((dt).getTime());
		else
			return null;
		String gender = textField_2.getText();
		String pan = textField_4.getText();
		String aad = textField_3.getText();
		String area = textField_7.getText();
		String city = textField_8.getText();
		String state = textField_9.getText();
		String pin = textField_10.getText();
		String acNo = "";
		boolean res = validateData();

		Account acc = null;
		if (res) {
			if (acType == 1)
				acNo = GenerateAccNo.savingsAcc(city);
			else if (acType == 2)
				acNo = GenerateAccNo.currentAcc(city);
			else if (acType == 3)
				acNo = GenerateAccNo.fdAcc(city);
			acc = new Account(acNo, name, email, con, dob, gender, pan, aad, city, area, state, pin);
		}

		return acc;
	}

	boolean validateData() {
		String name = textField_5.getText();
		String email = textField.getText();
		String phone = textField_1.getText();
		String gender = textField_2.getText();
		String aadhar = textField_3.getText();
		String pan = textField_4.getText();
		Date dob = new java.sql.Date(((java.util.Date) datePicker.getModel().getValue()).getTime());
		String area = textField_7.getText();
		String city = textField_8.getText();
		String state = textField_9.getText();
		String pin = textField_10.getText();

		if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || gender == null || aadhar.isEmpty() || pan.isEmpty()
				|| dob == null || area.isEmpty() || city.isEmpty() || state.isEmpty() || pin.isEmpty()) {
			return false;
		} else if (name.matches("[a-zA-Z]+")) {
			// System.out.println("After name");
			if (email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")) {
				// System.out.println("After email");
				if (phone.matches("[0-9]+") && (phone.length() == 10)) {
					// System.out.println("After phone");

					if (gender.matches("[a-zA-Z]+")) {
						// System.out.println("After gender");
						if (aadhar.matches("[0-9]+") && (aadhar.length() == 12)) {
							// System.out.println("After aadhar");
							if (pan.matches("[a-zA-Z0-9]+") && (pan.length() == 10)) {
								// System.out.println("After pan");
								if (area.matches("[a-zA-Z]+")) {
									// System.out.println("After area");
									if (city.matches("[a-zA-Z]+")) {
										// System.out.println("After city");
										if (state.matches("[a-zA-Z]+")) {
											// System.out.println("After state");
											if (pin.matches("[0-9]+")) {
												// System.out.println("After pin");
												return true;
											}
										}
									}
								}
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
}
