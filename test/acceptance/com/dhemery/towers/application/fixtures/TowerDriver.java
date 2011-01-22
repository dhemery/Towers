package com.dhemery.towers.application.fixtures;

import java.awt.Color;

import javax.swing.JButton;

import static org.hamcrest.Matchers.equalTo;

import com.dhemery.towers.gui.TowerRenderer;
import com.dhemery.towers.model.Address;
import com.dhemery.towers.model.Tower;
import com.objogate.wl.swing.driver.JButtonDriver;
import static com.objogate.wl.swing.driver.JButtonDriver.*;
import com.objogate.wl.swing.driver.JFrameDriver;

public class TowerDriver {
	private JButtonDriver button;

	@SuppressWarnings("unchecked")
	public TowerDriver(JFrameDriver frame, Address address) {
		button = new JButtonDriver(frame, JButton.class, named(address.name()), showingOnScreen());
	}

	public void hasColor(Tower.Color towerColor) {
		button.has(foregroundColor(), equalTo(foregroundFor(towerColor)));
		button.has(backgroundColor(), equalTo(backgroundFor(towerColor)));
	}

	private Color foregroundFor(Tower.Color towerColor) {
		if(towerColor == Tower.Color.BLACK) return TowerRenderer.BLACK_FOREGROUND;
		if(towerColor == Tower.Color.WHITE) return TowerRenderer.WHITE_FOREGROUND;
		if(towerColor == Tower.Color.GRAY) return TowerRenderer.GRAY_FOREGROUND;
		return null;
	}

	private Color backgroundFor(Tower.Color towerColor) {
		if(towerColor == Tower.Color.BLACK) return TowerRenderer.BLACK_BACKGROUND;
		if(towerColor == Tower.Color.WHITE) return TowerRenderer.WHITE_BACKGROUND;
		if(towerColor == Tower.Color.GRAY) return TowerRenderer.GRAY_BACKGROUND;
		return null;
	}
	
	public void hasfloorCount(Integer expectedFloorCount) {
		button.hasText(equalTo(expectedFloorCount.toString()));
	}
}
