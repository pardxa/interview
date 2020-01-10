package com.selfemp.MyDeadLockTest;

import java.util.concurrent.locks.ReentrantLock;

public class DeadLockReen {
	private static ReentrantLock lockA = new ReentrantLock();
	private static ReentrantLock lockB = new ReentrantLock();

	private static void precessOne() {
		lockA.lock();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		lockB.lock();
		//do Somthing
		lockA.unlock();
		lockB.unlock();
	}

	private static void precessTwo() {
		lockB.lock();
		lockA.lock();
		//doSomeThing
		lockB.unlock();
		lockA.unlock();
	}

	public static void computeDeadlock() {
		new Thread(DeadLockReen::precessOne).start();
		new Thread(DeadLockReen::precessTwo).start();

	}
}
