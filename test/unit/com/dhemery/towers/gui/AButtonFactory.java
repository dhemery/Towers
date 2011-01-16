package com.dhemery.towers.gui;
import static org.fest.assertions.Assertions.*;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;

import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.dhemery.towers.gui.ButtonFactory;
import com.dhemery.towers.model.Address;
import com.dhemery.towers.model.Tower;
import com.dhemery.towers.model.Grid;
import com.dhemery.towers.model.TowerFactory;


public class AButtonFactory {
	private final Address blackAddress = new Address(0,0);
	private final Address whiteAddress = new Address(999,12);
	private final Address grayAddress = new Address(3,1233);
	private final List<Address> addresses = Arrays.asList(blackAddress, whiteAddress, grayAddress);

	private final Tower blackTower = Tower.createBlack();
	private final Tower whiteTower = Tower.createWhite();
	private final Tower grayTower = Tower.NONE;

	@Rule public JUnitRuleMockery context = new JUnitRuleMockery();

	@Mock public TowerFactory towerFactory;
	@Mock public Grid grid;

	@Before
	public void setUp() {
		System.setProperty("java.awt.headless", "true");
	}

	@Test
	public void makesAButtonForEachAddress() {
		context.checking(new Expectations() {{
			allowing (grid).addresses();
			will (returnValue(addresses));

			allowing (towerFactory).tower(with(any(Address.class)));
			will (returnValue(Tower.createBlack()));
		}});

		List<JButton> buttons = new ButtonFactory(grid, towerFactory).buttons();

		assertThat(buttons.size()).isEqualTo(addresses.size());
		for(int i = 0 ; i < addresses.size() ; i++) {
			assertThat(buttons.get(i).getName()).isEqualTo(addresses.get(i).name());
		}
	}

	@Test
	public void colorsButtonsByTowerColor() {
		context.checking(new Expectations() {{
			allowing (grid).addresses(); will (returnValue(addresses));

			allowing (towerFactory).tower(with(any(Address.class)));
			will(onConsecutiveCalls(
					returnValue(blackTower),
					returnValue(whiteTower),
					returnValue(grayTower)));
		}});

		List<JButton> buttons = new ButtonFactory(grid, towerFactory).buttons();

		assertThatButtonColorsMatchTowerColor(buttons.get(0), blackTower);
		assertThatButtonColorsMatchTowerColor(buttons.get(1), whiteTower);
		assertThatButtonColorsMatchTowerColor(buttons.get(2), grayTower);
	}

	private void assertThatButtonColorsMatchTowerColor(JButton button, Tower tower) {
		assertThat(button.getForeground()).isEqualTo(foregroundFor(tower));
		assertThat(button.getBackground()).isEqualTo(backgroundFor(tower));
	}

	private Color backgroundFor(Tower tower) {
		if(tower.equals(blackTower)) return Color.black;
		if(tower.equals(whiteTower)) return Color.white;
		return Color.gray;
	}

	private Color foregroundFor(Tower tower) {
		if(tower.equals(blackTower)) return Color.white;
		if(tower.equals(whiteTower)) return Color.black;
		return Color.gray;
	}
}
