package com.atm.in;

import com.CustomExceptions.in.InvalidOtpException;
import com.CustomExceptions.in.InvalidPinException;

public class Bank {

	public static void validateOtp() throws InterruptedException {

		try {
			Atm.register();
		} catch (InvalidOtpException i3) {
			try {
				Atm.register();
			} catch (InvalidOtpException i2) {
				System.out.println("*Last attempt*");
				try {
					Atm.register();
				} catch (InvalidOtpException i1) {
					System.out.println("Try after 10mins");
					System.exit(0);
				}
			}
		}

	}

	public static void addMoney() throws InterruptedException {
		try {
			Atm.credit();
		} catch (InvalidPinException e1) {
			try {
				Atm.credit();
			} catch (InvalidPinException e2) {
				try {

					Atm.credit();
				} catch (InvalidPinException e3) {
					System.out.println("Your Card is Blocked");
				}
			}
		}
	}

	public static void takeMoney() throws InterruptedException {
		try {
			Atm.debit();
		} catch (InvalidPinException p1) {
			try {
				Atm.debit();
			} catch (InvalidPinException p2) {
				try {
					Atm.debit();
				} catch (InvalidPinException p3) {
					System.out.println("Your card is Blocked");
				}
			}
		}
	}

	public static void balance() throws InterruptedException{
		try {
			Atm.checkBal();
		} catch (InvalidPinException t1) {
			try {
				Atm.checkBal();
			} catch (InvalidPinException t2) {
				try {
					Atm.checkBal();
				} catch (InvalidPinException t3) {
					System.out.println("Your card is Blocked");
				}
			}
		}
	}
}
