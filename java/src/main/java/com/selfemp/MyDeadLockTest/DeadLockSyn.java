package com.selfemp.MyDeadLockTest;

public class DeadLockSyn {
	private String lockIdA;
	private String lockIdB;

	public DeadLockSyn(String lockIdA,String lockIdB) {
		this.lockIdA = lockIdA;
		this.lockIdB = lockIdB;
	}
	public void actionOne() {
		while(1>0) {
			synchronized(lockIdA) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized(lockIdB) {
					break;
				}
			}			
		}
	}
	public void actionTwo() {
		while(1>0) {
			synchronized(lockIdB) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized(lockIdA) {
					break;
				}
			}			
		}
	}
}
