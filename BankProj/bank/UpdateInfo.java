package bank;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import bankutil.PopUps;
import crud.AccountCrud;
import model.Account;

public class UpdateInfo {

	private JFrame frmUpdateDetails;
	private JTextField txtTest;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private Account accountInfo;

	public void makeVisible(boolean val) {
		frmUpdateDetails.setVisible(val);
	}

	public UpdateInfo(Account ac) {
		accountInfo = ac;
		initialize();
	}

	private void initialize() {
		frmUpdateDetails = new JFrame();
		frmUpdateDetails.setTitle("Update Details");
		frmUpdateDetails.getContentPane().setBackground(Color.WHITE);
		frmUpdateDetails.getContentPane().setForeground(Color.BLACK);
		frmUpdateDetails.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Name ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(30, 165, 73, 31);
		frmUpdateDetails.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Email ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(30, 202, 73, 31);
		frmUpdateDetails.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Phone No ");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(30, 234, 122, 40);
		frmUpdateDetails.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Gender ");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(30, 276, 103, 31);
		frmUpdateDetails.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_7 = new JLabel("Area");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(487, 165, 116, 31);
		frmUpdateDetails.getContentPane().add(lblNewLabel_7);

		txtTest = new JTextField();
		txtTest.setText(accountInfo.getName());
		txtTest.setForeground(Color.BLACK);
		txtTest.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtTest.setColumns(10);
		txtTest.setBounds(149, 167, 316, 26);
		frmUpdateDetails.getContentPane().add(txtTest);

		JLabel lblNewLabel_8 = new JLabel("Update Your Details");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_8.setBounds(354, 68, 291, 40);
		frmUpdateDetails.getContentPane().add(lblNewLabel_8);

		textField_1 = new JTextField();
		textField_1.setText(accountInfo.getEmail());
		textField_1.setForeground(Color.BLACK);
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(149, 204, 316, 26);
		frmUpdateDetails.getContentPane().add(textField_1);

		textField_2 = new JTextField();
		textField_2.setText(accountInfo.getContact());
		textField_2.setForeground(Color.BLACK);
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(149, 241, 316, 26);
		frmUpdateDetails.getContentPane().add(textField_2);

		textField_3 = new JTextField();
		textField_3.setText(accountInfo.getGender());
		textField_3.setForeground(Color.BLACK);
		textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField_3.setColumns(10);
		textField_3.setBounds(149, 278, 316, 26);
		frmUpdateDetails.getContentPane().add(textField_3);

		textField_7 = new JTextField();
		textField_7.setText(accountInfo.getArea());
		textField_7.setForeground(Color.BLACK);
		textField_7.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField_7.setColumns(10);
		textField_7.setBounds(627, 165, 316, 26);
		frmUpdateDetails.getContentPane().add(textField_7);

		JLabel lblNewLabel_7_1 = new JLabel("City");
		lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_7_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_7_1.setBounds(487, 202, 116, 31);
		frmUpdateDetails.getContentPane().add(lblNewLabel_7_1);

		JLabel lblNewLabel_7_2 = new JLabel("State");
		lblNewLabel_7_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_7_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_7_2.setBounds(487, 240, 116, 31);
		frmUpdateDetails.getContentPane().add(lblNewLabel_7_2);

		textField_8 = new JTextField();
		textField_8.setText(accountInfo.getCity());
		textField_8.setForeground(Color.BLACK);
		textField_8.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField_8.setColumns(10);
		textField_8.setBounds(627, 202, 316, 26);
		frmUpdateDetails.getContentPane().add(textField_8);

		textField_9 = new JTextField();
		textField_9.setText(accountInfo.getState());
		textField_9.setForeground(Color.BLACK);
		textField_9.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField_9.setColumns(10);
		textField_9.setBounds(627, 240, 316, 26);
		frmUpdateDetails.getContentPane().add(textField_9);

		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtTest.getText();
				String email = textField_1.getText();
				String con = textField_2.getText();
				String gen = textField_3.getText();
				String area = textField_7.getText();
				String city = textField_8.getText();
				String state = textField_9.getText();
				String pin = textField_10.getText();
				if (name.isEmpty() || email.isEmpty() || con.isEmpty() || gen.isEmpty() || area.isEmpty()
						|| city.isEmpty() || state.isEmpty() || pin.isEmpty()) {
					PopUps.showFailureMsg(frmUpdateDetails, "Fields cannot be empty.", "Authentication failed");
				} else {
					AccountCrud ac = new AccountCrud();
					boolean res = ac.updateAccountInfo(name, email, con, gen, area, city, state, pin,
							accountInfo.getAcNo());
					System.out.print("RES:" + res);
					accountInfo.setName(name);
					accountInfo.setEmail(email);
					accountInfo.setContact(con);
					accountInfo.setGender(gen);
					accountInfo.setArea(area);
					accountInfo.setCity(city);
					accountInfo.setState(state);
					accountInfo.setPincode(pin);
					JOptionPane.showMessageDialog(frmUpdateDetails, "Information Updated", "Message",
							JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		btnNewButton.setBounds(431, 362, 103, 34);
		frmUpdateDetails.getContentPane().add(btnNewButton);

		textField_10 = new JTextField();
		textField_10.setText(accountInfo.getPincode());
		textField_10.setForeground(Color.BLACK);
		textField_10.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField_10.setColumns(10);
		textField_10.setBounds(627, 277, 316, 26);
		frmUpdateDetails.getContentPane().add(textField_10);

		JLabel lblNewLabel_7_2_1 = new JLabel("Pincode");
		lblNewLabel_7_2_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_7_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_7_2_1.setBounds(487, 277, 116, 31);
		frmUpdateDetails.getContentPane().add(lblNewLabel_7_2_1);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SavingAccount acc = new SavingAccount(accountInfo,SavingAccount.acType);
				acc.makeVisible(true);
				makeVisible(false);
			}
		});
		btnBack.setBounds(30, 12, 117, 25);
		frmUpdateDetails.getContentPane().add(btnBack);
		frmUpdateDetails.setBounds(100, 100, 1000, 520);
		frmUpdateDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
