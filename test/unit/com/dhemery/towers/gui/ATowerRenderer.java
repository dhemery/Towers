package com.dhemery.towers.gui;

import javax.swing.JButton;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import com.dhemery.towers.gui.fixtures.RunHeadless;
import com.dhemery.towers.model.Tower;

public class ATowerRenderer {
	private JButton button;
	private TowerRenderer renderer;

	@Rule public RunHeadless headless = new RunHeadless();

	@Before
	public void setUp() {
		button = new JButton();
		renderer = new TowerRenderer();
	}

	@Test
	public void rendersABlackTower() {
		renderer.render(button, Tower.createBlack("black"));
		assertThat(button.getForeground(), is(TowerRenderer.BLACK_FOREGROUND));
		assertThat(button.getBackground(), is(TowerRenderer.BLACK_BACKGROUND));
	}

	@Test
	public void rendersAWhiteTower() {
		renderer.render(button, Tower.createWhite("white"));
		assertThat(button.getForeground(), is(TowerRenderer.WHITE_FOREGROUND));
		assertThat(button.getBackground(), is(TowerRenderer.WHITE_BACKGROUND));
	}
	
	@Test
	public void rendersAGrayTower() {
		renderer.render(button, Tower.createGray("gray"));
		assertThat(button.getForeground(), is(TowerRenderer.GRAY_FOREGROUND));
		assertThat(button.getBackground(), is(TowerRenderer.GRAY_BACKGROUND));
	}
}
