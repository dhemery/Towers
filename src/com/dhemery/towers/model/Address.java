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

	public int row() {
		return row;
	}

	public int column() {
		return column;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + column;
		result = prime * result + row;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (column != other.column)
			return false;
		if (row != other.row)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return name();
	}
}
