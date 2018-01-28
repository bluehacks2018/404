package controller;

import java.awt.Choice;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sun.org.apache.bcel.internal.generic.GOTO;

import model.Applicant;
import model.Employer;
import model.JobDescription;
import model.RegisterApplicant;
import model.RegisterEmployer;
import utility.Helper;
import utility.LoginEvent;
import utility.ValidInput;
import view.Display;

public class MainApplication {

	public static void main(String[] args) {
		int option1,option2,option3,option4, registerChoice;
		boolean isLoginSuccessful = false;
		String user = null, pass = null;

		Display.showMenu1();
		option1 = ValidInput.getValidIntegerInput(1, 3);

		switch (option1) {
		case 1:
			try {
				do {
					Display.registerMenu1();
					registerChoice = ValidInput.getValidIntegerInput(1, 3);
					user = Helper.getStringInput("Enter User Name: ");
					pass = Helper.getStringInput("Enter Password: ");
					String firstName = ValidInput.getValidName("Enter first Name:");
					String lastName = ValidInput.getValidName("Enter Last Name:");
					String Contact = ValidInput.getValidContact();
					String Email = Helper.getStringInput("Enter email:");
					String gender = ValidInput.getValidGender();
					if (registerChoice != 3 && registerChoice == 1) {
						Employer em = new Employer("", Contact, Email, user, pass, firstName, lastName);
						RegisterEmployer re = new RegisterEmployer(em);
						re.register();
					} else if (registerChoice != 3 && registerChoice == 2) {
						Applicant app = new Applicant(user, lastName, firstName, Contact, gender, Email, pass);
						RegisterApplicant registerApp = new RegisterApplicant(app);
						registerApp.register();

					}
					System.out.println();
				} while (registerChoice != 3);

			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
			break;

		case 2:
			do {
				System.out.println("---------Employer Login ------------");
				try {
					user = Helper.getStringInput("Enter User Name: ");
					pass = Helper.getStringInput("Enter Password: ");
					LoginEvent loginEmployer = new LoginEvent(user, pass);
					isLoginSuccessful = loginEmployer.loginAsEmployer();
				} catch (IOException e) {
					System.err.println(e.getMessage());
				}

			} while (!isLoginSuccessful);
			
			do {
				Display.employerMenu();
				option2= ValidInput.getValidIntegerInput(1, 5);
				if (option2 == 1) {
					try {
						String title = Helper.getStringInput("Enter the title for this job:");
						String jobContent = Helper.getStringInput("Description this job: ");
						String location = Helper.getStringInput("Work Location:");
						// Double salary=ValidInput.getValidAmount();
						Double salary = Helper.getDoubleInput("Enter the salary:");
						JobDescription jd = new JobDescription(user, jobContent, location, title, salary);
						jd.post();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else if (option2 == 2) {
					do {
					Display.modifyEmployerInfo();
					option3=ValidInput.getValidIntegerInput(1, 5);
					Employer em =new Employer();
					switch (option3) {
					case 1:
						em =new Employer();
						if(em.login(user, pass)) {
							try {
								String contact= Helper.getStringInput("Enter Contact Number:");
								em.update(SQL.DatabaseStaments.UPDATE_EMPLOYER_CONTACT_NUMBER, contact,user);
							} catch (IOException e) {
								System.err.println(e.getMessage());
							}
						}
						break;
					case 2:
						em =new Employer();
						if(em.login(user, pass)) {
							try {
								String contact= Helper.getStringInput("Enter Email::");
								em.update(SQL.DatabaseStaments.UPDATE_EMPLOYER_EMAIL, contact,user);
							} catch (IOException e) {
								System.err.println(e.getMessage());
							}
						}
						break;

						
					case 3:
						em =new Employer();
						if(em.login(user, pass)) {
							try {
								String contact= Helper.getStringInput("Enter Company Name:");
								em.update(SQL.DatabaseStaments.UPDATE_EMPLOYER_COMPANNY, contact,user);
							} catch (IOException e) {
								System.err.println(e.getMessage());
							}
						}
						break;

				
					case 4:
						em = new Employer();
						em.login(user,pass);
						em.changePassword();
						pass=em.getPassword();
					}
					
										
					}while(true);
				} else if (option2 == 3) {
					
					
				
				} else if (option2 == 4) {
					
					
			}
			 	}while(option2 != 5);
		
			break;
		case 3:
			do {
				System.out.println("---------Applicant Login ------------");
				try {
					user = Helper.getStringInput("Enter User Name: ");
					pass = Helper.getStringInput("Enter Password: ");
					LoginEvent loginEmployer = new LoginEvent(user, pass);
					isLoginSuccessful = loginEmployer.loginAsApplicant();

				} catch (IOException e) {
					System.err.println(e.getMessage());
				}
			} while (!isLoginSuccessful);
			Display.applicantMenu();
			break;
			

	


			}
		
	}
}

