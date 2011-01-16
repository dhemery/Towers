package com.dhemery.towers.gui.fixtures;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class RunHeadless implements TestRule {

	@Override
	public Statement apply(Statement base, Description description) {
		System.setProperty("java.awt.headless", "true");
		return base;
	}

}
