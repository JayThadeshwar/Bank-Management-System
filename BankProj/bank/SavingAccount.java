package bank;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.border.EtchedBorder;

import bankutil.PopUps;
import crud.AccountCrud;
import crud.TransactionCrud;
import model.Account;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SavingAccount {

	private JFrame frmSavingsAccount;
	private Account account;
	public static int acType;

	public void makeVisible(boolean val) {
		frmSavingsAccount.setVisible(val);
	}

	public SavingAccount(Account oa, int ac) {
		account = oa;
		acType = ac;
		initialize();
	}

	private void initialize() {
		frmSavingsAccount = new JFrame();
		frmSavingsAccount.getContentPane().setBackground(Color.WHITE);
		if(acType == 1)
			frmSavingsAccount.setTitle("Savings Account");
		else
			frmSavingsAccount.setTitle("Cuurent Account");
		frmSavingsAccount.setBounds(100, 100, 1000, 520);
		frmSavingsAccount.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSavingsAccount.getContentPane().setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BankStatement bs = new BankStatement(account);
				bs.makeVisible(true);
				frmSavingsAccount.dispose();
			}
		});
		panel_2.setBackground(UIManager.getColor("Checkbox.select"));
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, null));
		panel_2.setBounds(356, 110, 568, 97);
		frmSavingsAccount.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JLabel lblAccountStatement = new JLabel("Account Statement");
		lblAccountStatement.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccountStatement.setFont(new Font("Dialog", Font.BOLD, 20));
		lblAccountStatement.setBounds(153, 37, 261, 22);
		panel_2.add(lblAccountStatement);

		JLabel lblSavingsAccount;
		if(acType == 1)
			lblSavingsAccount = new JLabel("Savings Account");
		else
			lblSavingsAccount = new JLabel("Current Account");
		lblSavingsAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblSavingsAccount.setFont(new Font("Dialog", Font.PLAIN, 24));
		lblSavingsAccount.setBounds(323, 12, 350, 67);
		frmSavingsAccount.getContentPane().add(lblSavingsAccount);

		JPanel panel_3 = new JPanel();
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String amt = JOptionPane.showInputDialog(frmSavingsAccount, "Enter Amount to Withdraw:");
				boolean res = false;
				double amount = 0;
				try {					
					amount = Double.parseDouble(amt);
					System.out.print("Inn");
					res = true;
				} catch (NumberFormatException exc) {
					PopUps.showFailureMsg(frmSavingsAccount, "Please enter numerical amount", "Invalid input");
				}
				if (res) {
					TransactionCrud tc = new TransactionCrud();
					AccountCrud ac = new AccountCrud();
					System.out.print("CB:"+account.getBalance());
					double newBal = account.getBalance() - amount;
					if(newBal>1000) {
						res = tc.insertTransaction(amount, 0, newBal, account.getAcNo());
						res = ac.updateAccountBalance(newBal,account.getAcNo());
						account.setBalance(newBal);
						if (res)
							JOptionPane.showMessageDialog(frmSavingsAccount, "Amount Withdrawn", "Message",
									JOptionPane.PLAIN_MESSAGE);
					} else {
						PopUps.showFailureMsg(frmSavingsAccount, "Minimum amount of 1000Rs is required.", "Withdraw overlimit");
					}
				}				
			}
		});
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, null));
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setBounds(51, 302, 268, 149);
		frmSavingsAccount.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblWithdraw = new JLabel("Withdraw");
		lblWithdraw.setHorizontalAlignment(SwingConstants.CENTER);
		lblWithdraw.setFont(new Font("Dialog", Font.BOLD, 20));
		lblWithdraw.setBounds(76, 63, 115, 22);
		panel_3.add(lblWithdraw);

		JPanel panel_3_1 = new JPanel();
		panel_3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String amt = JOptionPane.showInputDialog(frmSavingsAccount, "Enter Amount to Deposit:");
				boolean res = false;
				double amount = 0;
				try {
					amount = Double.parseDouble(amt);
					res = true;
				} catch (NumberFormatException exc) {
					PopUps.showFailureMsg(frmSavingsAccount, "Please enter numerical amount", "Invalid input");
				}
				if (res) {
					TransactionCrud tc = new TransactionCrud();
					AccountCrud ac = new AccountCrud();
					double newBal = account.getBalance() + amount;
					res = tc.insertTransaction(0, amount, newBal, account.getAcNo());
					res = ac.updateAccountBalance(newBal,account.getAcNo());
					account.setBalance(newBal);
					if (res)
						JOptionPane.showMessageDialog(frmSavingsAccount, "Amount Deposited", "Message",
								JOptionPane.PLAIN_MESSAGE);
				}

			}
		});
		panel_3_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, null));
		panel_3_1.setBackground(Color.LIGHT_GRAY);
		panel_3_1.setBounds(51, 110, 268, 149);
		frmSavingsAccount.getContentPane().add(panel_3_1);
		panel_3_1.setLayout(null);

		JLabel lblDeposit = new JLabel("Deposit");
		lblDeposit.setFont(new Font("Dialog", Font.BOLD, 20));
		lblDeposit.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeposit.setBounds(76, 63, 115, 22);
		panel_3_1.add(lblDeposit);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String outputStr = "Name:   " + account.getName() + "\n\n" + "Email:   " + account.getEmail() + "\n\n"
						+ "Contact:   " + account.getContact() + "\n\n" + "Gender:   " + account.getGender() + "\n\n"
						+ "Aadhar:   " + account.getAadharNo() + "\n\n" + "Pan:   " + account.getPanNo() + "\n\n"
						+ "DOB:   " + account.getDob() + "\n\n" + "Area:   " + account.getArea() + "\n\n" + "City:   "
						+ account.getCity() + "\n\n" + "State:   " + account.getState() + "\n\n" + "Pincode:   "
						+ account.getPincode() + "\n\n";
				JOptionPane.showMessageDialog(frmSavingsAccount, outputStr, "Account Information",
						JOptionPane.PLAIN_MESSAGE);
			}
		});
		panel_2_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, null));
		panel_2_1.setBackground(UIManager.getColor("Button.select"));
		panel_2_1.setBounds(356, 354, 568, 97);
		frmSavingsAccount.getContentPane().add(panel_2_1);
		panel_2_1.setLayout(null);

		JLabel lblAccountInformation = new JLabel("Account Information");
		lblAccountInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccountInformation.setFont(new Font("Dialog", Font.BOLD, 20));
		lblAccountInformation.setBounds(153, 37, 261, 22);
		panel_2_1.add(lblAccountInformation);

		JPanel panel_2_2 = new JPanel();
		panel_2_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UpdateInfo ui = new UpdateInfo(account);
				ui.makeVisible(true);
				makeVisible(false);
			}
		});
		panel_2_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, null));
		panel_2_2.setBackground(UIManager.getColor("Button.select"));
		panel_2_2.setBounds(356, 230, 568, 97);
		frmSavingsAccount.getContentPane().add(panel_2_2);
		panel_2_2.setLayout(null);

		JLabel lblUodateAccountInformation = new JLabel("Update Account Info");
		lblUodateAccountInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblUodateAccountInformation.setFont(new Font("Dialog", Font.BOLD, 20));
		lblUodateAccountInformation.setBounds(153, 37, 261, 22);
		panel_2_2.add(lblUodateAccountInformation);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SavingsAccountInfo acc = new SavingsAccountInfo(1);
				acc.makeVisible(true);
				makeVisible(false);
			}
		});
		btnBack.setBounds(51, 12, 117, 25);
		frmSavingsAccount.getContentPane().add(btnBack);
	}
}
