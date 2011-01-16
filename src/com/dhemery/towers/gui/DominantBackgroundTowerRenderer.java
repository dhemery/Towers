package com.dhemery.towers.gui;

import java.awt.Color;
import javax.swing.JButton;

import com.dhemery.towers.model.Tower;

public class DominantBackgroundTowerRenderer implements TowerRenderer {
	private static final Style black = new Style(Color.white, Color.black);
	private static final Style white = new Style(Color.black, Color.white);
	private static final Style gray = new Style(Color.gray, Color.gray);
	private static final Style invalid = new Style(Color.orange, Color.orange);

	public static class Style {
		private final Color foreground;
		private final Color background;

		private Style(Color foreground, Color background) {
			this.foreground = foreground;
			this.background = background;
		}
		
		public void render(JButton button) {
			button.setForeground(foreground);
			button.setBackground(background);
		}
	}

	@Override
	public void render(JButton button, Tower tower) {
		Style style = invalid;
		if(tower.color().equals(Tower.Color.BLACK)) {
			style = black;
		} else if(tower.color().equals(Tower.Color.WHITE)) {
			style = white;					
		} else if(tower.color().equals(Tower.Color.GRAY)) {
			style = gray;					
		}
		style.render(button);
	}
}
