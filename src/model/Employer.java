package model;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.DatabaseConnection;
import sun.security.util.Password;
import utility.Helper;

public class Employer {

	private String employer_User_Name;
	private String firstName;
	private String lastName;
	private String contactNumber;
	private String emailAddress;
	private String companyName;
	private String password;
	public Employer() {
		
	}
	public Employer(String companyName,String contactNumber,String emailAddress,String userName,String Password,String firstName,String lastName) {
		setLastName(lastName);
		setFirstName(firstName);
		setPassword(Password);
		setEmployer_User_Name(userName);
		setEmailAddress(emailAddress);
		setContactNumber(contactNumber);
		setCompanyName(companyName);
	}
	
	public String getEmployer_User_Name() {
		return employer_User_Name;
	}
	public void setEmployer_User_Name(String employer_User_Name) {
		this.employer_User_Name = employer_User_Name;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean login(String user,String pass) {
		boolean isValid=false;
		ResultSet rs;
		DatabaseConnection employer=new DatabaseConnection("jdbc:mysql://localhost:3306/sidequest_db", "root", "");
		Connection connection=employer.getConnection();
		try {
			
			PreparedStatement pre=connection.prepareStatement(SQL.DatabaseStaments.EMPLOYER_LOG_IN);
			pre.setString(1, user);
		
			pre.setString(2, pass);

			rs=pre.executeQuery();

			if(!rs.next()) {
				isValid= false;
			}else{
				isValid= true;
			}
		
			connection.close();
			employer.closeConnection();
		} catch (SQLException e) {
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			System.err.println(e.getMessage());
		}
		return isValid;
	
		
	}

	
	public void update(String sql,String var,String user) {
		
		DatabaseConnection employer=new DatabaseConnection("jdbc:mysql://localhost:3306/sidequest_db", "root", "");
		Connection connection=employer.getConnection();
		try {
			
			PreparedStatement pre1=connection.prepareStatement(sql);
			pre1.setString(1, var);
			pre1.setString(2,user);
			pre1.executeUpdate();

			connection.commit();
			
			connection.close();
		
			employer.closeConnection();
		} catch (SQLException e) {
	

			System.err.println(e.getMessage());
		}
	
	}
	
	public void changePassword() {
		String passwordChange=null;
		try {
			String password=Helper.getStringInput("Enter Current Password: ");
			ResultSet rs;
			DatabaseConnection employer=new DatabaseConnection("jdbc:mysql://localhost:3306/sidequest_db", "root", "");
			Connection connection=employer.getConnection();
			try {
				
				PreparedStatement pre=connection.prepareStatement(SQL.DatabaseStaments.EMPLOYER_LOGIN_CHECKING_QUERY);
				pre.setString(1, getEmployer_User_Name());
				pre.setString(2, password);
				rs=pre.executeQuery();
				
				if(rs.next()) {
					
					PreparedStatement pre1=connection.prepareStatement(SQL.DatabaseStaments.UPDATE_EMPLOYER_PASSWORD);
					passwordChange=Helper.getStringInput("Enter New Password:");
					pre1.setString(1, passwordChange);
					pre1.setString(3, getEmployer_User_Name());
					pre1.setString(2, rs.getString("password"));
					pre1.executeUpdate();
					connection.commit();
					
					
				}else {
					System.out.println("Password is incorrect");
				}
				connection.close();
				employer.closeConnection();
			} catch (SQLException e) {
				System.out.println("!!!!!21312321321312!!!!!!!!!");

			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
		
		
		
		
		
		
		
		
		
		
		
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

