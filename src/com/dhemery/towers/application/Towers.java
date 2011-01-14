package com.dhemery.towers.application;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Towers {
	public static final String APPLICATION_FRAME_NAME = "Application Frame";
	
	public static void main(String...args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new JFrame();
				frame.setName(APPLICATION_FRAME_NAME);
				frame.setVisible(true);
				frame.setLayout(new GridLayout(1,8));
			}});
	}
}
