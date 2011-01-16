package com.dhemery.towers.gui;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;

import com.dhemery.towers.model.Tower;

public class DefaultTowerRenderer implements TowerRenderer {
	public static final Color GRAY_FOREGROUND = Color.gray;
	public static final Color GRAY_BACKGROUND = Color.gray;
	public static final Color BLACK_FOREGROUND = Color.white;
	public static final Color BLACK_BACKGROUND = Color.black;
	public static final Color WHITE_FOREGROUND = Color.black;
	public static final Color WHITE_BACKGROUND = Color.white;
	private static final Style blackStyle = new Style(BLACK_FOREGROUND, BLACK_BACKGROUND);
	private static final Style whiteStyle = new Style(WHITE_FOREGROUND, WHITE_BACKGROUND);
	private static final Style grayStyle = new Style(GRAY_FOREGROUND, GRAY_BACKGROUND);
	private final Map<Tower.Color,Style> stylesByColor;

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
