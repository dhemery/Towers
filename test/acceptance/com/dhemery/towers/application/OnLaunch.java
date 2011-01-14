package com.dhemery.towers.application;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.dhemery.towers.application.fixtures.TowersFixture.*;

public class OnLaunch {
	@BeforeClass
	public static void setUp() {
		launch();
	}

	@AfterClass
	public static void tearDown() {
		stop();
	}

	@Test
	public void theCityIsEightBlocksSquare() {
		theCity().is(8).blocksWide();
		theCity().is(8).blocksLong();
	}
}
