package com.dhemery.towers.application;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.dhemery.towers.gui.ButtonFactory;
import com.dhemery.towers.gui.DominantBackgroundTowerRenderer;
import com.dhemery.towers.gui.TowerRenderer;
import com.dhemery.towers.model.AlternatingColorTowerFactory;
import com.dhemery.towers.model.RowColumnOrderGrid;
import com.dhemery.towers.model.TowerFactory;

public class Towers {
	public static final String APPLICATION_FRAME_NAME = "Application Frame";
	public static final String CITY_PANEL_NAME = "City Panel";
	protected static final int CITY_SIZE = 8;

	private final JFrame frame;
	private final JPanel cityPanel;

	public static void main(String...args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Towers().run();
			}
		});
	}

	public Towers() {
		frame = new JFrame();
		cityPanel = new JPanel();
		RowColumnOrderGrid grid = new RowColumnOrderGrid(CITY_SIZE, CITY_SIZE);
		TowerFactory towerFactory = new AlternatingColorTowerFactory();
		TowerRenderer renderer = new DominantBackgroundTowerRenderer();
		ButtonFactory buttonFactory = new ButtonFactory(grid.addresses(), towerFactory, renderer);
		makeCityDisplay(cityPanel, grid, buttonFactory);
		makeApplicationFrame(cityPanel);
	}

	private void makeCityDisplay(JPanel panel, RowColumnOrderGrid grid, ButtonFactory factory) {
		panel.setName(Towers.CITY_PANEL_NAME);
		panel.setLayout(new GridLayout(grid.rows(), grid.columns()));
		panel.setPreferredSize(new Dimension(400,400));

		for(JButton button : factory.buttons()) {
			panel.add(button);
		}
	}

	private void makeApplicationFrame(JPanel panel) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setName(APPLICATION_FRAME_NAME);
		frame.add(panel, BorderLayout.CENTER);
		frame.pack();
	}

	private void run() {
		frame.setVisible(true);
	}
}
