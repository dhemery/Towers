package com.dhemery.towers.application;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import com.dhemery.towers.model.Address;
import com.dhemery.towers.model.Grid;
import com.dhemery.towers.model.Tourist;

public class ButtonFactory {
	private final class ButtonGatherer implements Tourist {
		private final List<JButton> buttons;
		private ButtonGatherer(List<JButton> buttons) {
			this.buttons = buttons;
		}
		@Override
		public void visit(Address address) {
			makeButton(buttons, address);
		}
	}

	public List<JButton> buttonsFor(Grid grid) {
		List<JButton> buttons = new ArrayList<JButton>();
		grid.atEachAddress(new ButtonGatherer(buttons));
		return buttons;
	}

	private void makeButton(List<JButton> buttons, Address address) {
		buttons.add(makeTowerButton(address));
	}

	private JButton makeTowerButton(Address address) {
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

	private boolean isEven(int i) {
		return i %2 == 0;
	}
}
