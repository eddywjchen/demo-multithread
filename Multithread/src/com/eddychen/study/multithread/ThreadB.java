package com.eddychen.study.multithread;

public class ThreadB implements Runnable {
	private int i;
	public void run(){
		for(;i<100;i++){
			System.out.println(Thread.currentThread().getName()+": "+i);
		}
	}
	public static void main(String[] args) {
		for(int i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName() +": "+i);
			if(i==20){
				ThreadB threadB = new ThreadB();
				new Thread(threadB, "threadB-1").start();
				new Thread(threadB, "threadB-2").start();
			}
		}
	}
}
