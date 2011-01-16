package com.dhemery.towers.application;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.dhemery.towers.gui.ButtonFactory;
import com.dhemery.towers.gui.DefaultTowerRenderer;
import com.dhemery.towers.gui.TowerRenderer;
import com.dhemery.towers.model.AlternatingColorTowerFactory;
import com.dhemery.towers.model.Grid;
import com.dhemery.towers.model.RowColumnOrderGrid;
import com.dhemery.towers.model.TowerFactory;

public class Towers {
	public static final String APPLICATION_FRAME_NAME = "Application Frame";
	public static final String CITY_PANEL_NAME = "City Panel";
	protected static final int CITY_SIZE = 8;

	private final JFrame frame;

	public static void main(String...args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Towers().run();
			}
		});
	}

	public Towers() {
		Grid grid = new RowColumnOrderGrid(CITY_SIZE, CITY_SIZE);
		TowerRenderer renderer = new DefaultTowerRenderer();
		TowerFactory towerFactory = new AlternatingColorTowerFactory(grid.addresses());
		ButtonFactory buttonFactory = new ButtonFactory(towerFactory.towers(), renderer);
		JPanel cityPanel = makeCityPanel(CITY_PANEL_NAME, grid, buttonFactory.buttons());
		frame = makeApplicationFrame(cityPanel, APPLICATION_FRAME_NAME);
	}

	private JPanel makeCityPanel(String name, Grid grid, List<JButton> buttons) {
		JPanel panel = new JPanel();
		panel.setName(name);
		panel.setLayout(new GridLayout(grid.rows(), grid.columns()));
		panel.setPreferredSize(new Dimension(400,400));

		for(JButton button : buttons) {
			panel.add(button);
		}
		return panel;
	}

	private JFrame makeApplicationFrame(JPanel cityPanel, String name) {
		JFrame frame = new JFrame();
		frame.setName(name);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(cityPanel, BorderLayout.CENTER);
		frame.pack();
		return frame;
	}

	private void run() {
		frame.setVisible(true);
	}
}
