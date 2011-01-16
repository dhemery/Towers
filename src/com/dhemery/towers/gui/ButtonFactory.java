package com.dhemery.towers.gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import com.dhemery.towers.model.Address;

public class ButtonFactory {
	private final List<JButton> buttons = new ArrayList<JButton>();

	public ButtonFactory(List<Address> addresses) {
		for(Address address : addresses) {
			buttons.add(button(address.name()));
		}
	}

	public List<JButton> buttons() {
		return buttons;
	}

	private JButton button(String name) {
		JButton button = new JButton();
		button.setName(name);
		button.setSize(60,60);
		button.setHorizontalAlignment(JButton.CENTER);
		button.setOpaque(true);
		return button;
	}
}
