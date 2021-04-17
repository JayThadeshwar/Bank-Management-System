package bank;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Account;
import model.Fd;

import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class FDStatement {

	private JFrame frameStmt;
	private Fd account;
	private Account acc;

	public FDStatement(Fd fdac, Account fac) {
		account = fdac;
		acc = fac;
		initialize();
	}

	public void maketruestmt() {
		frameStmt.setVisible(true);
	}

	private void initialize() {
		frameStmt = new JFrame();
		frameStmt.setTitle("Fixed Deposit Statement");
		frameStmt.getContentPane().setBackground(Color.WHITE);
		frameStmt.setBounds(100, 100, 1000, 520);
		frameStmt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameStmt.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(34, 63, 918, 55);
		frameStmt.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Year");
		lblNewLabel.setBounds(70, 11, 126, 33);
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Interest");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(401, 8, 115, 39);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Amount");
		lblNewLabel_1_1_1.setBounds(680, 11, 151, 33);
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		panel.add(lblNewLabel_1_1_1);

		double amount = account.getAmount();
		int i = 6;
		double intamount, monthlyamount, mbalance = amount;
		int months = account.getDuration();


		int ctr = 4,k=0;
		double fm = 0, finval = amount;
		for (int j = 1; j <= months; j++) {
			intamount = ((amount * i) / 100);
			monthlyamount = (intamount / 12);
			mbalance += monthlyamount;
			if (j % 12 == 0) {
				amount += intamount;
				System.out.println("--------------------------------");
				System.out.println("Interest Amount(monthly)=" + monthlyamount);
				for (int z = 0; z < 3; z++) {
					fm = monthlyamount * 4;
					finval += fm;
					System.out.println(ctr + "\t" + (fm) + "\t" + finval);
					
					JPanel panel_1 = new JPanel();
					panel_1.setBackground(UIManager.getColor("Button.select"));
					panel_1.setBounds(34, 129+k, 918, 55);
					frameStmt.getContentPane().add(panel_1);
					panel_1.setLayout(null);

					JLabel lblNewLabel_2 = new JLabel("Month "+ctr);
					lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 23));
					lblNewLabel_2.setBackground(SystemColor.menu);
					lblNewLabel_2.setBounds(50, 10, 163, 33);
					panel_1.add(lblNewLabel_2);

					JLabel lblNewLabel_1_2 = new JLabel(String.valueOf(fm));
					lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 23));
					lblNewLabel_1_2.setBounds(421, 7, 115, 39);
					panel_1.add(lblNewLabel_1_2);
					
					
					JLabel lblNewLabel_1_2_1 = new JLabel(String.format("%.2f", finval));
					lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 23));
					lblNewLabel_1_2_1.setBounds(694, 7, 125, 39);
					panel_1.add(lblNewLabel_1_2_1);
					ctr+=4;
					k+=75;
				}
			}
		}

		JButton backbtn = new JButton("BACK");
		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FdCustList main = new FdCustList(acc);
				main.makeVisible(true);
				frameStmt.dispose();
			}
		});
		backbtn.setBounds(34, 12, 99, 35);
		frameStmt.getContentPane().add(backbtn);
	}
}
