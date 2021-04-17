package bank;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import crud.AccountCrud;
import model.Account;

public class UpdateFDAccount {

	private JFrame updateFrame;
	private JTextField name_input;
	private JTextField email_input;
	private JTextField phone_input;
	private JTextField gender_input;
	private JTextField area_input;
	private JTextField city_input;
	private JTextField state_input;
	private JTextField pin_input;
	private Account ac;

	public UpdateFDAccount(Account acn) {
		ac = acn;
		initialize();
	}

	public void maketrueup() {
		updateFrame.setVisible(true);
	}
	
	public void makefalseup() {
		updateFrame.setVisible(false);
	}

	boolean validateData() {
		String name = name_input.getText();
		String email = email_input.getText();
		String phone = phone_input.getText();
		String gender = gender_input.getText();
		String area = area_input.getText();
		String city = city_input.getText();
		String state = state_input.getText();
		String pin = pin_input.getText();

		if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || gender == null || area.isEmpty() || city.isEmpty()
				|| state.isEmpty() || pin.isEmpty()) {
			return false;
		} else if (name.matches("[a-zA-Z]+")) {
			// System.out.println("After name");
			if (email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")) {
				// System.out.println("After email");
				if (phone.matches("[0-9]+") && (phone.length() == 10)) {
					// System.out.println("After phone");

					if (gender.matches("[a-zA-Z]+")) {
						// System.out.println("After gender")
						if (area.matches("[a-zA-Z]+")) {
							// System.out.println("After area");
							if (city.matches("[a-zA-Z]+")) {
								// System.out.println("After city");
								if (state.matches("[a-zA-Z]+")) {
									// System.out.println("After state");
									if (pin.matches("[0-9]+")) {
										// System.out.println("After pin");
										AccountCrud acrud = new AccountCrud();
										boolean res = acrud.updateAccountInfo(name, email, phone, gender, area, city, state, pin, ac.getAcNo());
										if(res) {
											ac.setName(name);
											ac.setEmail(email);
											ac.setContact(phone);
											ac.setGender(gender);
											ac.setArea(area);
											ac.setCity(city);
											ac.setState(state);
											ac.setPincode(pin);
										}
										return res;
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

	private void initialize() {
		updateFrame = new JFrame();
		updateFrame.setBounds(100, 100, 1000, 520);
		updateFrame.setTitle("Update Details");
		updateFrame.getContentPane().setBackground(Color.WHITE);
		updateFrame.getContentPane().setForeground(Color.BLACK);
		updateFrame.getContentPane().setLayout(null);
		updateFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblNewLabel = new JLabel("Name ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(30, 165, 73, 31);
		updateFrame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Email ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(30, 202, 73, 31);
		updateFrame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Phone No ");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(30, 234, 122, 40);
		updateFrame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Gender ");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(30, 276, 103, 31);
		updateFrame.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_7 = new JLabel("Area");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(487, 165, 116, 31);
		updateFrame.getContentPane().add(lblNewLabel_7);

		name_input = new JTextField();
		name_input.setText(ac.getName());
		name_input.setForeground(Color.BLACK);
		name_input.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		name_input.setColumns(10);
		name_input.setBounds(149, 167, 316, 26);
		updateFrame.getContentPane().add(name_input);

		JLabel lblNewLabel_8 = new JLabel("Update Your Details");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_8.setBounds(359, 68, 282, 40);
		updateFrame.getContentPane().add(lblNewLabel_8);

		email_input = new JTextField();
		email_input.setText(ac.getEmail());
		email_input.setForeground(Color.BLACK);
		email_input.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		email_input.setColumns(10);
		email_input.setBounds(149, 204, 316, 26);
		updateFrame.getContentPane().add(email_input);

		phone_input = new JTextField();
		phone_input.setText(ac.getContact());
		phone_input.setForeground(Color.BLACK);
		phone_input.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		phone_input.setColumns(10);
		phone_input.setBounds(149, 241, 316, 26);
		updateFrame.getContentPane().add(phone_input);

		gender_input = new JTextField();
		gender_input.setText(ac.getGender());
		gender_input.setForeground(Color.BLACK);
		gender_input.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		gender_input.setColumns(10);
		gender_input.setBounds(149, 278, 316, 26);
		updateFrame.getContentPane().add(gender_input);

		area_input = new JTextField();
		area_input.setText(ac.getArea());
		area_input.setForeground(Color.BLACK);
		area_input.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		area_input.setColumns(10);
		area_input.setBounds(627, 165, 316, 26);
		updateFrame.getContentPane().add(area_input);

		JLabel lblNewLabel_7_1 = new JLabel("City");
		lblNewLabel_7_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_7_1.setBounds(487, 202, 116, 31);
		updateFrame.getContentPane().add(lblNewLabel_7_1);

		JLabel lblNewLabel_7_2 = new JLabel("State");
		lblNewLabel_7_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_7_2.setBounds(487, 240, 116, 31);
		updateFrame.getContentPane().add(lblNewLabel_7_2);

		city_input = new JTextField();
		city_input.setText(ac.getCity());
		city_input.setForeground(Color.BLACK);
		city_input.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		city_input.setColumns(10);
		city_input.setBounds(627, 202, 316, 26);
		updateFrame.getContentPane().add(city_input);

		state_input = new JTextField();
		state_input.setText(ac.getState());
		state_input.setForeground(Color.BLACK);
		state_input.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		state_input.setColumns(10);
		state_input.setBounds(627, 240, 316, 26);
		updateFrame.getContentPane().add(state_input);

		JButton submitBtn = new JButton("Submit");
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean val = validateData();
				if (val == true) {										
					JOptionPane.showMessageDialog(updateFrame, "Information Updated", "Message",
							JOptionPane.PLAIN_MESSAGE);					
				} else {
					JOptionPane.showMessageDialog(updateFrame, "Invalid Input!", "Message", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});

		submitBtn.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		submitBtn.setBounds(415, 362, 103, 34);
		updateFrame.getContentPane().add(submitBtn);

		pin_input = new JTextField();
		pin_input.setText(ac.getPincode());
		pin_input.setForeground(Color.BLACK);
		pin_input.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		pin_input.setColumns(10);
		pin_input.setBounds(627, 277, 316, 26);
		updateFrame.getContentPane().add(pin_input);

		JLabel lblNewLabel_7_2_1 = new JLabel("Pincode");
		lblNewLabel_7_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_7_2_1.setBounds(487, 277, 116, 31);
		updateFrame.getContentPane().add(lblNewLabel_7_2_1);
		updateFrame.setBounds(100, 100, 1000, 520);
		updateFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton backbtn = new JButton("BACK");
		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FixedDeposit main = new FixedDeposit(ac);
				main.makeVisible(true);
				makefalseup();
			}
		});
		backbtn.setBounds(12, 11, 99, 35);
		updateFrame.getContentPane().add(backbtn);
	}

}
