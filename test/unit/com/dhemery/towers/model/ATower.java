package com.dhemery.towers.model;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


import org.junit.Test;

public class ATower {
	@Test
	public void startsOneFloorHigh() {
		assertThat(Tower.createBlack("").height(), is(1));
	}
	
	@Test
	public void remembersItsName() {
		assertThat(Tower.createBlack("abc").name(), is("abc"));
	}

	@Test
	public void remembersItsColor() {
		assertThat(Tower.createBlack("").color(), is(Tower.Color.BLACK));
		assertThat(Tower.createWhite("").color(), is(Tower.Color.WHITE));
		assertThat(Tower.createGray("").color(), is(Tower.Color.GRAY));
	}
}
