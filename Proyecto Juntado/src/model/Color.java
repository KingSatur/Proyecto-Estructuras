package model;

public class Color {

	public static final int RED = 1;
	public static final int BLACK = 0;
	private int color;
	
	public Color() {
		this.color = BLACK;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public static int getRed() {
		return RED;
	}
	
	
}
