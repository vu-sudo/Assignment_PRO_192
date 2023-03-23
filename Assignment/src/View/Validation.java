package View;

import java.util.Scanner;

public class Validation {
	public static Scanner sc = new Scanner(System.in);
	public static int InputInt(String msg, int min, int max) {
		if (min>max) {
			int t = min;
			min = max;
			max = t;
		}
		int data = 0;
		do {
			try {
				System.out.print(msg);
				data = Integer.parseInt(sc.nextLine());
			}
			catch (NumberFormatException e) {
				System.err.println("Please enter number!");
			}
		}
		while (data < min || data > max);
		return data;
	}
	
	public static long InputLong(String msg, long min, long max) {
		if (min>max) {
			long t = min;
			min = max;
			max = t;
		}
		long data = 0;
		do {
			try {
				System.out.print(msg);
				data = Long.parseLong(sc.nextLine());
			}
			catch (NumberFormatException e) {
				System.err.println("Please enter number!");
			}
		}
		while (data < min || data > max);
		return data;
	}
	public static double InputDouble(String msg, double min, double max) {
		if (min>max) {
			double t = min;
			min = max;
			max = t;
		}
		double data = 0;
		do {
			try {
				System.out.print(msg);
				data = Double.parseDouble(sc.nextLine());
			}
			catch (NumberFormatException e) {
				System.err.println("Please enter number!");
			}
		}
		while (data < min || data > max);
		return data;
	}
	
	public static String inputStr (String msg) {
		System.out.print(msg);
		String data = sc.nextLine().trim();
		return data;
	}
	
	public static String inputNonBlankStr (String msg) {
		String data;
		String pattern = "^[a-zA-Z]{4,}(?: [a-zA-Z]+){0,2}$";
		do {
			System.out.print(msg);
			data = sc.nextLine().trim();
		}
		while (data.length() == 0 && !data.matches(pattern));
		return data;
	}
	
	public static String inputPattern (String msg, String pattern) {
		String data;
		do {
			System.out.print(msg);
			data = sc.nextLine().trim();
		}
		while (!data.matches(pattern));
		return data;
	}
}
