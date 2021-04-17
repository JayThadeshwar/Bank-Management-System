package bank;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.UIManager;

import crud.AccountCrud;
import model.Account;

import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SavingsAccountInfo {

	private JFrame frmSavingsAccount;
	private List<Account> accs;
	private int acType;
	
	void makeVisible(boolean val) {
		frmSavingsAccount.setVisible(val);
	}

	public SavingsAccountInfo(int acn) {
		acType = acn;
		AccountCrud ac = new AccountCrud();
		accs = ac.getAccounts(HomeScreen.currCustomer.getId(),acType);		
		initialize();
	}

	private void initialize() {
		frmSavingsAccount = new JFrame();
		frmSavingsAccount.getContentPane().setBackground(Color.WHITE);
		if(acType == 1)
			frmSavingsAccount.setTitle("Savings Account");
		else if(acType == 2)
			frmSavingsAccount.setTitle("Current Account");
		else if(acType ==3)
			frmSavingsAccount.setTitle("Fixed deposit Account");
		
		frmSavingsAccount.setBounds(100, 100, 1000, 520);
		frmSavingsAccount.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSavingsAccount.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(35, 70, 918, 55);
		frmSavingsAccount.getContentPane().add(panel);
		
		JLabel lblNewLabel_1_1 = new JLabel("Account Number");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_1_1.setAlignmentX(0.5f);
		lblNewLabel_1_1.setBounds(62, 12, 207, 30);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Customer Name");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(380, 8, 207, 39);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Balance");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(743, 11, 115, 33);
		panel.add(lblNewLabel_1_1_1);
		
		JButton btnNewButton = new JButton("Create Account");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CreateAccount ca = new CreateAccount(acType);
				ca.makeVisible(true);
				makeVisible(false);
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 20));
		btnNewButton.setBounds(684, 422, 256, 48);
		frmSavingsAccount.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_3_1 = new JLabel("Select Account");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblNewLabel_3_1.setBounds(380, 12, 239, 27);
		frmSavingsAccount.getContentPane().add(lblNewLabel_3_1);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HomeScreen hs = new HomeScreen();
				hs.setVisible(true);
				makeVisible(false);
			}
		});
		btnHome.setBounds(35, 12, 127, 27);
		frmSavingsAccount.getContentPane().add(btnHome);
		
		int incr = 0;
		for(Account a : accs) {
			JPanel panel_1 = new JPanel();
			panel_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(acType == 1) {
						SavingAccount acc = new SavingAccount(a,1);
						acc.makeVisible(true);
						makeVisible(false);
					}
					else if(acType == 2) {
						SavingAccount acc = new SavingAccount(a,2);
						acc.makeVisible(true);
						makeVisible(false);
					}
					else if(acType ==3) {
						FixedDeposit fd = new FixedDeposit(a);
						fd.makeVisible(true);
						makeVisible(false);
					}
				}
			});
			
			panel_1.setBackground(UIManager.getColor("Checkbox.select"));
			panel_1.setBounds(35, 145+incr, 918, 55);
			frmSavingsAccount.getContentPane().add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblNewLabel_1_1_2 = new JLabel(a.getAcNo());
			lblNewLabel_1_1_2.setFont(new Font("Dialog", Font.PLAIN, 18));
			lblNewLabel_1_1_2.setAlignmentX(0.5f);
			lblNewLabel_1_1_2.setBounds(92, 12, 140, 40);
			panel_1.add(lblNewLabel_1_1_2);
			
			JLabel lblNewLabel_1_2 = new JLabel(a.getName());
			lblNewLabel_1_2.setFont(new Font("Dialog", Font.PLAIN, 18));
			lblNewLabel_1_2.setBounds(421, 8, 115, 39);
			panel_1.add(lblNewLabel_1_2);
			
			JLabel lblNewLabel_1_2_1 = new JLabel(String.format("%.2f",a.getBalance()));
			lblNewLabel_1_2_1.setFont(new Font("Dialog", Font.PLAIN, 18));
			lblNewLabel_1_2_1.setBounds(760, 8, 200, 39);
			panel_1.add(lblNewLabel_1_2_1);
			incr += 75;
		}
	}
}
