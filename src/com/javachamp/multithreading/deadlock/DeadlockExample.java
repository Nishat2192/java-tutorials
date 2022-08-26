package com.javachamp.multithreading.deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockExample {

	public static void main(String[] args) {
		
		Lock lock1 = new ReentrantLock();
		Lock lock2 = new ReentrantLock();
		
		Runnable1 r1 = new Runnable1(lock1, lock2);
		Runnable2 r2 = new Runnable2(lock1, lock2);
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		t1.start();
		t2.start();
	}

}
