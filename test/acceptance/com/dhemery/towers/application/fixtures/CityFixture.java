package com.dhemery.towers.application.fixtures;

import java.awt.GridLayout;

import static org.fest.assertions.Assertions.*;

import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.fixture.JPanelFixture;

import com.dhemery.towers.application.Towers;
public class CityFixture {
	private JPanelFixture fixture;

	public CityFixture(FrameFixture frameFixture) {
		this.fixture = frameFixture.panel(Towers.CITY_PANEL_NAME);
	}
	
	public void hasLength(int expectedLength) {
		assertThat(length()).isEqualTo(expectedLength);
	}

	public void hasWidth(int expectedWidth) {
		assertThat(width()).isEqualTo(expectedWidth);
	}

	private GridLayout layout() {
		return (GridLayout) fixture.target.getLayout();
	}

	private int length() {
		return layout().getColumns();
	}

	private int width() {
		return layout().getRows();
	}

}
