package com.dhemery.towers.application.fixtures;

import com.dhemery.towers.application.Towers;
import com.dhemery.towers.model.Address;
import com.objogate.wl.swing.AWTEventQueueProber;
import com.objogate.wl.swing.driver.JFrameDriver;
import static com.objogate.wl.swing.driver.JFrameDriver.*;
import com.objogate.wl.swing.gesture.GesturePerformer;

public class TowersDriver {
	private static JFrameDriver frame;

	@SuppressWarnings("unchecked")
	public static void launch() {
		Towers.main();
        frame = new JFrameDriver(new GesturePerformer(), new AWTEventQueueProber(), named(Towers.APPLICATION_FRAME_NAME), showingOnScreen());
	}

	public static void stop() {
		frame.dispose();
	}

	public static CityDriver theCity() {
		return new CityDriver(frame);
	}
	
	public static TowerDriver tower(int row, int column) {
		return new TowerDriver(frame, new Address(row, column));
	}
}
