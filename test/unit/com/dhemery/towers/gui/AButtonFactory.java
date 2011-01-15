package com.dhemery.towers.gui;
import static org.fest.assertions.Assertions.*;

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
		List<Address> addresses = grid.addressesInRowColumnOrder();

		List<JButton> buttons = new ButtonFactory(grid).buttons();
		
		assertThat(buttons.size()).isEqualTo(addresses.size());
		for(int i = 0 ; i < addresses.size() ; i++) {
			assertThat(buttons.get(i).getName()).isEqualTo(addresses.get(i).name());
		}
	}
}
