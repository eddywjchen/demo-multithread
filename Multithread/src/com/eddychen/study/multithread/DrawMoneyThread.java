package com.eddychen.study.multithread;

public class DrawMoneyThread extends Thread {
	private Account account;
	private Double drawMoney;
	public DrawMoneyThread(String name, Account account, Double drawMoney){
		super(name);
		this.account = account;
		this.drawMoney = drawMoney;
	}
	public void run(){
		account.draw(drawMoney);
	}
	public static void main(String[] args) {
		Account account = new Account("账户", new Double(1000));
		new DrawMoneyThread("Eddy", account, new Double(500)).start();
		new DrawMoneyThread("Somebody", account, new Double(700)).start();
	}
}
