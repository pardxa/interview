package com.selfemp.CyclicBarrierExample;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Calculator {
	private CyclicBarrier barrier;
	private List<Integer> meanInput;
	private double meanAvg = 0.0;
	public double getMeanAvg() {
		return meanAvg;
	}

	public double getQuaAvg() {
		return quaAvg;
	}

	private List<Integer> quaInput;
	private double quaAvg = 0.0;

	public Calculator(CyclicBarrier barrier, List<Integer> meanInput, List<Integer> quaInput) {
		this.barrier = barrier;
		this.meanInput = meanInput;
		this.quaInput = quaInput;
	}

	public void getMean() {
		Iterator<Integer> itr = meanInput.iterator();
		int sum = 0;
		int i = 0;
		while (itr.hasNext()) {
			sum += itr.next();
			i++;
		}
		meanAvg = (meanAvg + sum) / i;
		try {
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}

	public void getQuaMean() {
		Iterator<Integer> itr = quaInput.iterator();
		int sum = 0;
		int i = 0;
		while (itr.hasNext()) {
			int val = itr.next();
			sum += (val * val);
			i++;
		}
		meanAvg = Math.sqrt((meanAvg + sum) / i);
		try {
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}

}
