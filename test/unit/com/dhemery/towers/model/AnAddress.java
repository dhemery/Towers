package com.dhemery.towers.model;

import static org.fest.assertions.Assertions.*;

import org.junit.Test;

public class AnAddress {

	@Test
	public void isNamedByRowAndColumn() {
		assertThat(new Address(5,991).name()).isEqualTo("5,991");
	}
}
