package model;

public class Point {

	public static final int RED = 1;
	public static final int BLACK = 0;
	
	
	private int xPosition;
	private int yPosition;
	private int radius;
	private Color color;
	
	public Point(int xPosition, int yPosition, int radius) {
		this.radius = radius;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.color = new Color();
	}

	public int getxPosition() {
		return xPosition;
	}

	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public int getyPosition() {
		return yPosition;
	}

	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	

}
