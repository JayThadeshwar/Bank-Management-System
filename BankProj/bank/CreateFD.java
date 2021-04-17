package bank;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import java.awt.Button;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.SwingConstants;

import bankutil.PopUps;
import crud.AccountCrud;
import crud.FdCrud;
import crud.TransactionCrud;
import model.Account;

public class CreateFD {

	private JFrame fdFrame;
	private JTextField tinvest_input;
	private JTextField tperiod_input;
	private JTextField tranAcc_input;
	private String tranAcc;
	private double fdAmount;
	private int timePeriod;
	private Account account;

	public void maketrue() {
		fdFrame.setVisible(true);
	}

	boolean validateData() {
		String tinvest = tinvest_input.getText();
		String tperiod = tperiod_input.getText();
		tranAcc = tranAcc_input.getText();

		if (tinvest.isEmpty() || tperiod.isEmpty() || tranAcc.isEmpty()) {
			return false;
		} else if (tinvest.matches("[0-9]+")) {
			if (tperiod.matches("[0-9]+")) {
				if (tranAcc.matches("[a-zA-Z0-9]+")) {

					return true;
				}
			}
			return false;
		} else {
			return false;
		}
	}

	public CreateFD(Account ac) {
		account = ac;
		initialize();
	}

	public boolean checkFD() {
		String am = tinvest_input.getText();
		fdAmount = Double.parseDouble(am);
		String p = tperiod_input.getText();
		timePeriod = Integer.parseInt(p);

		boolean exists = FdCrud.checkAccountNumber(tranAcc_input.getText());

		if ((fdAmount >= 1000) && (timePeriod > 0 && timePeriod <= 120) && exists) {
			return true;
		} else {
			return false;
		}
	}

	private void initialize() {
		fdFrame = new JFrame();
		fdFrame.setBounds(100, 100, 1000, 520);
		fdFrame.getContentPane().setBackground(Color.WHITE);
		fdFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fdFrame.getContentPane().setLayout(null);

		JLabel lblCreateFixedDeposit = new JLabel("Create Fixed Deposit");
		lblCreateFixedDeposit.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateFixedDeposit.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblCreateFixedDeposit.setBounds(336, 70, 327, 35);
		fdFrame.getContentPane().add(lblCreateFixedDeposit);

		JLabel lblNewLabel_1 = new JLabel("Total Investment:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(340, 129, 120, 19);
		fdFrame.getContentPane().add(lblNewLabel_1);

		tinvest_input = new JTextField();
		tinvest_input.setColumns(10);
		tinvest_input.setBounds(525, 130, 138, 20);
		fdFrame.getContentPane().add(tinvest_input);

		JLabel lblNewLabel_1_1 = new JLabel("Time Period(in months):");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(309, 160, 186, 19);
		fdFrame.getContentPane().add(lblNewLabel_1_1);

		tperiod_input = new JTextField();
		tperiod_input.setColumns(10);
		tperiod_input.setBounds(525, 161, 138, 20);
		fdFrame.getContentPane().add(tperiod_input);

		Button submitbutton = new Button("Submit");
		submitbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean val = validateData();
				if (val == true) {

					boolean check = checkFD();
					String acNo = tranAcc_input.getText();
					double bal = FdCrud.getBalance(acNo);
					if (check) {
						if (bal >= fdAmount) {
							bal = bal - fdAmount;
							if(bal<=1000) {
								PopUps.showFailureMsg(fdFrame, "Account balance cannot go below 1000", "Insufficient balance");
							} else {
								boolean res = FdCrud.insertInFD(fdAmount, timePeriod, account.getAcNo());
								if (res) {
									JOptionPane.showMessageDialog(fdFrame, "FD Created!", "Message",
											JOptionPane.PLAIN_MESSAGE);
									AccountCrud ac = new AccountCrud();
									boolean finop = ac.updateAccountBalance(bal, acNo);
									TransactionCrud tc = new TransactionCrud();
									tc.insertTransaction(fdAmount, 0, bal, acNo);
									System.out.println(finop);
								}
							}							
						} else {
							JOptionPane.showMessageDialog(fdFrame, "Insufficient Balance!", "Message",
									JOptionPane.PLAIN_MESSAGE);
							JOptionPane.showMessageDialog(fdFrame, "FD not Created!", "Message",
									JOptionPane.PLAIN_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(fdFrame, "FD not Created!", "Message", JOptionPane.PLAIN_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(fdFrame, "Invalid Input!", "Message", JOptionPane.PLAIN_MESSAGE);
				}

			}
		});
		submitbutton.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		submitbutton.setBounds(432, 262, 135, 35);
		fdFrame.getContentPane().add(submitbutton);

		JLabel lblNewLabel_1_1_1 = new JLabel("Rate of Interest:");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(309, 220, 166, 19);
		fdFrame.getContentPane().add(lblNewLabel_1_1_1);

		JLabel taccount_input = new JLabel("6.0%");
		taccount_input.setFont(new Font("Tahoma", Font.PLAIN, 14));
		taccount_input.setBounds(525, 220, 135, 19);
		fdFrame.getContentPane().add(taccount_input);

		JButton backbtn = new JButton("BACK");
		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FixedDeposit main = new FixedDeposit(account);
				main.makeVisible(true);
				fdFrame.dispose();
			}
		});
		backbtn.setBounds(12, 12, 99, 35);
		fdFrame.getContentPane().add(backbtn);

		JLabel lblNewLabel_1_1_2 = new JLabel("Transfer Amount from Account");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_2.setBounds(283, 190, 236, 19);
		fdFrame.getContentPane().add(lblNewLabel_1_1_2);

		tranAcc_input = new JTextField();
		tranAcc_input.setColumns(10);
		tranAcc_input.setBounds(525, 189, 138, 20);
		fdFrame.getContentPane().add(tranAcc_input);

	}
}
