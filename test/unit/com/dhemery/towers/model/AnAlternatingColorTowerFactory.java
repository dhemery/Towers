package com.dhemery.towers.model;

import static org.fest.assertions.Assertions.*;

import org.junit.Before;
import org.junit.Test;

public class AnAlternatingColorTowerFactory {
	private TowerFactory factory;

	@Before
	public void setUp() {
		factory = new AlternatingColorTowerFactory();		
	}

	@Test
	public void makesBlackTowerIfAddressRowAndColumnSumToAnEvenNumber() {
		assertThat(factory.tower(new Address(0,0)).color()).isEqualTo(Tower.Color.BLACK);
		assertThat(factory.tower(new Address(0,2)).color()).isEqualTo(Tower.Color.BLACK);
		assertThat(factory.tower(new Address(2,0)).color()).isEqualTo(Tower.Color.BLACK);
		assertThat(factory.tower(new Address(1,1)).color()).isEqualTo(Tower.Color.BLACK);
		assertThat(factory.tower(new Address(9999,3333)).color()).isEqualTo(Tower.Color.BLACK);
	}
	
	@Test
	public void makesWhiteTowerIfAddressRowAndColumnSumToAnOddNumber() {
		assertThat(factory.tower(new Address(0,1)).color()).isEqualTo(Tower.Color.WHITE);
		assertThat(factory.tower(new Address(0,3)).color()).isEqualTo(Tower.Color.WHITE);
		assertThat(factory.tower(new Address(1,0)).color()).isEqualTo(Tower.Color.WHITE);
		assertThat(factory.tower(new Address(3,4)).color()).isEqualTo(Tower.Color.WHITE);
		assertThat(factory.tower(new Address(9998,3333)).color()).isEqualTo(Tower.Color.WHITE);
	}
}
