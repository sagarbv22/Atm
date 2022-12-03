package com.atm.in;

import java.util.Scanner;

import com.CustomExceptions.in.InvalidOtpException;
import com.CustomExceptions.in.InvalidPinException;

public class Atm {

	static Scanner scan = new Scanner(System.in);

	static Base base = new Base();

	public static void register() throws InvalidOtpException, InterruptedException {

		System.out.println("Enter your Phone Number");
		double i = scan.nextDouble();
		base.setPhoneNum(i);
		System.out.println("Enter your Account Number");
		double d = scan.nextDouble();
		base.setAccountNum(d);
		System.out.println("Enter the otp displayed");
		int otp = (int) (Math.random() * (4000 - 2000 + 1) + 2000);
		System.out.println(otp);
		int otdup = scan.nextInt();

		if (otdup == otp) {
			System.out.println("Set the confidential pin");
			int pinCode = scan.nextInt();
			base.setPinCode(pinCode);
			Thread.sleep(2000);
			Validation.input();

		} else {
			InvalidOtpException in = new InvalidOtpException("Invalid otp");
			System.out.println(in.getMessage());
			throw in;
		}

	}

	public static boolean pinValidation() throws InvalidPinException, InterruptedException {

		Base base = new Base();
		boolean flag = false;
		if (base.getPinCode() == 0) {
			System.out.println();
			System.out.println("***Register your Card first***");
			Thread.sleep(2000);
			Validation.input();
		}
		System.out.println("Enter the Pin");

		int pin = scan.nextInt();
		if (pin == base.getPinCode()) {
			flag = true;
		} else {
			InvalidPinException ip = new InvalidPinException("Wrong pin");
			System.out.println(ip.getMessage());
			throw ip;
		}
		return flag;

	}

	public static void credit() throws InvalidPinException, InterruptedException {

		Base base = new Base();

		if (pinValidation()) {
			System.out.println("Enter the amount");
			float amount = scan.nextInt();
			if (amount > 0) {
				base.creditBalance(amount);
				System.out.println("Amount is credited sucessfully.");
				System.out.println("Your accBal: " + base.getBalance());
				Thread.sleep(2000);
				Validation.input();
			} else {
				System.out.println("You have entered an invalid amount");
				System.out.println("try again!");
				Thread.sleep(2000);
				Validation.input();
			}
		}

	}

	public static void debit() throws InvalidPinException, InterruptedException {

		if (pinValidation()) {
			System.out.println("Enter the amount");
			float amount = scan.nextFloat();
			if (amount > base.getBalance()) {
				System.out.println("Your balance is:" + base.getBalance());
				System.out.println("try again");
				Thread.sleep(2000);
				Validation.input();
			} else if (amount < 0) {
				System.out.println("You have entered an invalid amount");
				System.out.println("try again!");
				Thread.sleep(2000);
				Validation.input();
			} else if(amount<=base.getBalance()&& amount>0){
				base.debitBalance(amount);
				System.out.println("Collect your cash.");
				System.out.println("Your accBal: " + base.getBalance());
				Thread.sleep(2000);
				Validation.input();
			}
		}
	}

	public static void checkBal() throws InvalidPinException, InterruptedException {
		if (pinValidation()) {

			System.out.println("Your Balance:" + base.getBalance());
			Thread.sleep(2000);
			Validation.input();

		}
	}

}
