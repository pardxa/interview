package com.selfemp.OrderExe;

public class MainThreadApp {

	public static void main(String[] args) {
		Foo foo = new Foo();
		Thread t1 = new Thread(foo::first);
		Thread t2 = new Thread(foo::second);
		Thread t3 = new Thread(foo::third);
		t1.start();
		try {
			t1.join();
			t2.start();
			t2.join();
			t3.start();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
