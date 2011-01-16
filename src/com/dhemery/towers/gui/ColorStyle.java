package com.dhemery.towers.gui;

import java.awt.Color;

import javax.swing.JComponent;

public class ColorStyle {
	private final Color foreground;
	private final Color background;
	
	public ColorStyle(Color foreground, Color background) {
		this.foreground = foreground;
		this.background = background;
	}
	
	public void render(JComponent component) {
		component.setForeground(foreground);
		component.setBackground(background);
	}
}