package com.dhemery.towers.gui;
import static org.fest.assertions.Assertions.*;

import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;

import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import com.dhemery.towers.gui.ButtonFactory;
import com.dhemery.towers.gui.fixtures.RunHeadless;
import com.dhemery.towers.model.Address;
import com.dhemery.towers.model.Tower;
import com.dhemery.towers.model.Grid;
import com.dhemery.towers.model.TowerFactory;


public class AButtonFactory {
	@Rule public RunHeadless headless = new RunHeadless();
	@Rule public JUnitRuleMockery context = new JUnitRuleMockery();
	
	@Mock public TowerFactory towerFactory;
	@Mock public Grid grid;
	@Mock public TowerRenderer renderer;

	@Test
	public void makesAButtonForEachAddress() {
		final List<Address> addresses = Arrays.asList(
				new Address(0,0),
				new Address(999,12),
				new Address(3,1233));

		context.checking(new Expectations() {{
			allowing (towerFactory).tower(with(any(Address.class)));
			will (returnValue(Tower.createBlack()));
			
			allowing(renderer).render(with(any(JButton.class)), with(any(Tower.class)));
		}});

		List<JButton> buttons = new ButtonFactory(addresses, towerFactory, renderer).buttons();

		assertThat(buttons.size()).isEqualTo(addresses.size());
		for(int i = 0 ; i < addresses.size() ; i++) {
			assertThat(buttons.get(i).getName()).isEqualTo(addresses.get(i).name());
		}
	}

	@Test
	public void rendersButtonsWithTowerRenderer() {
		final Tower tower = Tower.createBlack();
		List<Address> addresses = Arrays.asList(new Address(0,0));
		context.checking(new Expectations() {{
			allowing (towerFactory).tower(with(any(Address.class)));
			will(returnValue(tower));
			
			oneOf (renderer).render(with(any(JButton.class)), with(same(tower)));
		}});

		new ButtonFactory(addresses, towerFactory, renderer).buttons();
	}
}
