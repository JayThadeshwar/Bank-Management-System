package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.BankDb;
import model.Customer;

public class CustomerCrud {
	public boolean insertCustomer(Customer c){
		Connection con = BankDb.getConnection();
		String qry = "INSERT INTO customer (name,contact,dob,password,email) VALUES(?,?,?,?,?)";
		boolean res;
		try {
			PreparedStatement st = con.prepareStatement(qry);
			st.setString(1, c.getName());
			st.setString(2, c.getContact());
			st.setDate(3, c.getDob());
			st.setString(4, c.getPassword());
			st.setString(5, c.getEmail());
			System.out.println(st.toString());
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

	public Customer checkValidCustomer(String email, String pass) {
		Customer c = new Customer();
		Connection con = BankDb.getConnection();
		String qry = "SELECT * FROM customer WHERE email = ? AND password = ?";				
		try {
			PreparedStatement st = con.prepareStatement(qry);
			st.setString(1, email);
			st.setString(2, pass);
			System.out.println(st.toString());
			ResultSet res = st.executeQuery();
			if(res.next()) {
				c.setId(res.getInt("id"));
				c.setName(res.getString("name"));
				c.setContact(res.getString("contact"));
				c.setEmail(res.getString("email"));
				c.setDob(res.getDate("dob"));
				c.setPassword("");
			}
			res.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();			
		}		
		return c;
	}
	
}
