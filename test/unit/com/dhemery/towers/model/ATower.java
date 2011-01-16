package com.dhemery.towers.model;

import static org.fest.assertions.Assertions.*;

import org.junit.Test;

public class ATower {
	@Test
	public void startsOneFloorHigh() {
		assertThat(new Tower(Tower.Color.BLACK).height()).isEqualTo(1);
	}
	
	@Test
	public void remembersItsColor() {
		assertThat(new Tower(Tower.Color.BLACK).color()).isEqualTo(Tower.Color.BLACK);
		assertThat(new Tower(Tower.Color.WHITE).color()).isEqualTo(Tower.Color.WHITE);
		assertThat(new Tower(Tower.Color.GRAY).color()).isEqualTo(Tower.Color.GRAY);
	}
	
	@Test
	public void canBeCreatedByHelperMethods() {
		assertThat(Tower.createBlack()).isEqualTo(new Tower(Tower.Color.BLACK));
		assertThat(Tower.createWhite()).isEqualTo(new Tower(Tower.Color.WHITE));
		assertThat(Tower.createGray()).isEqualTo(new Tower(Tower.Color.GRAY));
	}
}
