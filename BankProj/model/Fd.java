package model;

public class Fd {
	int fd;
	double amount;
	int duration;
	String accNoLink;
	
	public Fd() {}
	
	public Fd(int fd, double amount, int duration, String accNoLink) {
		super();
		this.fd = fd;
		this.amount = amount;
		this.duration = duration;
		this.accNoLink = accNoLink;
	}
	public int getFd() {
		return fd;
	}
	public void setFd(int fd) {
		this.fd = fd;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getAccNoLink() {
		return accNoLink;
	}
	public void setAccNoLink(String accNoLink) {
		this.accNoLink = accNoLink;
	}
	
	
}
