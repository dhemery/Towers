package com.dhemery.towers.gui;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;

import org.junit.Rule;
import org.junit.Test;

import com.dhemery.towers.gui.ButtonFactory;
import com.dhemery.towers.gui.fixtures.RunHeadless;
import com.dhemery.towers.model.Address;


public class AButtonFactory {
	@Rule public RunHeadless headless = new RunHeadless();

	@Test
	public void makesAButtonForEachTower() {
		List<Address> addresses = Arrays.asList(
				new Address(0,0),
				new Address(2,14),
				new Address(1,91),
				new Address(65,65),
				new Address(9034,0),
				new Address(3,0)
				);

		List<JButton> buttons = new ButtonFactory(addresses).buttons();

		assertThat(buttons, hasSize(addresses.size()));
		for(int i = 0 ; i < addresses.size() ; i++) {
			assertThat(buttons.get(i).getName(), is(addresses.get(i).name()));
		}
	}
}
