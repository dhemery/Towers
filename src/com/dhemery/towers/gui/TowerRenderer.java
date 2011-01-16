package com.dhemery.towers.gui;

import java.awt.Color;
import java.util.EnumMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import com.dhemery.towers.model.Tower;

public class TowerRenderer {
	public static final Color GRAY_FOREGROUND = Color.gray;
	public static final Color GRAY_BACKGROUND = Color.gray;
	public static final Color BLACK_FOREGROUND = Color.white;
	public static final Color BLACK_BACKGROUND = Color.black;
	public static final Color WHITE_FOREGROUND = Color.black;
	public static final Color WHITE_BACKGROUND = Color.white;

	private static final ColorStyle blackStyle = new ColorStyle(BLACK_FOREGROUND, BLACK_BACKGROUND);
	private static final ColorStyle whiteStyle = new ColorStyle(WHITE_FOREGROUND, WHITE_BACKGROUND);
	private static final ColorStyle grayStyle = new ColorStyle(GRAY_FOREGROUND, GRAY_BACKGROUND);
	private static final Map<Tower.Color,ColorStyle> stylesByColor;

	static {
		stylesByColor = new EnumMap<Tower.Color,ColorStyle>(Tower.Color.class);
		stylesByColor.put(Tower.Color.BLACK, blackStyle);
		stylesByColor.put(Tower.Color.WHITE, whiteStyle);
		stylesByColor.put(Tower.Color.GRAY, grayStyle);
	}

	public void render(JButton button, Tower tower) {
		stylesByColor.get(tower.color()).render(button);
		button.setText(tower.height().toString());
		button.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
	}
}
