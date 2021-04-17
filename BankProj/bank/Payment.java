package bank;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import bankutil.PopUps;
import crud.AccountCrud;
import crud.FdCrud;
import crud.TransactionCrud;

import java.awt.Font;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Payment {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JComboBox comboBox;	
	private String accNo[];
	
	void makeVisible(boolean val){
		frame.setVisible(val);
	}
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Payment window = new Payment();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public Payment() {
		AccountCrud ac = new AccountCrud();
		List<String> acNos = ac.getAccountNumbers(2);
		accNo = new String[acNos.size()];
		for(int i=0;i<acNos.size();i++) {
			accNo[i] = acNos.get(i);
		}
		
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1000, 520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HomeScreen hs = new HomeScreen();
				hs.setVisible(true);
				makeVisible(false);
			}
		});
		btnBack.setBounds(30, 12, 117, 25);
		frame.getContentPane().add(btnBack);

		JLabel lblNewLabel = new JLabel("Money Transfer");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(382, 12, 233, 38);
		frame.getContentPane().add(lblNewLabel);

		comboBox = new JComboBox(accNo);
		comboBox.setBounds(498, 126, 224, 24);
		frame.getContentPane().add(comboBox);

		JLabel lblAccountNumberTo = new JLabel("Account number to transfer from:");
		lblAccountNumberTo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAccountNumberTo.setBounds(201, 131, 248, 15);
		frame.getContentPane().add(lblAccountNumberTo);

		JLabel lblBeni = new JLabel("Beneficiary account number:");
		lblBeni.setHorizontalAlignment(SwingConstants.TRAILING);
		lblBeni.setBounds(216, 203, 233, 15);
		frame.getContentPane().add(lblBeni);

		textField = new JTextField();
		textField.setBounds(498, 195, 224, 31);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(498, 260, 224, 31);
		frame.getContentPane().add(textField_1);

		JLabel lblAmountToTransfer = new JLabel("Amount to transfer:");
		lblAmountToTransfer.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAmountToTransfer.setBounds(216, 268, 233, 15);
		frame.getContentPane().add(lblAmountToTransfer);

		JButton btnTransfer = new JButton("Transfer");
		btnTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String item = (String) comboBox.getSelectedItem();
				String benAcNo = textField.getText();
				String amount = textField_1.getText();
				double amt = 0;
				boolean res = false;
				if(item.isEmpty() || benAcNo.isEmpty() || amount.isEmpty()) {
					PopUps.showFailureMsg(frame, "Some fields are empty.", "Invalid data");
				} else {
					res = FdCrud.checkAccountNumber(benAcNo);
					if(res)
						amt = Double.parseDouble(amount);
					else
						PopUps.showFailureMsg(frame, "Beneficiary account number does not exisit", "Account does not exisit");
				}
				double currBal = FdCrud.getBalance(item);
				double temp = currBal - amt;
				if(amt>currBal) {
					PopUps.showFailureMsg(frame, "Your current balance is "+currBal+" cannot tranfer above that.", "Insufficient balance");
				} else if(temp<=1000) {
					PopUps.showFailureMsg(frame, "Cannot transfer as minimum 1000Rs is required in account.", "Insufficient balance");
				} else {
					AccountCrud ac = new AccountCrud();
					boolean chk = ac.updateAccountBalance(temp,item);									
					if(chk) {
						TransactionCrud tc = new TransactionCrud();
						tc.insertTransaction(amt,0,temp,item);
						double bal = FdCrud.getBalance(benAcNo);
						bal += amt;
						chk = ac.updateAccountBalance(bal,benAcNo);
						tc.insertTransaction(0,amt,bal,benAcNo);
						PopUps.showSuccessMsg(frame, "Money transfered successfully", "Transfer complete");
					}
						
				}
			}
		});
		btnTransfer.setBounds(431, 358, 137, 31);
		frame.getContentPane().add(btnTransfer);
	}
}
