package com.dhemery.towers.application.fixtures;

import static org.fest.assertions.Assertions.*;

public class TowerAssertion {

	private final TowerFixture tower;
	private final int expected;

	public TowerAssertion(TowerFixture tower, int expected) {
		this.tower = tower;
		this.expected = expected;
	}

	public void floor() {
		assertThat(tower.floors()).isEqualTo(expected);
	}

}
