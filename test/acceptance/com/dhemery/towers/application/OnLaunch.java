package com.dhemery.towers.application;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.dhemery.towers.application.fixtures.TowersFixture.*;

public class OnLaunch {
	@BeforeClass
	public static void setUp() {
		launch();
	}

	@AfterClass
	public static void tearDown() {
		stop();
	}

	@Test
	public void theCityIsEightBlocksSquare() {
		theCity().hasWidth(8);
		theCity().hasLength(8);
	}
	
	@Test
	public void eachCityBlockasAOneFloorTower() {
		for(int row = 0 ; row < 8 ; row++) {
			for(int column = 0 ; column < 8 ; column++) {
				tower(row,column).hasfloorCount(1);
			}
		}
	}
	
	@Test
	public void towersAlternateColors() {
		towersAlternateColorsDownFirstColumn();
		towersAlternateColorsAlongEachRow();
	}

	private void towersAlternateColorsAlongEachRow() {
		for(int row = 0 ; row < 8 ; row++) {
			for(int column = 1 ; column < 8 ; column++) {
				tower(row,column).hasDifferentColorThan(tower(row,column-1));
			}
		}
	}

	private void towersAlternateColorsDownFirstColumn() {
		for(int row = 1 ; row < 8 ; row++) {
			tower(row,0).hasDifferentColorThan(tower(row-1,0));
		}
	}
}
