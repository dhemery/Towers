package com.dhemery.towers.gui;

import java.awt.Color;
import javax.swing.JButton;

import com.dhemery.towers.model.Tower;

public class TowerRenderer {
	private final Color foreground;
	private final Color background;

	public TowerRenderer(Color foreground, Color background) {
		this.foreground = foreground;
		this.background = background;
	}

	public void renderColor(JButton button) {
		button.setForeground(foreground);
		button.setBackground(background);
	}

	public static TowerRenderer forTower(Tower tower) {
		if(tower.color().equals(Tower.Color.BLACK)) {
			return new TowerRenderer(Color.white, Color.black);
		} if(tower.color().equals(Tower.Color.WHITE)) {
			return new TowerRenderer(Color.black, Color.white);					
		} if(tower.color().equals(Tower.Color.GRAY)) {
			return new TowerRenderer(Color.gray, Color.gray);					
		} else {
			return new TowerRenderer(Color.orange, Color.orange);
		}
	}
}
