package com.dhemery.towers.application.fixtures;

import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.fixture.JButtonFixture;

import com.dhemery.towers.model.Address;

public class TowerFixture {
	private JButtonFixture fixture;

	public TowerFixture(FrameFixture frameFixture, int row, int column) {
		Address address = new Address(row,column);
		fixture = frameFixture.button(address.name());
	}

	public TowerAssertion has(int expected) {
		return new TowerAssertion(this, expected);
	}

	public int floors() {
		return Integer.parseInt(fixture.text());
	}
}
