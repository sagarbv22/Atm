package com.atm.in;

import java.util.Scanner;

public class Validation {

	public static void input() throws InterruptedException {
		Scanner scan = new Scanner(System.in);

		System.out.println();
		System.out.println("Please select the below options for service");
		System.out.println("===========================================");
		System.out.println("      For Card registration - press 1");
		System.out.println("      To Credit the money   - press 2");
		System.out.println("      To Debit the money    - press 3");
		System.out.println("      To Check your balance - press 4");
		System.out.println("      To Exit               - press 0");

		int num = scan.nextInt();

		switch (num) {

		case 1:
			Bank.validateOtp();
			break;
		case 2:
			Bank.addMoney();
			break;
		case 3:
			Bank.takeMoney();
			break;
		case 4:
			Bank.balance();
			break;
		case 0:
			System.out.println("Thank you:)");
			System.exit(0);
			break;
		default:
			System.out.println("Enter the below options");
			input();
		}
	}

}
