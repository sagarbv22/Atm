package com.atm.in;

public class Base {
	
	private static float balance=1000;
	
	private static double accountNum;
	private static int pinCode;
	private static double phoneNum;
	
	
	
	public double getAccountNum() {
		return accountNum;
	}
	public double getPhoneNum() {
		return phoneNum;
	}
	public float getBalance() {
		return balance;
	}
	public void setAccountNum(double accountNum) {
		this.accountNum = accountNum;
	}
	public void setPhoneNum(double phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	
	public void creditBalance(float balance) {
		this.balance+= balance;
	}
	public void debitBalance(float balance) {
		this.balance-= balance;
	}
	
	
}
