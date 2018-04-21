package com.dauflo.www;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Cercle extends Forme2D {

	private Point pos;
	private int size;
	private Color color;
	private boolean focus = false;

	public Cercle(int size, Point pos) {
		this.pos = pos;
		this.size = size;
	}

	@Override
	public int compareTo(Forme2D o) {
		return 0;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public double getSurface() {
		return Math.PI * size * size;
	}

	@Override
	public void draw(Graphics g) {
		g.drawOval((int) pos.getX(), (int) pos.getY(), size, size);
		if (focus) {
			g.setColor(Color.RED);
		} else if (color != null) {
			g.setColor(color);
		} else {
			g.setColor(Color.BLACK);
		}
		g.fillOval((int) pos.getX() + 1, (int) pos.getY(), size - 1, size - 1);
	}

	@Override
	public void setColor(Color c) {
		this.color = c;

	}

	@Override
	public Point getPos() {
		return pos;
	}

	@Override
	public void setFocus() {
		this.focus = true;
	}

	@Override
	public void unFocus() {
		this.focus = false;
	}

	@Override
	public void setPos(Point p) {
		this.pos = p;
	}

}
