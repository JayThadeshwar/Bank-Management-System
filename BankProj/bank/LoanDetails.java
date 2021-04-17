package bank;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;

public class LoanDetails {

	private JFrame frmLoanDetails;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoanDetails window = new LoanDetails();
					window.frmLoanDetails.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoanDetails() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoanDetails = new JFrame();
		frmLoanDetails.getContentPane().setBackground(Color.WHITE);
		frmLoanDetails.setTitle("Loan Details");
		frmLoanDetails.setBounds(100, 100, 1000, 520);
		frmLoanDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLoanDetails.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(39, 52, 918, 55);
		frmLoanDetails.getContentPane().add(panel);
		
		JLabel lblAccountNumber = new JLabel("Account Number");
		lblAccountNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccountNumber.setFont(new Font("Dialog", Font.PLAIN, 24));
		lblAccountNumber.setBackground(SystemColor.menu);
		lblAccountNumber.setBounds(43, 11, 208, 33);
		panel.add(lblAccountNumber);
		
		JLabel lblNewLabel_1_1 = new JLabel("Loan Amount");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.PLAIN, 24));
		lblNewLabel_1_1.setAlignmentX(0.5f);
		lblNewLabel_1_1.setBounds(295, 12, 200, 30);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Duration");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(563, 8, 115, 39);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Loan Type");
		lblNewLabel_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 24));
		lblNewLabel_1_1_1.setBounds(749, 11, 133, 33);
		panel.add(lblNewLabel_1_1_1);
		
		int k=121;
		for(int i=0;i<3;i++)
		{
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(39, k, 918, 55);
		frmLoanDetails.getContentPane().add(panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("2021-04-13");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel_2.setBackground(SystemColor.menu);
		lblNewLabel_2.setBounds(74, 10, 126, 33);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("1000");
		lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel_1_1_2.setAlignmentX(0.5f);
		lblNewLabel_1_1_2.setBounds(353, 11, 70, 30);
		panel_1.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("5000");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel_1_2.setBounds(585, 7, 115, 39);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("15000");
		lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel_1_2_1.setBounds(781, 7, 115, 39);
		panel_1.add(lblNewLabel_1_2_1);
		k=k+57;
		}
	}
}
