package com.dhemery.towers.application;

import org.junit.Test;

import static com.dhemery.towers.application.fixtures.TowersFixture.*;

public class OnLaunch {
	@Test
	public void theCityIsEightTowersWide() {
		city().has(8).rows();
	}

}
