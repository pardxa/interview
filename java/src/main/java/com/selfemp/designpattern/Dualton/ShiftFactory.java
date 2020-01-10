package com.selfemp.designpattern.Dualton;

public class ShiftFactory {
	private static boolean first = true;

	public static Dualton getInstance() {
		if (first) {
			first = false;
			return Dualton._instanceFirst;
		}
		first = true;
		return Dualton._instanceSecond;
	}
}
