package com.dhemery.towers.gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import com.dhemery.towers.model.Address;
import com.dhemery.towers.model.Tower;
import com.dhemery.towers.model.Grid;
import com.dhemery.towers.model.TowerFactory;

public class ButtonFactory {
	private final List<JButton> buttons;

	public ButtonFactory(Grid grid, TowerFactory towerFactory) {
		buttons = makeButtons(grid, towerFactory);		
	}

	public List<JButton> buttons() {
		return buttons;
	}

	private JButton button(Address address, Tower tower) {
		JButton button = new JButton();
		initialize(button, address);
		setBorder(button);
		TowerRenderer.forTower(tower).renderColor(button);
		setText(button);
		return button;
	}

	private void setText(JButton button) {
		button.setText("1");
	}

	private void initialize(JButton button, Address address) {
		button.setName(address.name());
		button.setSize(60,60);
		button.setHorizontalAlignment(JButton.CENTER);
		button.setOpaque(true);
	}

	private void setBorder(JButton button) {
		button.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
	}

	private List<JButton> makeButtons(Grid grid, TowerFactory towerFactory) {
		List<JButton> buttons = new ArrayList<JButton>();
		for(Address address : grid.addresses()) {
			buttons.add(button(address, towerFactory.tower(address)));
		}
		return buttons;
	}
}
