package utility;

import java.io.IOException;

public class ValidInput {

	public static int getValidIntegerInput(int start, int end) {
		int choice = 0;
		boolean isValid = false;
		do {
			try {
				choice = Helper.getIntegerInput("Enter your choice:");
			} catch (NumberFormatException nfe) {
				System.out.println("Please enter a valid number format");
				System.out.println("Please try to input again...");
				continue;
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} finally {

				if (choice > end || choice < start) {
					System.out.println("You must enter an integer between " + start + " and " + end);
					System.out.println("Please try to input again...");
					continue;
				} else {
					isValid = true;
				}
			}
		} while (!isValid);
		return choice;
	}

	public static String getValidName(String var) {

		String name = null;

		do {
			try {
				name = Helper.getStringInput(var);

				if (!name.chars().allMatch(Character::isLetter)) {
					System.out.println("Name should contain only charaters");
					continue;
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
				continue;
			}

		} while (false);

		return name;
	}

	public static String getValidGender() {

		String name = null;

		try {

			do {

				name = Helper.getStringInput("Enter Gender: ");

				if (!(name.equalsIgnoreCase("m") || name.equalsIgnoreCase("f"))) {
					System.out.println("Gender must be F/M");
					continue;
				}

			} while (false);
		} catch (IOException e) {
			e.getMessage();
		}

		return name;

	}

	public static String getValidContact() {

		String name = null;
		do {
			try {

				name = Helper.getStringInput("Enter Contact Number: ");

				if (!name.chars().allMatch(Character::isDigit)) {
					System.out.println("ID should contain only charaters");
					continue;
				}
			} catch (IOException e) {

				e.getMessage();
			}
		} while (false);

		return name;

	}

}
