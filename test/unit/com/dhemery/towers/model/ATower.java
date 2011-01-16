package com.dhemery.towers.model;

import static org.fest.assertions.Assertions.*;

import org.junit.Test;

public class ATower {
	@Test
	public void startsOneFloorHigh() {
		assertThat(Tower.createBlack("").height()).isEqualTo(1);
	}
	
	@Test
	public void remembersItsName() {
		assertThat(Tower.createBlack("abc").name()).isEqualTo("abc");
	}

	@Test
	public void remembersItsColor() {
		assertThat(Tower.createBlack("").color()).isEqualTo(Tower.Color.BLACK);
		assertThat(Tower.createWhite("").color()).isEqualTo(Tower.Color.WHITE);
		assertThat(Tower.createGray("").color()).isEqualTo(Tower.Color.GRAY);
	}
}
