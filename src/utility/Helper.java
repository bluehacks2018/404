package utility;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Helper {
	// getReader
	private static BufferedReader getReader() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		return reader;
	}

	// getString
	public static String getStringInput(String var) throws IOException {
		String input = null;
		System.out.print(var);
		BufferedReader reader = getReader();

		input = reader.readLine();
		return input;

	}

	// getInteger
	public static int getIntegerInput(String var) throws IOException {
		int num = 0;
		System.out.print(var);
		BufferedReader reader = getReader();
		num = Integer.parseInt(reader.readLine());
		return num;
	}

	// getFloat
	public static float getFloatInput(String var) throws IOException {
		float num = 0f;
		System.out.print(var);
		BufferedReader reader = getReader();
		num = Float.parseFloat(reader.readLine());
		return num;
	}

	// getByte
	public static byte getByteInput(String var) throws IOException {
		byte num;
		System.out.print(var);
		BufferedReader reader = getReader();
		num = Byte.parseByte(reader.readLine());
		return num;
	}

	// getDouble
	public static double getDoubleInput(String var) throws IOException {
		double num = 0d;
		System.out.print(var);
		BufferedReader reader = getReader();
		num = Double.parseDouble(reader.readLine());
		return num;
	}

	// getShort
	public static short getShortInput(String var) throws IOException {
		short num = (short) 0;
		System.out.print(var);
		BufferedReader reader = getReader();
		num = Short.parseShort(reader.readLine());
		return num;
	}

	// getLong
	public static long getLongInput(String var) throws IOException {
		long num = (long) 0;
		System.out.print(var);
		BufferedReader reader = getReader();
		num = Long.parseLong(reader.readLine());
		return num;
	}

	public static void pressAnyKeyToContinue(){
		BufferedReader br = getReader();
		String anykey = null;
		System.out.print("Enter Anything to Continue : ");
		try {
			anykey = br.readLine();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	
		
	}

}
