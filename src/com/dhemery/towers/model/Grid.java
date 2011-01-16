package com.dhemery.towers.model;

import java.util.List;

public interface Grid {
	int rows();
	int columns();
	List<Address> addresses();
}
