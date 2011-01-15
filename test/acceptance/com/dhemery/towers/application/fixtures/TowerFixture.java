package com.dhemery.towers.application.fixtures;

import static org.fest.assertions.Assertions.*;
import java.awt.Color;

import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.fixture.JButtonFixture;

import com.dhemery.towers.model.Address;

public class TowerFixture {
	private JButtonFixture fixture;

	public TowerFixture(FrameFixture frameFixture, int row, int column) {
		Address address = new Address(row,column);
		fixture = frameFixture.button(address.name());
	}

	private Color background() {
		return fixture.foreground().target();
	}

	private int floors() {
		return Integer.parseInt(fixture.text());
	}

	private Color foreground() {
		return fixture.foreground().target();
	}

	public void hasDifferentColorThan(TowerFixture other) {
		assertThat(this.foreground()).isNotEqualTo(other.foreground());
		assertThat(this.background()).isNotEqualTo(other.background());
	}

	public void hasfloorCount(int expectedFloorCount) {
		assertThat(floors()).isEqualTo(expectedFloorCount);
	}
}
