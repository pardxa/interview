package com.selfemp.CountdownlatchExample;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class CalculateApp {
	private static ArrayList<Integer> numberProducer() {
		ArrayList<Integer> num = new ArrayList<Integer>();
		Random rm = new Random();
		for (int i = 0; i < 400; i++) {
			num.add(rm.nextInt(200));
		}
		return num;
	}

	private static CountDownLatch countdownlatch;
	private static Calculator cal1;
	private static Calculator cal2;
	private static double avg = 0.0;

	public static void main(String[] args) {
		ArrayList<Integer> num = numberProducer();
		countdownlatch = new CountDownLatch(4);
		cal1 = new Calculator(countdownlatch, num.subList(0, 100), num.subList(100, 200));
		cal2 = new Calculator(countdownlatch, num.subList(200, 300), num.subList(300, 400));
		//
		new Thread(CalculateApp::sum).start();
		new Thread(cal1::getMean).start();
		new Thread(cal1::getQuaMean).start();
		new Thread(cal2::getMean).start();
		new Thread(cal2::getQuaMean).start();
	}

	private static void sum() {
		try {
			countdownlatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		avg = (cal1.getMeanAvg() + cal1.getQuaAvg() + cal2.getMeanAvg() + cal2.getQuaAvg()) / 4.0;
		System.out.println(avg);
	}

}
