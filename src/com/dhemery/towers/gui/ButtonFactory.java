package com.dhemery.towers.gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import com.dhemery.towers.model.Tower;

public class ButtonFactory {
	private final List<JButton> buttons;

	public ButtonFactory(List<Tower> towers, TowerRenderer renderer) {
		buttons = makeButtons(towers, renderer);
	}

	public List<JButton> buttons() {
		return buttons;
	}

	private JButton button(Tower tower, TowerRenderer renderer) {
		JButton button = new JButton();
		initialize(button, tower.name());
		setBorder(button);
		renderer.render(button, tower);
		setText(button);
		return button;
	}

	private void setText(JButton button) {
		button.setText("1");
	}

	private void initialize(JButton button, String name) {
		button.setName(name);
		button.setSize(60,60);
		button.setHorizontalAlignment(JButton.CENTER);
		button.setOpaque(true);
	}

	private void setBorder(JButton button) {
		button.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
	}

	private List<JButton> makeButtons(List<Tower> towers, TowerRenderer renderer) {
		List<JButton> buttons = new ArrayList<JButton>();
		for(Tower tower : towers) {
			buttons.add(button(tower, renderer));
		}
		return buttons;
	}
}
