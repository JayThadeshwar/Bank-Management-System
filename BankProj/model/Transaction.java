package model;

import java.sql.Date;

public class Transaction {
	Date tranDate;
	double debit;
	double credit;
	double balance;

	public Transaction() {}
	
	public Transaction(Date tranDate, double debit, double credit, double balance) {
		super();
		this.tranDate = tranDate;
		this.debit = debit;
		this.credit = credit;
		this.balance = balance;
	}

	public Date getTranDate() {
		return tranDate;
	}

	public void setTranDate(Date tranDate) {
		this.tranDate = tranDate;
	}

	public double getDebit() {
		return debit;
	}

	public void setDebit(double debit) {
		this.debit = debit;
	}

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}
