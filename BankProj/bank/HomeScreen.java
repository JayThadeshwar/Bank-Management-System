package bank;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import bankutil.PopUps;
import model.Customer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.BevelBorder;

public class HomeScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	public static Customer currCustomer;
	
	public HomeScreen() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 520);
		setTitle("Home");
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.WHITE);

		JButton btnAccountInfo = new JButton("Account Info");
		btnAccountInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String msg = "Name:   " + currCustomer.getName() + "\n\n" + "Email:   " + currCustomer.getEmail() + "\n\n" + "Contact Number:   " + currCustomer.getContact()
						+ "\n\n" + "Date of Birth:   " + currCustomer.getDob() + "\n\n";
				PopUps.showPlainMsg(getContentPane(), msg, "Account Information");				
			}
		});
		btnAccountInfo.setBounds(35, 12, 158, 35);
		getContentPane().add(btnAccountInfo);
		

		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginScreen ls = new LoginScreen();
				ls.makeVisible();
				dispose();
				currCustomer = null;
			}
		});
		btnLogout.setBounds(811, 12, 140, 35);
		getContentPane().add(btnLogout);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SavingsAccountInfo acc = new SavingsAccountInfo(2);
				acc.makeVisible(true);
				setVisible(false);
			}
		});
		panel_1.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		panel_1.setBounds(35, 293, 382, 59);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblSavingAccount_1 = new JLabel("Current Account");
		lblSavingAccount_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSavingAccount_1.setFont(new Font("Dialog", Font.BOLD, 18));
		lblSavingAccount_1.setBounds(90, 12, 212, 35);
		panel_1.add(lblSavingAccount_1);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SavingsAccountInfo acc = new SavingsAccountInfo(3);
				acc.makeVisible(true);
				dispose();
			}
		});
		panel_1_1.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		panel_1_1.setBounds(35, 401, 382, 59);
		getContentPane().add(panel_1_1);
		panel_1_1.setLayout(null);

		JLabel lblSavingAccount_1_1 = new JLabel("Fixed Deposit Account");
		lblSavingAccount_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSavingAccount_1_1.setFont(new Font("Dialog", Font.BOLD, 18));
		lblSavingAccount_1_1.setBounds(75, 12, 241, 35);
		panel_1_1.add(lblSavingAccount_1_1);

		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SavingsAccountInfo acc = new SavingsAccountInfo(1);
				acc.makeVisible(true);
				dispose();
			}
		});
		panel_1_2.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		panel_1_2.setBounds(35, 183, 382, 59);
		getContentPane().add(panel_1_2);
		panel_1_2.setLayout(null);

		JLabel lblSavingAccount = new JLabel("Saving Account");
		lblSavingAccount.setFont(new Font("Dialog", Font.BOLD, 18));
		lblSavingAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblSavingAccount.setBounds(80, 12, 212, 35);
		panel_1_2.add(lblSavingAccount);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Payment pay = new Payment();
				pay.makeVisible(true);
				setVisible(false);
			}
		});
		panel_2.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		panel_2.setBounds(600, 184, 351, 117);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JLabel lblPayment = new JLabel("Payment / Money Transfer");
		lblPayment.setHorizontalAlignment(SwingConstants.CENTER);
		lblPayment.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblPayment.setBounds(49, 45, 252, 27);
		panel_2.add(lblPayment);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Loan ln = new Loan();
				ln.makeVisible(true);
				setVisible(false);
			}
		});
		panel_2_1.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		panel_2_1.setBounds(600, 343, 145, 117);
		getContentPane().add(panel_2_1);
		panel_2_1.setLayout(null);

		JLabel lblHomeLoan = new JLabel("Home Loan");
		lblHomeLoan.setHorizontalAlignment(SwingConstants.CENTER);
		lblHomeLoan.setFont(new Font("Dialog", Font.BOLD, 18));
		lblHomeLoan.setBounds(12, 51, 121, 15);
		panel_2_1.add(lblHomeLoan);

		JPanel panel_2_2 = new JPanel();
		panel_2_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CarLoan cl = new CarLoan();
				cl.makeVisible(true);
				setVisible(false);
			}
		});
		panel_2_2.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		panel_2_2.setBounds(806, 343, 145, 117);
		getContentPane().add(panel_2_2);
		panel_2_2.setLayout(null);

		JLabel lblCarLoan = new JLabel("Car Loan");
		lblCarLoan.setHorizontalAlignment(SwingConstants.CENTER);
		lblCarLoan.setFont(new Font("Dialog", Font.BOLD, 18));
		lblCarLoan.setBounds(12, 47, 121, 22);
		panel_2_2.add(lblCarLoan);

		JLabel lblHome = new JLabel("Home");
		lblHome.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setBounds(453, 68, 93, 28);
		getContentPane().add(lblHome);
	}

}
