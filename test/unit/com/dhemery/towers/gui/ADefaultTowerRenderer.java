package com.dhemery.towers.gui;

import static org.fest.assertions.Assertions.*;

import javax.swing.JButton;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.dhemery.towers.gui.fixtures.RunHeadless;
import com.dhemery.towers.model.Tower;

public class ADefaultTowerRenderer {
	private JButton button;
	private TowerRenderer renderer;

	@Rule public RunHeadless headless = new RunHeadless();

	@Before
	public void setUp() {
		button = new JButton();
		renderer = new DefaultTowerRenderer();
	}

	@Test
	public void rendersABlackTower() {
		renderer.render(button, Tower.createBlack("black"));
		assertThat(button.getForeground()).isEqualTo(DefaultTowerRenderer.BLACK_FOREGROUND);
		assertThat(button.getBackground()).isEqualTo(DefaultTowerRenderer.BLACK_BACKGROUND);
	}

	@Test
	public void rendersAWhiteTower() {
		renderer.render(button, Tower.createWhite("white"));
		assertThat(button.getForeground()).isEqualTo(DefaultTowerRenderer.WHITE_FOREGROUND);
		assertThat(button.getBackground()).isEqualTo(DefaultTowerRenderer.WHITE_BACKGROUND);
	}
	
	@Test
	public void rendersAGrayTower() {
		renderer.render(button, Tower.createGray("gray"));
		assertThat(button.getForeground()).isEqualTo(DefaultTowerRenderer.GRAY_FOREGROUND);
		assertThat(button.getBackground()).isEqualTo(DefaultTowerRenderer.GRAY_BACKGROUND);
	}
}
