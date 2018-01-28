package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.DatabaseConnection;
import utility.Helper;

public class Applicant {
	
	private String applicant_User_Name;
	private String firstName;
	private String lastName;
	private String contact_Number;
	private String description;
	private String gender;
	private String password;
	private String email;
	
	public Applicant(String UserName,String lastName,String firstName,String ContactNo,String gender,String email,String pass) {
		setApplicant_User_Name(UserName);
		setLastName(lastName);
		setContact_Number(ContactNo);
		setGender(gender);
		setLastName(lastName);
		setEmail(email);
		setPassword(pass);
		setFirstName(firstName);
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void register() {
		
	}
	public String getApplicant_User_Name() {
		return applicant_User_Name;
	}
	public  void setApplicant_User_Name(String applicant_User_Name) {
		this.applicant_User_Name =applicant_User_Name;
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
	public String getContact_Number() {
		return contact_Number;
	}
	public void setContact_Number(String contact_Number) {
		this.contact_Number = contact_Number;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void login(String user,String pass) {
		
		ResultSet rs;
		DatabaseConnection applicant=new DatabaseConnection("jdbc:mysql://localhost:3306/sidequest_db", "root", "");
		Connection connection=applicant.getConnection();
		try {
			
			PreparedStatement pre=connection.prepareStatement(SQL.DatabaseStaments.APPLICANT_LOG_IN);
			pre.setString(1, user);
		
			pre.setString(2, pass);

			rs=pre.executeQuery();

			rs.next();
		
			setApplicant_User_Name(user);
			setPassword(pass);
			setEmail(rs.getString("email"));
			setContact_Number(rs.getString("contact_Number"));
			setDescription(rs.getString("description"));
			setGender(rs.getString("gender"));
			setFirstName(rs.getString("first_Name"));
			setLastName(rs.getString("last_Name"));
			connection.close();
			applicant.closeConnection();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}	
		
	}
	
	public void update() {
		
		DatabaseConnection applicant=new DatabaseConnection("jdbc:mysql://localhost:3306/sidequest_db", "root", "");
		Connection connection=applicant.getConnection();
		try {
			
			PreparedStatement pre1=connection.prepareStatement(SQL.DatabaseStaments.UPDATE_APPLICANT);
			pre1.setString(1, getContact_Number());
			pre1.setString(2, getEmail());
			pre1.setString(3, getApplicant_User_Name());
			pre1.setString(4, getPassword());
			pre1.executeUpdate();
			connection.commit();
			connection.close();
			applicant.closeConnection();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	
	}
	
	public void changePassword() {
		String passwordChange=null;
		try {
			String password=Helper.getStringInput("Enter Current Password: ");
			ResultSet rs;
			DatabaseConnection applicant=new DatabaseConnection("jdbc:mysql://localhost:3306/sidequest_db", "root", "");
			Connection connection=applicant.getConnection();
			try {
				
				PreparedStatement pre=connection.prepareStatement(SQL.DatabaseStaments.APPLICANT_LOGIN_CHECKING_QUERY);
				pre.setString(1, getApplicant_User_Name());
				pre.setString(2, password);
				rs=pre.executeQuery();
				
				if(rs.next()) {
					
					PreparedStatement pre1=connection.prepareStatement(SQL.DatabaseStaments.UPDATE_APPLICANT_PASSWORD);
					passwordChange=Helper.getStringInput("Enter New Password:");
					pre1.setString(1, passwordChange);
					pre1.setString(3, getApplicant_User_Name());
					pre1.setString(2, rs.getString("password"));
					pre1.executeUpdate();
					connection.commit();
				
				}else {
					System.out.println("Password is incorrect");
				}
				connection.close();
				applicant.closeConnection();
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	
	

	}
	
	
	
	
	
	


