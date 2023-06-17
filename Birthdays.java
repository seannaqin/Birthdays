
/* Seanna Qin
 * Programming Assignment #4, 11/9/22
 * The purpose of this program is to ask the user for the current date and the dates of two people's birthdays.
 * The program then prints out which day of the year each date is, and how many days until the two people's birthday.
 * Finally, the program prints out which person's birthday is sooner and a fun fact afterwards.
 */

import java.util.Scanner;

public class Birthdays {
	public static void main(String[] args) {
		// Create Scanner
		Scanner console = new Scanner(System.in);
		input(console);
	}
	
	// Get user input and call calculation methods
	public static void input(Scanner console) {
		// Today's date
		System.out.println("Please enter today's date (month day): ");
		int todayM = console.nextInt();
		int todayD = console.nextInt();
		int today = dayOfYear(todayM, todayD);
		System.out.println("Today is " + todayM + "/" + todayD + "/2022, day #" + today + " of the year.");
		System.out.println();
		
		// Person 1's birthday
		System.out.println("Please enter person #1's birthday (month day): ");
		int oneM = console.nextInt();
		int oneD = console.nextInt();
		int one = dayOfYear(oneM, oneD);
		int oneNext = nextBirthday(today, one);
		printMessage(oneM, oneD, one, oneNext);
		System.out.println();
		
		// Person 2's birthday
		System.out.println("Please enter person #2's birthday (month day): ");
		int twoM = console.nextInt();
		int twoD = console.nextInt();
		int two = dayOfYear(twoM, twoD);
		int twoNext = nextBirthday(today, two);
		printMessage(twoM, twoD, two, twoNext);
		System.out.println();
		
		// Call method to find which person's birthday is sooner
		sooner(oneNext, twoNext);
		System.out.println();
		
		// Call method to see if today is my birthday or print fun fact
		todayBirthday(todayM, todayD);
	}
	
	// Calculate which day of the year the given date is
	public static int dayOfYear(int month, int day) {
		int totalDay = 0;
		// Cumulative for loop to increment days per month
		for (int i = 1; i < month; i++) {
			if (i == 2) {
				totalDay += 28;
			}
			else if (i == 4 || i == 6 || i == 9 || i == 11) {
				totalDay += 30;
			}
			else {
				totalDay += 31;
			}
		}
		// Add days past in current month
		totalDay += day;
		return totalDay;
	}
	
	// Calculate when person's next birthday is
	public static int nextBirthday(int today, int bday) {
		int nextBday = 0;
		if (today <= bday) {
			nextBday = bday - today;
		}
		else {
			nextBday = 365-(today-bday);
		}
		return nextBday;
	}
	
	// Print a message corresponding to in how many days the person's next birthday is in
	public static void printMessage(int month, int day, int dayYear, int nextBday) {
		System.out.print(month + "/" + day + "/2022 falls on day #" + dayYear + " of 365. ");
		if (nextBday == 0) {
			System.out.println("Happy Birthday! :)");
		}
		else {
			System.out.println("Your birthday is in " + nextBday + " day(s).");
		}
	}
	
	// Calculate if today is my birthday 12/12 and print message accordingly
	public static void todayBirthday(int todayM, int todayD) {
		if (todayM != 12 || todayD != 12) {
			System.out.println("Did you know? 12/12 is Gingerbread House Day! :P");
		}
		else {
			System.out.println("Did you know? Today is my birthday!");
		}
	}
	
	// Calculate which person's birthday is sooner
	public static void sooner(int one, int two) {
		if (one > two) {
			System.out.println("Person #2's birthday is sooner.");
		}
		else if (two > one) {
			System.out.println("Person #1's birthday is sooner.");
		}
		else {
			System.out.println("Person #1 and Person #2 have the same birthday.");
		}
	}
}
