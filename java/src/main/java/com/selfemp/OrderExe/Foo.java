package com.selfemp.OrderExe;

public class Foo {
	public void first() {
		System.out.println("in Thread 1");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void second() {
		System.out.println("in Thread 2");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void third() {
		System.out.println("in Thread 3");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
