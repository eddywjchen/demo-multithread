package com.eddychen.study.multithread;

public class ThreadA extends Thread{
	private int i;
	public void run(){
		for(;i<100;i++){
			System.out.println(getName()+": "+i);
		}
	}
	public static void main(String[] args) {
		for(int i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName() + ": "+i);
			if(i==10){
				new ThreadA().start();
				new ThreadA().start();
			}
		}
	}
}
