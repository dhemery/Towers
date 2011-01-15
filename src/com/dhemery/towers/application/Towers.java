package com.dhemery.towers.application;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.dhemery.towers.model.Grid;

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
		ButtonFactory buttonFactory = new ButtonFactory();
		Grid grid = new Grid(CITY_SIZE, CITY_SIZE);
		makeCityDisplay(cityPanel, grid, buttonFactory);
		makeApplicationFrame(cityPanel);
	}

	private void makeCityDisplay(JPanel panel, Grid grid, ButtonFactory factory) {
		panel.setName(Towers.CITY_PANEL_NAME);
		panel.setLayout(new GridLayout(grid.rows(), grid.columns()));
		panel.setPreferredSize(new Dimension(400,400));

		for(JButton button : factory.buttonsFor(grid)) {
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
