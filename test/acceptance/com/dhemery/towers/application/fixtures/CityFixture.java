package com.dhemery.towers.application.fixtures;

import java.awt.GridLayout;

import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.fixture.JPanelFixture;

public class CityFixture {
	private JPanelFixture fixture;

	public CityFixture(FrameFixture frameFixture) {
		this.fixture = frameFixture.panel();
	}
	
	public CityAssertion has(int expectedNumber) {
		return new CityAssertion(this, expectedNumber);
	}

	public int rows() {
		return layout().getRows();
	}

	private GridLayout layout() {
		return (GridLayout) fixture.target.getLayout();
	}

}
