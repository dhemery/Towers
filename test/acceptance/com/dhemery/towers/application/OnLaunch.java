package com.dhemery.towers.application;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dhemery.towers.model.Tower;

import static com.dhemery.towers.application.fixtures.TowersDriver.*;

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
	public void towersAlternateColorsStartingWithBlack() {
		Tower.Color leftmostTowerColor = Tower.Color.BLACK;
		for(int row = 0 ; row < 8 ; row++) {
			Tower.Color towerColor = leftmostTowerColor;
			for(int column = 0 ; column < 8 ; column++) {
				tower(row,column).hasColor(towerColor);
				towerColor = oppositeOf(towerColor);
			}
			leftmostTowerColor = oppositeOf(leftmostTowerColor);
		}
	}

	private Tower.Color oppositeOf(Tower.Color towerColor) {
		return towerColor == Tower.Color.BLACK ? Tower.Color.WHITE : Tower.Color.BLACK;
	}
}
