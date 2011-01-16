package com.dhemery.towers.model;

public class Tower {
	private final Color color;
	private final String name;

	public enum Color {
		BLACK,
		WHITE,
		GRAY
	}

	private Tower(String name, Color color) {
		this.name = name;
		this.color = color;
	}

	public Integer height() {
		return 1;
	}

	public static Tower createBlack(String name) {
		return new Tower(name, Color.BLACK);
	}

	public static Tower createWhite(String name) {
		return new Tower(name, Color.WHITE);
	}

	public static Tower createGray(String name) {
		return new Tower(name, Color.GRAY);
	}

	public Color color() {
		return color;
	}

	public String name() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
