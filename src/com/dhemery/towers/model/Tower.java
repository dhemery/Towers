package com.dhemery.towers.model;

public class Tower {
	private final Color color;

	public enum Color {
		BLACK,
		WHITE,
		GRAY
	}

	public Tower(Color color) {
		this.color = color;
	}

	public Integer height() {
		return 1;
	}

	public static Tower createBlack() {
		return new Tower(Color.BLACK);
	}

	public static Tower createWhite() {
		return new Tower(Color.WHITE);
	}

	public static Tower createGray() {
		return new Tower(Color.GRAY);
	}

	public Color color() {
		return color;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tower other = (Tower) obj;
		if (color != other.color)
			return false;
		return true;
	}

}
