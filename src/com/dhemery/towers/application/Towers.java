package com.dhemery.towers.application;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.dhemery.towers.model.Address;

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
		for(int row = 0 ; row < CITY_SIZE ; row++) {
			for(int column = 0 ; column < CITY_SIZE ; column++) {
				JButton button = new JButton("1");
				button.setName(new Address(row,column).name());
				frame.add(button);
			}
		}
	}

	private void run() {
		frame.setVisible(true);
	}
}
