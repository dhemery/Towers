package com.dhemery.towers.application.fixtures;

import org.fest.swing.fixture.FrameFixture;

import com.dhemery.towers.application.Towers;

public class TowersFixture {
	private static FrameFixture frameFixture;

	public static CityFixture city() {
		return new CityFixture(frameFixture);
	}

	public static void launch() {
		Towers.main();
		frameFixture = new FrameFixture(Towers.APPLICATION_FRAME_NAME);
	}
	
	public static void stop() {
		frameFixture.cleanUp();
	}
}
