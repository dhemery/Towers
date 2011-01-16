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
import com.dhemery.towers.model.Tower;


public class AButtonFactory {
	@Rule public RunHeadless headless = new RunHeadless();
	@Rule public JUnitRuleMockery context = new JUnitRuleMockery();
	
	@Mock public TowerRenderer renderer;

	@Test
	public void makesAButtonForEachTower() {
		final List<Tower> towers = Arrays.asList(
				Tower.createBlack("black"),
				Tower.createWhite("white"),
				Tower.createGray("gray"));

		context.checking(new Expectations() {{
			allowing(renderer).render(with(any(JButton.class)), with(any(Tower.class)));
		}});

		List<JButton> buttons = new ButtonFactory(towers, renderer).buttons();

		assertThat(buttons.size()).isEqualTo(towers.size());
		for(int i = 0 ; i < towers.size() ; i++) {
			assertThat(buttons.get(i).getName()).isEqualTo(towers.get(i).name());
		}
	}

	@Test
	public void rendersEachWithTowerRenderer() {
		final List<Tower> towers = Arrays.asList(
				Tower.createBlack("black"),
				Tower.createWhite("white"),
				Tower.createGray("gray"));
		context.checking(new Expectations() {{
			oneOf (renderer).render(with(any(JButton.class)), with(same(towers.get(0))));
			oneOf (renderer).render(with(any(JButton.class)), with(same(towers.get(1))));
			oneOf (renderer).render(with(any(JButton.class)), with(same(towers.get(2))));
		}});

		new ButtonFactory(towers, renderer).buttons();
	}
}
