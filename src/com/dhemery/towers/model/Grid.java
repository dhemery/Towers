package com.dhemery.towers.model;

import java.util.ArrayList;
import java.util.List;

public class Grid {
	private final int rows;
	private final int columns;
	private final List<Address> addresses;

	public Grid(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		addresses = makeAddresses();		
	}

	public int rows() {
		return rows;
	}

	public int columns() {
		return columns;
	}

	public List<Address> addresses() {
		return addresses;
	}

	private List<Address> makeAddresses() {
		List<Address> addresses = new ArrayList<Address>();
		for(int row = 0 ; row < rows ; row++) {
			for(int column = 0 ; column < columns ; column++) {
				addresses.add(new Address(row, column));
			}
		}
		return addresses;
	}
}
