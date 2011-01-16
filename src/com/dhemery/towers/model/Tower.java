package com.dhemery.towers.model;

public class Tower {
	public static final Tower NONE = new Tower(Color.GRAY);
	private final Color color;

	public enum Color {
		BLACK,
		WHITE,
		GRAY
	}

	private Tower(Color color) {
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

	public Color color() {
		return color;
	}

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
