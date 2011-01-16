package com.dhemery.towers.gui;

import javax.swing.JButton;

import com.dhemery.towers.model.Tower;

public interface TowerRenderer {
	void render(JButton button, Tower tower);
}