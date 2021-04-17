package crud;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.BankDb;
import model.Transaction;

public class TransactionCrud {
	public boolean insertTransaction(double deb, double cre, double bal, String ac) {
		long millis=System.currentTimeMillis();  
		Date currDate=new Date(millis); 
		
		Connection con = BankDb.getConnection();
		String qry = "INSERT INTO transaction(tranDate, debit, credit, balance, accNo) VALUES (?,?,?,?,?)";
		boolean res;
		try {
			PreparedStatement st = con.prepareStatement(qry);
			st.setDate(1, currDate);
			st.setDouble(2, deb);
			st.setDouble(3, cre);
			st.setDouble(4, bal);
			st.setString(5, ac);			
			System.out.println(st);
			res = st.execute();
			st.close();
			con.commit();
			con.close();			
		} catch (SQLException e) {
			e.printStackTrace();
			res = false;
		}
		return res;
	}
	
	public List<Transaction> getTransactions(String acNo){
		Connection con = BankDb.getConnection();
		String qry = "SELECT * FROM transaction WHERE accNo = ?";
		List<Transaction> listTran = new ArrayList<Transaction>();
		try {
			PreparedStatement st = con.prepareStatement(qry);
			st.setString(1, acNo);			
			System.out.println(st);
			ResultSet res = st.executeQuery();
			while(res.next()) {
				Transaction t = new Transaction();
				t.setTranDate(res.getDate("tranDate"));
				t.setDebit(res.getDouble("debit"));
				t.setCredit(res.getDouble("credit"));
				t.setBalance(res.getDouble("balance"));
				listTran.add(t);
			}
			st.close();
			con.commit();
			con.close();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listTran;
	}
}
