package com.dhemery.towers.application;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Towers {
	public static final String APPLICATION_FRAME_NAME = "Application Frame";
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
		frame = new JFrame();
		frame.setName(APPLICATION_FRAME_NAME);
		frame.setLayout(new GridLayout(CITY_SIZE,CITY_SIZE));
	}
	
	private void run() {
		frame.setVisible(true);
	}
}
