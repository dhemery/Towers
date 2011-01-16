package com.dhemery.towers.model;

import static org.fest.assertions.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ARowColumnOrderGrid {
	@Test
	public void remembersHowManyRowsItHas() {
		assertThat(new RowColumnOrderGrid(905, 0).rows()).isEqualTo(905);
	}

	@Test
	public void remembersHowManyColumnsItHas() {
		assertThat(new RowColumnOrderGrid(0, 39).columns()).isEqualTo(39);
	}

	@Test
	public void listsAddressesInRowAndColumnOrder() {
		List<Address> expectedAddresses= Arrays.asList(
				new Address(0,0),
				new Address(0,1),
				new Address(1,0),
				new Address(1,1),
				new Address(2,0),
				new Address(2,1));

		assertThat(new RowColumnOrderGrid(3,2).addresses()).containsExactly(expectedAddresses.toArray());
	}
}
