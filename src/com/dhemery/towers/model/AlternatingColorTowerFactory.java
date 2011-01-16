package com.dhemery.towers.model;

import com.dhemery.towers.model.TowerFactory;

public class AlternatingColorTowerFactory implements TowerFactory {

	@Override
	public Tower tower(Address address) {
		return isBlack(address) ? Tower.createBlack() : Tower.createWhite();
	}

	private boolean isBlack(Address address) {
		return (address.row() + address.column()) % 2 == 0 ;
	}
}
