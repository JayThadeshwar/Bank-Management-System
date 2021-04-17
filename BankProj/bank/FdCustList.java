package bank;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.UIManager;

import crud.FdCrud;
import model.Account;
import model.Fd;

import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FdCustList {

	private JFrame frmSavingsAccount;
	private List<Fd> accs;
	private int acType;
	private Account account;

	void makeVisible(boolean val) {
		frmSavingsAccount.setVisible(val);
	}

	public FdCustList(Account acn) {
		account = acn;
		FdCrud ac = new FdCrud();
		accs = ac.getFdAccounts(account.getAcNo());
		initialize();
	}

	private void initialize() {
		frmSavingsAccount = new JFrame();
		frmSavingsAccount.getContentPane().setBackground(Color.WHITE);
		frmSavingsAccount.setTitle("Select FD account");
		frmSavingsAccount.setBounds(100, 100, 1000, 520);
		frmSavingsAccount.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSavingsAccount.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(35, 70, 918, 55);
		frmSavingsAccount.getContentPane().add(panel);

		JLabel lblNewLabel_1_1 = new JLabel("FD number");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_1_1.setAlignmentX(0.5f);
		lblNewLabel_1_1.setBounds(50, 12, 207, 30);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1 = new JLabel("FD amount");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(364, 8, 207, 39);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("FD duration");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(718, 11, 140, 33);
		panel.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_3_1 = new JLabel("Select FD");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblNewLabel_3_1.setBounds(380, 12, 239, 27);
		frmSavingsAccount.getContentPane().add(lblNewLabel_3_1);

		JButton btnHome = new JButton("Back");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FixedDeposit fd = new FixedDeposit(account);
				fd.makeVisible(true);
				makeVisible(false);
			}
		});
		btnHome.setBounds(35, 12, 127, 27);
		frmSavingsAccount.getContentPane().add(btnHome);

		int incr = 0;
		for (Fd a : accs) {
			JPanel panel_1 = new JPanel();
			panel_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					FDStatement fds = new FDStatement(a,account);
					fds.maketruestmt();
					makeVisible(false);
				}
			});

			panel_1.setBackground(UIManager.getColor("Checkbox.select"));
			panel_1.setBounds(35, 145 + incr, 918, 55);
			frmSavingsAccount.getContentPane().add(panel_1);
			panel_1.setLayout(null);

			JLabel lblNewLabel_1_1_2 = new JLabel(String.valueOf(a.getFd()));
			lblNewLabel_1_1_2.setFont(new Font("Dialog", Font.PLAIN, 18));
			lblNewLabel_1_1_2.setAlignmentX(0.5f);
			lblNewLabel_1_1_2.setBounds(92, 12, 140, 40);
			panel_1.add(lblNewLabel_1_1_2);

			JLabel lblNewLabel_1_2 = new JLabel(String.valueOf(a.getAmount()));
			lblNewLabel_1_2.setFont(new Font("Dialog", Font.PLAIN, 18));
			lblNewLabel_1_2.setBounds(421, 8, 115, 39);
			panel_1.add(lblNewLabel_1_2);

			JLabel lblNewLabel_1_2_1 = new JLabel(String.valueOf(a.getDuration()));
			lblNewLabel_1_2_1.setFont(new Font("Dialog", Font.PLAIN, 18));
			lblNewLabel_1_2_1.setBounds(760, 8, 81, 39);
			panel_1.add(lblNewLabel_1_2_1);
			incr += 75;
		}
	}
}
