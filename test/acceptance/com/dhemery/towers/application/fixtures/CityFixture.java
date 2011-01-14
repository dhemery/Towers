package com.dhemery.towers.application.fixtures;

import java.awt.GridLayout;

import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.fixture.JPanelFixture;
public class CityFixture {
	private JPanelFixture fixture;

	public CityFixture(FrameFixture frameFixture) {
		this.fixture = frameFixture.panel();
	}
	
	private GridLayout layout() {
		return (GridLayout) fixture.target.getLayout();
	}

	public int length() {
		return layout().getRows();
	}

	public int width() {
		return layout().getColumns();
	}

	public CityAssertion is(int expected) {
		return new CityAssertion(this, expected);
	}

}
