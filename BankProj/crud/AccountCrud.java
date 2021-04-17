package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.BankDb;
import model.Account;

public class AccountCrud {
	public boolean insertAccount(Account ac, int custId) {
		Connection con = BankDb.getConnection();
		String qry = "INSERT INTO account (accountNo,name,email,contact,dob,gender,panNo,aadharNo,city,area,state,pincode,cid) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		boolean res;
		try {
			PreparedStatement st = con.prepareStatement(qry);
			st.setString(1, ac.getAcNo());
			st.setString(2, ac.getName());
			st.setString(3, ac.getEmail());
			st.setString(4, ac.getContact());
			st.setDate(5, ac.getDob());
			st.setString(6, ac.getGender());
			st.setString(7, ac.getPanNo());
			st.setString(8, ac.getAadharNo());
			st.setString(9, ac.getCity());
			st.setString(10, ac.getArea());
			st.setString(11, ac.getState());
			st.setString(12, ac.getPincode());
			st.setInt(13, custId);
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

	public List<Account> getAccounts(int custId, int acType) {
		List<Account> acList = new ArrayList<Account>();
		Connection con = BankDb.getConnection();
		String qry = "";
		if(acType == 1)
			qry = "SELECT * FROM account WHERE cid = ? AND accountNo LIKE '___101%'";
		else if(acType == 2)
			qry = "SELECT * FROM account WHERE cid = ? AND accountNo LIKE '___201%'";
		else if(acType ==3)
			qry = "SELECT * FROM account WHERE cid = ? AND accountNo LIKE '___301%'";
		
		try {
			PreparedStatement st = con.prepareStatement(qry);
			st.setInt(1, custId);
			System.out.println(st);
			ResultSet res = st.executeQuery();
			while (res.next()) {
				Account ac = new Account();
				ac.setAcNo(res.getString("accountNo"));
				ac.setName(res.getString("name"));
				ac.setEmail(res.getString("email"));
				ac.setContact(res.getString("contact"));
				ac.setDob(res.getDate("dob"));
				ac.setGender(res.getString("gender"));
				ac.setPanNo(res.getString("panNo"));
				ac.setAadharNo(res.getString("aadharNo"));
				ac.setCity(res.getString("city"));
				ac.setArea(res.getString("area"));
				ac.setState(res.getString("state"));
				ac.setPincode(res.getString("pincode"));
				ac.setBalance(res.getDouble("balance"));
				acList.add(ac);
			}
			res.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return acList;
	}

	public boolean updateAccountInfo(String name, String email, String cont, String gen, String area, String city,
			String state, String pin, String acno) {
		Connection con = BankDb.getConnection();
		String qry = "UPDATE account SET name=?,email=?,contact=?,gender=?,area=?,city=?,state=?,pincode=? WHERE accountNo = ?";
		boolean res = false;
		try {
			PreparedStatement st = con.prepareStatement(qry);
			st.setString(1, name);
			st.setString(2, email);
			st.setString(3, cont);
			st.setString(4, gen);
			st.setString(5, area);
			st.setString(6, city);
			st.setString(7, state);
			st.setString(8, pin);
			st.setString(9, acno);
			System.out.println(st);			
			int aff = st.executeUpdate();
			if(aff>0)
				res = true;
			st.close();
			con.commit();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public boolean updateAccountBalance(double bal, String acNo) {
		Connection con = BankDb.getConnection();
		String qry = "UPDATE account SET balance = ? WHERE accountNo = ?";
		boolean op = false;
		int res;
		try {
			PreparedStatement st = con.prepareStatement(qry);
			st.setDouble(1, bal);
			st.setString(2, acNo);
			System.out.println(st);
			res = st.executeUpdate();
			if(res>0)
				op = true;
			st.close();
			con.commit();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			op = false;
		}
		return op;
	}
	
	public boolean updateSavingsAccountBalance() {
		Connection con = BankDb.getConnection();
		String qry = "UPDATE account SET balance = balance + (balance * 0.00010958904) WHERE accountNo LIKE '___101%';";
		boolean op = false;
		int res;
		try {
			PreparedStatement st = con.prepareStatement(qry);
			System.out.println(st);
			res = st.executeUpdate();
			if(res>0)
				op = true;
			st.close();
			con.commit();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			op = false;
		}
		return op;
	}
	
	public List<String> getAccountNumbers(int custId){
		String qry = "SELECT accountNo FROM account WHERE cid = ? AND (accountNo LIKE '___101%' OR '___201%');";
		Connection con = BankDb.getConnection();
		PreparedStatement st;
		List<String> accs = new ArrayList<String>();
		ResultSet rs;
		try {
			st = con.prepareStatement(qry);
			st.setInt(1, custId);
			System.out.println(st);
			rs = st.executeQuery();
			while(rs.next()) {
				accs.add(rs.getString("accountNo"));
			}
			st.close();
			con.commit();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();			
		}
		return accs;
	}
}
