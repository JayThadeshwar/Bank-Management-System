package bank;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.SystemColor;
import javax.swing.UIManager;

import crud.TransactionCrud;
import model.Account;
import model.Transaction;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class BankStatement {

	private JFrame frmBankStatement;
	private Account account;
	private List<Transaction> trans;

	public void makeVisible(boolean val) {
		frmBankStatement.setVisible(val);
	}

	public BankStatement(Account a) {
		account = a;
		TransactionCrud tc = new TransactionCrud();
		trans = tc.getTransactions(account.getAcNo());
		initialize();
	}

	private void initialize() {
		frmBankStatement = new JFrame();
		frmBankStatement.setTitle("Bank Statement");
		frmBankStatement.getContentPane().setBackground(Color.WHITE);
		frmBankStatement.setBounds(100, 100, 1000, 520);
		frmBankStatement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBankStatement.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(34, 45, 918, 55);
		frmBankStatement.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Date");
		lblNewLabel.setBounds(70, 11, 126, 33);
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 24));
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1_1 = new JLabel("Debit");
		lblNewLabel_1_1.setBounds(276, 12, 126, 30);
		lblNewLabel_1_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.PLAIN, 24));
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1 = new JLabel("Credit");
		lblNewLabel_1.setBounds(490, 8, 115, 39);
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 24));
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Balance");
		lblNewLabel_1_1_1.setBounds(716, 11, 115, 33);
		lblNewLabel_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 24));
		panel.add(lblNewLabel_1_1_1);

		int incr = 0;
		for (Transaction tr : trans) {
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(UIManager.getColor("Checkbox.select"));
			panel_1.setBounds(34, 120+incr, 918, 55);
			frmBankStatement.getContentPane().add(panel_1);
			panel_1.setLayout(null);

			JLabel lblNewLabel_2 = new JLabel(tr.getTranDate().toString());
			lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 20));
			lblNewLabel_2.setBackground(SystemColor.menu);
			lblNewLabel_2.setBounds(45, 11, 126, 33);
			panel_1.add(lblNewLabel_2);

			JLabel lblNewLabel_1_1_2 = new JLabel(String.valueOf(tr.getDebit()));
			lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1_2.setFont(new Font("Dialog", Font.PLAIN, 20));
			lblNewLabel_1_1_2.setAlignmentX(0.5f);
			lblNewLabel_1_1_2.setBounds(241, 12, 126, 30);
			panel_1.add(lblNewLabel_1_1_2);

			JLabel lblNewLabel_1_2 = new JLabel(String.valueOf(tr.getCredit()));
			lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_2.setFont(new Font("Dialog", Font.PLAIN, 20));
			lblNewLabel_1_2.setBounds(460, 8, 115, 39);
			panel_1.add(lblNewLabel_1_2);

			JLabel lblNewLabel_1_2_1 = new JLabel(String.format("%.2f",tr.getBalance()));
			lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_2_1.setFont(new Font("Dialog", Font.PLAIN, 20));
			lblNewLabel_1_2_1.setBounds(668, 7, 219, 40);
			panel_1.add(lblNewLabel_1_2_1);
			incr += 75;
		}
		if(trans.size() == 0) {
			JLabel lblNewLabel_3 = new JLabel("No transaction occured.");
			lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 24));
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3.setBounds(309, 217, 382, 55);
			frmBankStatement.getContentPane().add(lblNewLabel_3);
		}
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SavingAccount acc = new SavingAccount(account,SavingAccount.acType);
				acc.makeVisible(true);
				makeVisible(false);
			}
		});
		btnBack.setBounds(34, 8, 117, 25);
		frmBankStatement.getContentPane().add(btnBack);
		
		

	}
}
