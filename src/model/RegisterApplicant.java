package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.DatabaseConnection;
public class RegisterApplicant {
	String pass;
	String user;
	Applicant ap;
	public RegisterApplicant(Applicant app) {
		setPass(app.getPassword());
		setUser(app.getApplicant_User_Name());
		setAp(app);;
	}

	public Applicant getAp() {
		return ap;
	}

	public void setAp(Applicant ap) {
		this.ap = ap;
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
			
			PreparedStatement pre=connection.prepareStatement(SQL.DatabaseStaments.IS_APPLICANT_EXIST);
			pre.setString(1, user);
			rs=pre.executeQuery();
			
			if(rs.next()) {
				isExist=true;
				System.out.println("User Name Exist");
			}
			connection.close();
			employer.closeConnection();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	
		return isExist;
		
	}
	
	
	public void register() {
		if (!isUserExist()) {
			DatabaseConnection applicant=new DatabaseConnection("jdbc:mysql://localhost:3306/sidequest_db", "root", "");
			Connection connection=applicant.getConnection();
			
			try {
				PreparedStatement pre=connection.prepareStatement(SQL.DatabaseStaments.INSERT_APPLICANT_ACCOUNT);
				pre.setString(1, user);
				pre.setString(2, pass);
				pre.setString(3,ap.getFirstName() );
				pre.setString(4, ap.getLastName());
				pre.setString(5, ap.getContact_Number());
				pre.setString(6, ap.getEmail());
				pre.setString(7, "");
				pre.setString(8, ap.getGender());
				pre.executeUpdate();
				connection.commit();
				System.out.println("Register Successful");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
