package com.selfemp.designpattern.Dualton;

import java.util.ArrayList;
import java.util.List;

public class DualtonMain {

	public static void main(String[] args) {
		ShiftFactory.getInstance().setField(111);
		ShiftFactory.getInstance().setField(222);
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < 5; i++) {
			result.add(ShiftFactory.getInstance().getField());
		}
		result.forEach(System.out::println);

	}
}
