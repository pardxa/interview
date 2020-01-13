package com.selfemp.CountdownlatchExample;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Calculator {
	private CountDownLatch countdownlatch;
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

	public Calculator(CountDownLatch countdownlatch, List<Integer> meanInput, List<Integer> quaInput) {
		this.countdownlatch = countdownlatch;
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
		countdownlatch.countDown();
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
		countdownlatch.countDown();
	}
}
