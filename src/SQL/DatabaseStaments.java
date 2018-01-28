package SQL;

public interface DatabaseStaments {
	//EMPLOYER
	String IS_EMPLOYER_EXIST = "SELECT employer_User_Name FROM employer WHERE employer_User_Name = ? ";

	String INSERT_EMPLOYER_ACCOUNT = "INSERT INTO employer(employer_User_Name,password,first_Name,last_Name,contact_Number,email_Address, company_Name) "
			+ "	VALUES (?,?,?,?,?,?,?) ";

	String EMPLOYER_LOGIN_CHECKING_QUERY = "SELECT employer_User_Name,password FROM employer WHERE employer_User_Name = ? AND password= ?  ";
	
	String EMPLOYER_LOG_IN="SELECT * FROM employer WHERE employer_User_Name=? and password=?";
	
	String UPDATE_EMPLOYER = "UPDATE employer SET contact_Number=?, email_Address = ?, company_Name = ? + "
			+ "employer_User_Name= ? ";
	String UPDATE_EMPLOYER_CONTACT_NUMBER = "UPDATE employer SET contact_Number= ? "
			+ "employer_User_Name = ?";
	String UPDATE_EMPLOYER_EMAIL = "UPDATE employer SET email_Address = ?  "
			+ "employer_User_Name= ? ";
	String UPDATE_EMPLOYER_COMPANNY= "UPDATE employer SET company_Name = ?  "
			+ "employer_User_Name= ? ";
	
	String UPDATE_EMPLOYER_PASSWORD = "UPDATE employer SET password= ? "
			+ "WHERE password= ? AND employer_User_Name= ? ";
	
	String GET_LATEST_ACTIVITY_ID = "SELECT MAX(activity_Id) AS LatestID FROM job";
	
	String POST_JOB="INSERT INTO job(activity_Id,applicant_User_Name,emplyer_User_Name,job_Description,location,title,salary) "
			+ "VALUE(?,?,?,?,?,?,?)";
	
	
	
	//APPLICANT
	String INSERT_APPLICANT_ACCOUNT = "INSERT INTO applicants(applicant_User_Name,password,first_Name,last_Name, contact_Number, email, description, gender)"
			+ "VALUES(?,?,?,?,?,?,?,?)";

	String IS_APPLICANT_EXIST = "SELECT applicant_User_Name FROM applicants WHERE applicant_User_Name = ? ";
	
	String APPLICANT_LOGIN_CHECKING_QUERY = "SELECT applicant_User_Name,password FROM applicants WHERE applicant_User_Name = ? AND password= ?  ";
	
	String APPLICANT_LOG_IN="SELECT * FROM applicant WHERE applicant_User_Name=? and password=?";
	
	String UPDATE_APPLICANT = "UPDATE applicant SET contact_Number=?, email_Address = ?, company_Name = ? + "
			+ "WHERE password=? AND applicant_User_Name= ? ";
	
	String UPDATE_APPLICANT_PASSWORD = "UPDATE applicant SET password=? + "
			+ "WHERE password= ? AND applicant_User_Name= ? ";
	
	
	

}
