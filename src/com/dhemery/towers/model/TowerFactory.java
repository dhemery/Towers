package com.dhemery.towers.model;

import java.util.ArrayList;
import java.util.List;

import com.dhemery.towers.model.TowerFactory;

public class TowerFactory {
	private final List<Tower> towers;

	public TowerFactory(List<Address> addresses) {
		towers = new ArrayList<Tower>();
		for(Address address : addresses) {
			towers.add(tower(address));
		}
	}

	private Tower tower(Address address) {
		String name = address.name();
		return isBlack(address) ? Tower.createBlack(name) : Tower.createWhite(name);
	}

	private boolean isBlack(Address address) {
		return (address.row() + address.column()) % 2 == 0 ;
	}

	public List<Tower> towers() {
		return towers;
	}
}
