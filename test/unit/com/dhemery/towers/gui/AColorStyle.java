package com.dhemery.towers.gui;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


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
		assertThat(label.getForeground(), is(Color.red));
		assertThat(label.getBackground(), is(Color.green));
	}
}
