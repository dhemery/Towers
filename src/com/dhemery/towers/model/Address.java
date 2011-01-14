package com.dhemery.towers.model;

public class Address {
	private final int row;
	private final int column;

	public Address(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public String name() {
		return String.format("%s,%s", row, column);
	}
}
