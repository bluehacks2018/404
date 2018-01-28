package utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.DatabaseConnection;

public class LoginEvent {
	String userName;
	String pass;
	
	public LoginEvent(String userName,String pass) {
		setPass(pass);
		setUserName(userName);
		
	}
	
	public boolean loginAsEmployer() {
		boolean isValid=false;
		ResultSet rs;
		DatabaseConnection employer=new DatabaseConnection("jdbc:mysql://localhost:3306/sidequest_db", "root", "");
		Connection connection=employer.getConnection();
		try {
			
			PreparedStatement pre=connection.prepareStatement(SQL.DatabaseStaments.EMPLOYER_LOGIN_CHECKING_QUERY);
			pre.setString(1, userName);
			pre.setString(2, pass);
			rs=pre.executeQuery();
			
			if(rs.next()) {
				isValid=true;
			}else {
				System.out.println("User name or Password is incorrect");
			}
			connection.close();
			employer.closeConnection();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		
		return isValid;
	}
	
	public boolean loginAsApplicant() {
		boolean isValid=false;
		ResultSet rs;
		DatabaseConnection employer=new DatabaseConnection("jdbc:mysql://localhost:3306/sidequest_db", "root", "");
		Connection connection=employer.getConnection();
		try {
			
			PreparedStatement pre=connection.prepareStatement(SQL.DatabaseStaments.APPLICANT_LOGIN_CHECKING_QUERY);
			pre.setString(1, userName);
			pre.setString(2, pass);
			rs=pre.executeQuery();
			
			if(rs.next()) {
				isValid=true;
			}else {
				System.out.println("User name or Password is incorrect");
			}
			connection.close();
			employer.closeConnection();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		
		return isValid;
	}
	
	
	
	
	
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	
	
	
	
	
}
