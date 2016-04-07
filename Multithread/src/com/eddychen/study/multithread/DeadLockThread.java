package com.eddychen.study.multithread;

public class DeadLockThread implements Runnable {
	private Object o1 = new Object();
	private Object o2 = new Object();
	private boolean flag = true;
	public void run() {
		if (flag) {
			flag = false;
			synchronized (o1) {
				System.out.println(Thread.currentThread().getName() + " have o1's lock");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + " prepare to get o2's lock...");
				synchronized (o2) {
					System.out.println(Thread.currentThread().getName() + " have o2's lock");
				}
			}
		} else {
			flag = true;
			synchronized (o2) {
				System.out.println(Thread.currentThread().getName() + " have o2's lock");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + " prepare to get o1's lock...");
				synchronized (o1) {
					System.out.println(Thread.currentThread().getName() + " have o1's lock");
				}
			}
		}
	}

	public static void main(String[] args) {
		DeadLockThread deadLockThread = new DeadLockThread();
		new Thread(deadLockThread, "线程1").start();
		new Thread(deadLockThread, "线程2").start();
	}

}
