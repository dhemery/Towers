package com.dhemery.towers.gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import com.dhemery.towers.model.Address;
import com.dhemery.towers.model.Grid;

public class ButtonFactory {
	private final List<JButton> buttons;

	public ButtonFactory(Grid grid) {
		buttons = makeButtons(grid);		
	}

	public List<JButton> buttons() {
		return buttons;
	}

	private boolean isEven(int i) {
		return (i % 2) == 0;
	}

	private JButton makeButton(Address address) {
		JButton button = new JButton();
		button.setName(address.name());
		button.setSize(60,60);
		button.setHorizontalAlignment(JButton.CENTER);
		button.setOpaque(true);
		if(isEven(address.row()+address.column())) {
			button.setForeground(Color.white);
			button.setBackground(Color.black);
		} else {
			button.setForeground(Color.black);
			button.setBackground(Color.white);					
		}
		button.setText("1");
		button.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
		return button;
	}

	private List<JButton> makeButtons(Grid grid) {
		List<JButton> buttons = new ArrayList<JButton>();
		for(Address address : grid.addresses()) {
			buttons.add(makeButton(address));
		}
		return buttons;
	}
}
