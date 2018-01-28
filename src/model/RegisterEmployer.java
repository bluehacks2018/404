package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.DatabaseConnection;
public class RegisterEmployer {
	String pass;
	String user;
	Employer em;
	public RegisterEmployer(Employer em) {
		setPass(em.getPassword());
		setUser(em.getEmployer_User_Name());
		this.em=em;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	
	private boolean isUserExist() {
		boolean isExist=false;
		ResultSet rs;
		DatabaseConnection employer=new DatabaseConnection("jdbc:mysql://localhost:3306/sidequest_db", "root", "");
		Connection connection=employer.getConnection();
	
		try {
		
			PreparedStatement pre=connection.prepareStatement(SQL.DatabaseStaments.IS_EMPLOYER_EXIST);
			pre.setString(1, user);
			rs=pre.executeQuery();
			connection.commit();
			
			if(rs.next()) {
				isExist=true;
				System.out.println("User Name Existed");
			}
			connection.close();
			employer.closeConnection();
		
		} catch (SQLException e) {
			try {
				connection.rollback();
				System.err.println(e.getMessage());
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			}
			
		}
	
		return isExist;
		
	}
	
	
	public void register() {
		if (!isUserExist()) {
			DatabaseConnection employer=new DatabaseConnection("jdbc:mysql://localhost:3306/sidequest_db", "root", "");
			Connection connection=employer.getConnection();
			try {
				PreparedStatement pre=connection.prepareStatement(SQL.DatabaseStaments.INSERT_EMPLOYER_ACCOUNT);
				pre.setString(1, user);
				pre.setString(2, pass);
				pre.setString(3, em.getFirstName());
				pre.setString(4, em.getLastName());
				pre.setString(5, em.getContactNumber());
				pre.setString(6, em.getEmailAddress());
				pre.setString(7,"" );
				pre.executeUpdate();
				connection.commit();
				System.out.println("Register Successful");
			} catch (SQLException e) {
				try {
					connection.rollback();
					System.err.println(e.getMessage());
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				}
				
			}
			
			
			
			
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
