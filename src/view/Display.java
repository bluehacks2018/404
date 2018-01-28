package view;


public class Display {
	public static void showMenu1() {
		System.out.println();
		System.out.println("[1] Register New Account\n"+
				           "[2] Login As Employer\n"+
				           "[3] Login As Applicant\n");
	}
	
	public static void registerMenu1() {
		System.out.println("[1] Register An Employer Account\n"+
		           "[2]Register An Applicant Account\n"+
		           "[3]Back\n");
	}
	
	public static void employerMenu() {
		
		System.out.println("[1] Insert new job and Update " + 
							"\n[2] Update company portfolio/info" +
							"\n[3] Select Applicant Portfolio" + 
							"\n[4] Remove Applicant" + 
							"\n[5] Logout");
	
	}
	
	public static void applicantMenu() {
		
		System.out.println("[1] Available Jobs" +
							"\n[2] Update Profile or Portfolio" +
							"\n[3] Search Company");
		
	}
	
	public static void modifyEmployerInfo() {
		System.out.println("[1] Change/Update ContactNumber\n" + 
				"[2] Change/Update Email Address\n" + 
				"[3]Change/Update Company Name\n" + 
				"[4]Change/Update password\n"
				+ "[5]Back");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
