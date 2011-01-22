package com.dhemery.towers.model;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ATowerFactory {
	@Test
	public void makesBlackTowerIfAddressRowAndColumnSumToAnEvenNumber() {
		List<Address> blackAddresses = Arrays.asList(
				new Address(0,0),
				new Address(0,2),
				new Address(2,0),
				new Address(1,1),
				new Address(9999,3333)
			);
		TowerFactory factory = new TowerFactory(blackAddresses);
		List<Tower> towers = factory.towers();

		for(Tower tower : towers) {
			assertThat(tower.color(), is(Tower.Color.BLACK));
		}
	}
	
	@Test
	public void makesWhiteTowerIfAddressRowAndColumnSumToAnOddNumber() {
		List<Address> whiteAddresses = Arrays.asList(
				new Address(0,1),
				new Address(0,3),
				new Address(1,0),
				new Address(3,4),
				new Address(9998,3333)
			);
		TowerFactory factory = new TowerFactory(whiteAddresses);
		List<Tower> towers = factory.towers();

		for(Tower tower : towers) {
			assertThat(tower.color(), is(Tower.Color.WHITE));
		}
	}
}
