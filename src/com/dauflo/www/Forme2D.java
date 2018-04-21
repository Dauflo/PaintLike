package com.dauflo.www;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public abstract class Forme2D implements Comparable<Forme2D> {
	abstract public int getSize();
	
	abstract public void setSize(int size);
	
	abstract public double getSurface();
	
	abstract public void draw(Graphics g);
	
	abstract public void setColor(Color c);
	
	abstract public Point getPos();
	
	abstract public void setPos(Point p);
	
	abstract public void setFocus();
	
	abstract public void unFocus();
}
