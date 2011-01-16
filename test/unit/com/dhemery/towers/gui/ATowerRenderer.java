package com.dhemery.towers.gui;

import static org.fest.assertions.Assertions.*;

import java.awt.Color;

import javax.swing.JButton;

import org.junit.Before;
import org.junit.Test;

public class ATowerRenderer {
	private JButton button;

	@Before
	public void setUp() {
		System.setProperty("java.awt.headless", "true");
		button = new JButton();
	}

	@Test
	public void rendersForegroundColor() {
		TowerRenderer renderer = new TowerRenderer(Color.orange, Color.pink);
		renderer.renderColor(button);
		assertThat(button.getForeground()).isEqualTo(Color.orange);
	}

	@Test
	public void rendersBackgroundColor() {
		TowerRenderer style = new TowerRenderer(Color.orange, Color.pink);
		style.renderColor(button);
		assertThat(button.getBackground()).isEqualTo(Color.pink);
	}
}
