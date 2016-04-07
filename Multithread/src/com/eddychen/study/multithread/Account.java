package com.eddychen.study.multithread;

import java.util.concurrent.locks.ReentrantLock;

public class Account {
	private String name;
	private Double balance;
	private final ReentrantLock lock = new ReentrantLock();
	public void draw(Double amount){
		lock.lock();
		try{
			if(balance >= amount){
				System.out.println(Thread.currentThread().getName() +"取钱成功，所取金额: "+amount);
				balance-=amount;
				System.out.println("当前余额: "+balance);
			}else{
				System.out.println(Thread.currentThread().getName() +"取钱失败，所取金额: "+amount);
				System.out.println("当前余额: "+balance);
			}
		}finally{
			lock.unlock();
		}
	}
	
	public Account(String name, Double balance){
		this.name = name;
		this.balance = balance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getAmount() {
		return balance;
	}
	
	

}
