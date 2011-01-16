package com.dhemery.towers.gui;

import static org.fest.assertions.Assertions.*;

import java.awt.Color;

import javax.swing.JLabel;

import org.junit.Test;

public class AColorStyle {
	@Test
	public void rendersForegroundAndBackgroundColor() {
		JLabel label = new JLabel();
		label.setForeground(Color.black);
		label.setBackground(Color.white);
		
		new ColorStyle(Color.red, Color.green).render(label);
		assertThat(label.getForeground()).isEqualTo(Color.red);
		assertThat(label.getBackground()).isEqualTo(Color.green);
	}
}
