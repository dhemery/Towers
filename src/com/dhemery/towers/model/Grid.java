package com.dhemery.towers.model;


public class Grid {
	private final int rows;
	private final int columns;

	public Grid(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		
	}

	public int rows() {
		return rows;
	}

	public int columns() {
		return columns;
	}

	public void atEachAddress(Tourist tourist) {
		for(int row = 0 ; row < rows ; row++) {
			for(int column = 0 ; column < columns ; column++) {
				tourist.visit(new Address(row, column));
			}
		}
	}
}
