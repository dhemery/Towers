package com.dhemery.towers.model;

import java.util.ArrayList;
import java.util.List;

public class RowColumnOrderGrid implements Grid {
	private final int rows;
	private final int columns;
	private final List<Address> addresses;

	public RowColumnOrderGrid(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		addresses = makeAddresses();		
	}

	@Override
	public int rows() {
		return rows;
	}

	@Override
	public int columns() {
		return columns;
	}

	@Override
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
