package com.dhemery.towers.model;

import static org.fest.assertions.Assertions.*;

import org.junit.Test;

public class ATower {
	@Test
	public void startsOneFloorHigh() {
		assertThat(new Tower().height()).isEqualTo(1);
	}
}
