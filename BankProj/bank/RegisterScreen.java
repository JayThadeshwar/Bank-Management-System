package bank;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import bankutil.DateLabelFormatter;
import crud.CustomerCrud;
import model.Customer;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class RegisterScreen extends JFrame {

	private static final long serialVersionUID = 1L;

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField textField_4;
	private JPasswordField textField_5;

	public RegisterScreen() {
		setBounds(100, 100, 1000, 520);
		getContentPane().setLayout(null);
		setTitle("Register");
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblRegister = new JLabel("Register");
		lblRegister.setFont(new Font("Dialog", Font.BOLD, 24));
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setBounds(423, 12, 153, 29);
		getContentPane().add(lblRegister);

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(76, 109, 76, 24);
		getContentPane().add(lblName);

		textField = new JTextField();
		textField.setBounds(194, 108, 213, 29);
		getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblEmail.setBounds(76, 193, 76, 22);
		getContentPane().add(lblEmail);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(194, 191, 213, 29);
		getContentPane().add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(194, 269, 213, 29);
		getContentPane().add(textField_2);

		JLabel lblContact = new JLabel("Contact");
		lblContact.setHorizontalAlignment(SwingConstants.CENTER);
		lblContact.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblContact.setBounds(76, 271, 76, 22);
		getContentPane().add(lblContact);

		JLabel lblDateOfBirth = new JLabel("Date of birth");
		lblDateOfBirth.setHorizontalAlignment(SwingConstants.CENTER);
		lblDateOfBirth.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblDateOfBirth.setBounds(555, 110, 138, 22);
		getContentPane().add(lblDateOfBirth);

		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.setBounds(711, 103, 213, 30);
		datePicker.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(datePicker);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblPassword.setBounds(555, 191, 138, 22);
		getContentPane().add(lblPassword);

		textField_4 = new JPasswordField();
		textField_4.setColumns(10);
		textField_4.setBounds(711, 191, 213, 29);
		getContentPane().add(textField_4);

		JLabel lblConfirmPassword = new JLabel("Confirm password");
		lblConfirmPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmPassword.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblConfirmPassword.setBounds(538, 271, 160, 22);
		getContentPane().add(lblConfirmPassword);

		textField_5 = new JPasswordField();
		textField_5.setColumns(10);
		textField_5.setBounds(711, 269, 213, 29);
		getContentPane().add(textField_5);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginScreen ls = new LoginScreen();
				ls.makeVisible();
				dispose();
			}
		});
		btnBack.setBounds(25, 11, 138, 38);
		getContentPane().add(btnBack);

		JButton btnBack_1 = new JButton("Submit");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = textField.getText();
				String email = textField_1.getText();
				String con = textField_2.getText();
				Date dob = new java.sql.Date(((java.util.Date) datePicker.getModel().getValue()).getTime());
				String pass = textField_4.getText();
				String cpass = textField_5.getText();
				boolean isValid = validateData(name, email, con, dob, pass, cpass);

				if (isValid)
					isValid = checkAge(dob);
				else
					System.out.println("Invalid data");

				if (isValid) {
					Customer cust = new Customer(name, email, con, dob, pass);
					CustomerCrud cc = new CustomerCrud();
					boolean res = cc.insertCustomer(cust);
					if(res == true) {
						LoginScreen ls = new LoginScreen();
						ls.makeVisible();
						dispose();
					} else {
						System.out.println("Could not insert in database");
					}
				} else {
					System.out.println("Age less than 18");
				}
			}

		});
		btnBack_1.setBounds(423, 385, 138, 38);
		getContentPane().add(btnBack_1);
	}

	boolean checkAge(Date dob) {
		int age = new Date(System.currentTimeMillis()).getYear() - dob.getYear();			
		if (age > 18)
			return true;
		else
			return false;
	}

	boolean validateData(String name, String email, String con, Date dob, String pass, String cpass) {
		if (name.isEmpty() || email.isEmpty() || con.isEmpty() || dob == null || pass.isEmpty() || cpass.isEmpty())
			return false;
		else if (name.matches("[a-zA-Z]+")) {
			if (email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")) {
				if (con.matches("[0-9]{10}")) {
					if (pass.equals(cpass) && (pass.length() >= 7 && pass.length() <= 15)) {
						return true;
					}
				}
			}
			return false;
		} else
			return false;
	}
}
