package bank;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import bankutil.PopUps;
import crud.CustomerCrud;
import model.Customer;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginScreen {

	private JFrame frame;
	private JTextField txtHey;
	private JPasswordField textField_1;

	public void makeVisible() {
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Timer time = new Timer(); 
					SchedTest st = new SchedTest();
					time.schedule(st, 0, 60000);
					LoginScreen window = new LoginScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginScreen() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setFont(new Font("Dialog", Font.PLAIN, 24));
		frame.setBounds(100, 100, 1000, 520);
		frame.setTitle("Login");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Dialog", Font.BOLD, 24));
		lblLogin.setBounds(437, 12, 125, 40);
		frame.getContentPane().add(lblLogin);

		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegisterScreen reg = new RegisterScreen();
				reg.setVisible(true);
				frame.dispose();
			}
		});
		btnRegister.setBounds(860, 12, 117, 40);
		frame.getContentPane().add(btnRegister);

		txtHey = new JTextField();
		txtHey.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtHey.setBounds(420, 172, 316, 40);
		frame.getContentPane().add(txtHey);
		txtHey.setColumns(10);

		textField_1 = new JPasswordField();
		textField_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(420, 251, 316, 40);
		frame.getContentPane().add(textField_1);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(185, 177, 134, 27);
		frame.getContentPane().add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblPassword.setBounds(185, 256, 134, 27);
		frame.getContentPane().add(lblPassword);

		JButton btnResetPassword_1 = new JButton("Login");
		btnResetPassword_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String uname, pass;
				uname = txtHey.getText();
				pass = textField_1.getText();
				boolean res;
				Customer cust = null;
				if (uname.isEmpty() || pass.isEmpty()) {
					res = false;
					PopUps.showFailureMsg(frame, "Username or password cannot be empty.", "Retry");
				} else {
					cust = new CustomerCrud().checkValidCustomer(uname, pass);
					HomeScreen.currCustomer = cust;

					if (cust.getName() == null) {
						PopUps.showFailureMsg(frame, "Either username or password is incorrect.",
								"Authentication failed");
						System.out.println("Invalid user");
					}
					else {
						PopUps.showSuccessMsg(frame, "Login successful", "Welcome");
						HomeScreen home = new HomeScreen();
						home.setVisible(true);
						frame.dispose();
					}
				}

			}
		});
		btnResetPassword_1.setBounds(415, 365, 170, 40);
		frame.getContentPane().add(btnResetPassword_1);
	}
}
