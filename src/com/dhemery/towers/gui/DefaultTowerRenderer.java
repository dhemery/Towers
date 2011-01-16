package com.dhemery.towers.gui;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;

import com.dhemery.towers.model.Tower;

public class DefaultTowerRenderer implements TowerRenderer {
	private static final Style blackStyle = new Style(Color.white, Color.black);
	private static final Style whiteStyle = new Style(Color.black, Color.white);
	private static final Style grayStyle = new Style(Color.gray, Color.gray);
	private Map<Tower.Color,Style> stylesByColor;

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

	public DefaultTowerRenderer() {
		stylesByColor = new HashMap<Tower.Color,Style>();
		stylesByColor.put(Tower.Color.BLACK, blackStyle);
		stylesByColor.put(Tower.Color.WHITE, whiteStyle);
		stylesByColor.put(Tower.Color.GRAY, grayStyle);
	}

	@Override
	public void render(JButton button, Tower tower) {
		stylesByColor.get(tower.color()).render(button);
	}
}
