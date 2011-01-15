package com.dhemery.towers.application.fixtures;

import org.fest.swing.fixture.FrameFixture;

import com.dhemery.towers.application.Towers;

public class TowersFixture {
	private static FrameFixture frameFixture;

	public static void launch() {
		Towers.main();
		frameFixture = new FrameFixture(Towers.APPLICATION_FRAME_NAME);
	}

	public static void stop() {
		frameFixture.cleanUp();
		frameFixture.close();
	}

	public static CityFixture theCity() {
		return new CityFixture(frameFixture);
	}
	
	public static TowerFixture tower(int row, int column) {
		return new TowerFixture(frameFixture, row, column);
	}
}
