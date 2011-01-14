package com.dhemery.towers.application.fixtures;

import org.fest.swing.fixture.FrameFixture;

import com.dhemery.towers.application.Towers;

public class TowersFixture {
	public static CityFixture city() {
		return new CityFixture(new FrameFixture(Towers.APPLICATION_FRAME_NAME));
	}

}
