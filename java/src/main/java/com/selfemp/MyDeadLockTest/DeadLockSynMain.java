package com.selfemp.MyDeadLockTest;

public class DeadLockSynMain {

	public static void main(String[] args) {
    	DeadLockSyn dl=new DeadLockSyn("lockA","lockB");
    	new Thread(dl::actionOne).start();
    	new Thread(dl::actionTwo).start();
	}

}
