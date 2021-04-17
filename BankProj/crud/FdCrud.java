package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.BankDb;
import model.Fd;

public class FdCrud {
	public static boolean checkAccountNumber(String acNo) {
		Connection con = BankDb.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		boolean res = false;
		try {
			con = BankDb.getConnection();
			String check_user = "SELECT * FROM account where accountNo = ?";
			st = con.prepareStatement(check_user);
			st.setString(1, acNo);
			System.out.println(st.toString());
			rs = st.executeQuery();
			if (rs.next())
				res = true;
		} catch (Exception e) {
			System.out.println("Exception =" + e);
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (Exception e) {
				System.out.println("Exception in closing" + e);
			}
		}
		return res;
	}

	public static double getBalance(String acNo) {
		Connection con = BankDb.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		double amt = -1;
		try {
			con = BankDb.getConnection();
			String getBal = "SELECT balance FROM account where accountNo = ?";
			st = con.prepareStatement(getBal);
			st.setString(1, acNo);
			System.out.println(st.toString());
			rs = st.executeQuery();
			if (rs.next())
				amt = rs.getDouble(1);
		} catch (Exception e) {
			System.out.println("Exception =" + e);
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (Exception e) {
				System.out.println("Exception in closing" + e);
			}
		}
		return amt;
	}

	public static boolean insertInFD(double fdAmount, int timePeriod, String acNo) {
		Connection con = BankDb.getConnection();
		PreparedStatement st = null;
		boolean res = false;
		try {
			String upquery = "INSERT INTO fixeddeposit(amount,duration,acclinked) VALUES(?,?,?)";
			st = con.prepareStatement(upquery);
			st.setDouble(1, fdAmount);
			st.setInt(2, timePeriod);
			st.setString(3, acNo);
			System.out.println(st);
			int i = st.executeUpdate();
			if(i>0)
				res = true;
			con.commit();
		} catch (Exception e) {
			System.out.println("Exception =" + e);
		} finally {
			try {
				st.close();
				con.close();
			} catch (Exception e) {
				System.out.println("Exception in closing" + e);
			}
		}
		return res;
	}
	
	public List<Fd> getFdAccounts(String acNo) {
		List<Fd> acList = new ArrayList<Fd>();
		Connection con = BankDb.getConnection();
		String qry = "SELECT * FROM fixeddeposit WHERE acclinked = ?";			
		try {
			PreparedStatement st = con.prepareStatement(qry);
			st.setString(1, acNo);
			System.out.println(st);
			ResultSet res = st.executeQuery();
			while (res.next()) {
				Fd fdac = new Fd();
				fdac.setFd(res.getInt("fdid"));
				fdac.setAmount(res.getDouble("amount"));
				fdac.setDuration(res.getInt("duration"));
				fdac.setAccNoLink(res.getString("acclinked"));
				acList.add(fdac);
			}
			res.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return acList;
	}
}
