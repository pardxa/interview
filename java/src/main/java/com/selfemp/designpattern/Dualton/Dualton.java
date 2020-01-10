package com.selfemp.designpattern.Dualton;

public enum Dualton {
	_instanceFirst, _instanceSecond;

	private int field;

	public int getField() {
		return field;
	}

	public void setField(int field) {
		this.field = field;
	}
}
