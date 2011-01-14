package com.dhemery.towers.application.fixtures;

import static org.fest.assertions.Assertions.*;

public class CityAssertion {
	private final CityFixture city;
	private final int expectedNumber;

	public CityAssertion(CityFixture city, int expectedNumber) {
		this.city = city;
		this.expectedNumber = expectedNumber;
	}

	public void blocksWide() {
		assertThat(city.width()).isEqualTo(expectedNumber);
	}

	public void blocksLong() {
		assertThat(city.length()).isEqualTo(expectedNumber);
	}
}
