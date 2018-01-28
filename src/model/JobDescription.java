package model;

import java.sql.*;

import SQL.DatabaseStaments;
import connection.DatabaseConnection;

public class JobDescription {

	private int actvity_Id;
	private String applicant_UserName;
	private String employer_UserName;
	private String job_Description;
	private String location;
	private String title;
	private double salary;
	
	public JobDescription(String employerUserName,String jobContent,String Location,String title,Double salary) {
		setActvity_Id(JobDescription.getLatestId()+1);
		setApplicant_UserName("");
		setEmployer_UserName(employerUserName);
		setJob_Description(jobContent);
		setLocation(Location);
		setSalary(salary);
		setTitle(title);
		
	}
	private static int getLatestId() {
		int max=0;
		Connection jobActivity = new DatabaseConnection("jdbc:mysql://localhost:3306/sidequest_db", "root", "").getConnection();
		try {
			PreparedStatement prep= jobActivity.prepareStatement(DatabaseStaments.GET_LATEST_ACTIVITY_ID);
			ResultSet rs=prep.executeQuery();
			rs.next();
			max=rs.getInt(1);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return max;
	}
	public int getActvity_Id() {
		return actvity_Id;
	}
	public void setActvity_Id(int actvity_Id) {
		this.actvity_Id = actvity_Id;
	}
	public String getApplicant_UserName() {
		return applicant_UserName;
	}
	public void setApplicant_UserName(String applicant_UserName) {
		this.applicant_UserName = applicant_UserName;
	}
	public String getEmployer_UserName() {
		return employer_UserName;
	}
	public void setEmployer_UserName(String employer_UserName) {
		this.employer_UserName = employer_UserName;
	}
	public String getJob_Description() {
		return job_Description;
	}
	public void setJob_Description(String job_Description) {
		this.job_Description = job_Description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public void post() {
		
		Connection connection=new DatabaseConnection("jdbc:mysql://localhost:3306/sidequest_db", "root", "").getConnection();
		try {
			PreparedStatement prep= connection.prepareStatement(DatabaseStaments.POST_JOB);
			 
			prep.setInt(1, getActvity_Id());
			prep.setString(2, getApplicant_UserName());
			prep.setString(3,getEmployer_UserName());
			prep.setString(4, getJob_Description());
			prep.setString(5,getLocation());
			prep.setString(6,getTitle());
			prep.setDouble(7, getSalary());
			
			prep.executeUpdate();
			connection.commit();
			System.out.println("Post Success");
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("22222222222222222");
		}
		
		
	}
	
	
	
}
