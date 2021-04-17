package bank;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import model.Account;

import javax.swing.UIManager;

public class FixedDeposit {

	private JFrame frame;
	private JFrame frame_1;
	private Account account;

	public FixedDeposit(Account ac) {
		account = ac;
		initialize();
	}

	public void makeVisible(boolean val) {
		frame_1.setVisible(val);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame_1 = new JFrame();
		frame_1.getContentPane().setBackground(Color.WHITE);
		frame_1.setTitle("Fixed Deposit Account");
		frame_1.setBounds(100, 100, 1000, 520);
		frame_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_1.getContentPane().setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(UIManager.getColor("Button.select"));
		panel_2.setLayout(null);
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, null));
		panel_2.setBounds(196, 98, 268, 159);
		frame_1.getContentPane().add(panel_2);

		JButton createBtn = new JButton("Create FD");
		createBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateFD fd = new CreateFD(account);
				fd.maketrue();
				frame.dispose();
			}
		});
		createBtn.setForeground(Color.BLACK);
		createBtn.setFont(new Font("Dialog", Font.PLAIN, 24));
		createBtn.setBackground(UIManager.getColor("Button.select"));
		createBtn.setBounds(56, 44, 160, 72);
		panel_2.add(createBtn);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, null));
		panel_1.setBackground(UIManager.getColor("Button.select"));
		panel_1.setBounds(503, 98, 268, 159);
		frame_1.getContentPane().add(panel_1);

		JButton stmtBtn = new JButton("FD Statement");
		stmtBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FdCustList fcl = new FdCustList(account);
				fcl.makeVisible(true);
				makeVisible(false);
			}
		});
		stmtBtn.setForeground(Color.BLACK);
		stmtBtn.setFont(new Font("Dialog", Font.PLAIN, 24));
		stmtBtn.setBackground(UIManager.getColor("Button.select"));
		stmtBtn.setBounds(15, 44, 238, 72);
		panel_1.add(stmtBtn);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, null));
		panel_2_1.setBackground(UIManager.getColor("Button.select"));
		panel_2_1.setBounds(196, 278, 268, 159);
		frame_1.getContentPane().add(panel_2_1);

		JButton updateBtn = new JButton("Update Details");
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateFDAccount upfd = new UpdateFDAccount(account);
				upfd.maketrueup();
				makeVisible(false);
			}
		});
		updateBtn.setForeground(Color.BLACK);
		updateBtn.setFont(new Font("Dialog", Font.PLAIN, 24));
		updateBtn.setBackground(UIManager.getColor("Button.select"));
		updateBtn.setBounds(15, 42, 238, 72);
		panel_2_1.add(updateBtn);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, null));
		panel_1_1.setBackground(UIManager.getColor("Button.select"));
		panel_1_1.setBounds(503, 278, 268, 159);
		frame_1.getContentPane().add(panel_1_1);

		String outputStr = "Name:   " + account.getName() + "\n\n" + "Email:   " + account.getEmail() + "\n\n"
				+ "Contact:   " + account.getContact() + "\n\n" + "Gender:   " + account.getGender() + "\n\n"
				+ "Aadhar:   " + account.getAadharNo() + "\n\n" + "Pan:   " + account.getPanNo() + "\n\n" + "DOB:   "
				+ account.getDob() + "\n\n" + "Area:   " + account.getArea() + "\n\n" + "City:   " + account.getCity()
				+ "\n\n" + "State:   " + account.getState() + "\n\n" + "Pincode:   " + account.getPincode() + "\n\n";

		JButton infoBtn = new JButton("Account Info");
		infoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, outputStr, "Account Information", JOptionPane.PLAIN_MESSAGE);
			}
		});
		infoBtn.setForeground(Color.BLACK);
		infoBtn.setFont(new Font("Dialog", Font.PLAIN, 24));
		infoBtn.setBackground(UIManager.getColor("Button.select"));
		infoBtn.setBounds(15, 43, 238, 72);
		panel_1_1.add(infoBtn);

		JLabel lblSavingsAccount = new JLabel("Fixed Deposit Account");
		lblSavingsAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblSavingsAccount.setFont(new Font("Times New Roman", Font.PLAIN, 33));
		lblSavingsAccount.setBounds(313, 0, 373, 86);
		frame_1.getContentPane().add(lblSavingsAccount);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SavingsAccountInfo sai = new SavingsAccountInfo(3);
				sai.makeVisible(true);
				makeVisible(false);
			}
		});
		btnBack.setBounds(30, 12, 117, 25);
		frame_1.getContentPane().add(btnBack);
	}
}
