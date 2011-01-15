package com.dhemery.towers.gui;
import static org.fest.assertions.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import org.junit.Before;
import org.junit.Test;

import com.dhemery.towers.gui.ButtonFactory;
import com.dhemery.towers.model.Address;
import com.dhemery.towers.model.Grid;


public class AButtonFactory {
	@Before
	public void runHeadless() {
		System.setProperty("java.awt.headless", "true");
	}

	@Test
	public void makesAButtonForEachAddress() {
		Grid grid = new Grid(3,2);
		ButtonFactory factory = new ButtonFactory(grid);
		assertThat(namesOf(factory.buttons())).isEqualTo(addressNames(grid));
	}

	private List<String> addressNames(Grid grid) {
		List<String> names = new ArrayList<String>();
		for(Address address : grid.addresses()) {
			names.add(address.name());
		}
		return names;
	}

	private List<String> namesOf(List<JButton> buttons) {
		List<String> names = new ArrayList<String>();
		for(JButton button : buttons) {
			names.add(button.getName());
		}
		return names;
	}
}
