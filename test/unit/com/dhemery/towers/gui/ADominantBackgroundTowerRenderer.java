package com.dhemery.towers.gui;

import static org.fest.assertions.Assertions.*;

import java.awt.Color;

import javax.swing.JButton;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.dhemery.towers.gui.fixtures.RunHeadless;
import com.dhemery.towers.model.Tower;

public class ADominantBackgroundTowerRenderer {
	private JButton button;
	private TowerRenderer renderer;

	@Rule public RunHeadless headless = new RunHeadless();

	@Before
	public void setUp() {
		button = new JButton();
		renderer = new DominantBackgroundTowerRenderer();
	}

	@Test
	public void rendersABlackTowerAsWhiteOnBlack() {
		renderer.render(button, Tower.createBlack("black"));
		assertThat(button.getForeground()).isEqualTo(Color.white);
		assertThat(button.getBackground()).isEqualTo(Color.black);
	}

	@Test
	public void rendersAWhiteTowerAsBlackOnWhite() {
		renderer.render(button, Tower.createWhite("white"));
		assertThat(button.getForeground()).isEqualTo(Color.black);
		assertThat(button.getBackground()).isEqualTo(Color.white);
	}
	
	@Test
	public void rendersAGrayTowerAsGrayOnGray() {
		renderer.render(button, Tower.createGray("gray"));
		assertThat(button.getForeground()).isEqualTo(Color.gray);
		assertThat(button.getBackground()).isEqualTo(Color.gray);
	}
}
