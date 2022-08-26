package com.javachamp.multithreading.deadlock;

import java.util.concurrent.locks.Lock;

public class Runnable1 implements Runnable{
	
	private Lock lock1 = null;
	private Lock lock2 = null;

	public Runnable1(Lock lock1, Lock lock2) {
		super();
		this.lock1 = lock1;
		this.lock2 = lock2;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " Attempting to lock lock1");
		lock1.lock();
		System.out.println(Thread.currentThread().getName() + " locked lock1");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName() + " Attempting to lock lock2");
		lock2.lock();
		System.out.println(Thread.currentThread().getName() + " locked lock2");
		
		lock1.unlock();
		lock2.unlock();
	}

}
