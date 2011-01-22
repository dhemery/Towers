package com.dhemery.towers.model;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


import org.junit.Test;

public class AnAddress {
	
	@Test
	public void rembersItsRow() {
		assertThat(new Address(221,0).row(), is(221));
	}

	@Test
	public void rembersItsColumn() {
		assertThat(new Address(0,409).column(), is(409));
	}
	
	@Test
	public void isNamedByRowAndColumn() {
		assertThat(new Address(5,991).name(), is("5,991"));
	}
	
	@Test
	public void returnsItsNameFromToString() {
		Address address = new Address(578, 231);
		assertThat(address.toString(), is(address.name()));
	}
}
