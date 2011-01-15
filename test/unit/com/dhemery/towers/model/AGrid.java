package com.dhemery.towers.model;

import static org.fest.assertions.Assertions.*;

import org.jmock.Expectations;
import org.jmock.Sequence;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

public class AGrid {
	@Rule public JUnitRuleMockery context = new JUnitRuleMockery();

	@Test
	public void remembersHowManyRowsItHas() {
		assertThat(new Grid(905, 0).rows()).isEqualTo(905);
	}
	
	@Test
	public void remembersHowManyColumnsItHas() {
		assertThat(new Grid(0, 39).columns()).isEqualTo(39);
	}
	
	@Test
	public void visitsAddressesInRowAndColumnOrder() {
		final Sequence rowAndColumnOrder = context.sequence("row-column-order");
		final Tourist visitTheAddress = context.mock(Tourist.class);

		context.checking(new Expectations() {{
			oneOf(visitTheAddress).visit(new Address(0,0)); inSequence(rowAndColumnOrder);
			oneOf(visitTheAddress).visit(new Address(0,1)); inSequence(rowAndColumnOrder);
			oneOf(visitTheAddress).visit(new Address(1,0)); inSequence(rowAndColumnOrder);
			oneOf(visitTheAddress).visit(new Address(1,1)); inSequence(rowAndColumnOrder);
			oneOf(visitTheAddress).visit(new Address(2,0)); inSequence(rowAndColumnOrder);
			oneOf(visitTheAddress).visit(new Address(2,1)); inSequence(rowAndColumnOrder);
		}});

		new Grid(3,2).atEachAddress(visitTheAddress);
	}
}
