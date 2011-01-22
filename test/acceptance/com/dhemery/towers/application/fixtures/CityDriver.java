package com.dhemery.towers.application.fixtures;

import java.awt.GridLayout;

import javax.swing.JPanel;

import org.hamcrest.Description;

import static org.hamcrest.Matchers.*;

import com.dhemery.towers.application.Towers;
import com.objogate.wl.Query;
import com.objogate.wl.swing.driver.JComponentDriver;
import static com.objogate.wl.swing.driver.JComponentDriver.*;
import com.objogate.wl.swing.driver.JFrameDriver;

public class CityDriver {
	private JComponentDriver<JPanel> panel;

	@SuppressWarnings("unchecked")
	public CityDriver(JFrameDriver frame) {
		panel = new JComponentDriver<JPanel>(frame, JPanel.class, named(Towers.CITY_PANEL_NAME), showingOnScreen());
	}

	public void hasLength(int expectedLength) {
		panel.has(rowCount(), equalTo(expectedLength));
	}

	public void hasWidth(int expectedWidth) {
		panel.has(columnCount(), equalTo(expectedWidth));
	}
	
	public static Query<JPanel,Integer> rowCount() {
		return new Query<JPanel,Integer>() {
			@Override
			public void describeTo(Description description) {
				description.appendText("row count");
			}

			@Override
			public Integer query(JPanel panel) {
				GridLayout layout = (GridLayout) panel.getLayout();
				return layout.getRows();
			};
		};
	}

	public static Query<JPanel,Integer> columnCount() {
		return new Query<JPanel,Integer>() {
			@Override
			public void describeTo(Description description) {
				description.appendText("column count");
			}

			@Override
			public Integer query(JPanel panel) {
				GridLayout layout = (GridLayout) panel.getLayout();
				return layout.getRows();
			};
		};
	}
}
