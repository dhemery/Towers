package com.dhemery.towers.application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.dhemery.towers.model.Address;

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
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setName(APPLICATION_FRAME_NAME);
		JPanel panel = new JPanel();
		panel.setName(CITY_PANEL_NAME);
		panel.setLayout(new GridLayout(CITY_SIZE,CITY_SIZE));
		panel.setPreferredSize(new Dimension(400,400));
		frame.add(panel, BorderLayout.CENTER);
		for(int row = 0 ; row < CITY_SIZE ; row++) {
			for(int column = 0 ; column < CITY_SIZE ; column++) {
				JButton button = new JButton();
				button.setName(new Address(row,column).name());
				button.setSize(60,60);
				button.setHorizontalAlignment(JButton.CENTER);
				button.setOpaque(true);
				if(isEven(row+column)) {
					button.setForeground(Color.white);
					button.setBackground(Color.black);
				} else {
					button.setForeground(Color.black);
					button.setBackground(Color.white);					
				}
				button.setText("1");
				button.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
				panel.add(button);
			}
		}
		frame.pack();
	}

	private boolean isEven(int i) {
		return i %2 == 0;
	}

	private void run() {
		frame.setVisible(true);
	}
}
