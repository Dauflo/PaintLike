package com.dauflo.www;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;

public class ZoneDessin extends Component implements KeyListener, MouseListener, MouseMotionListener {
	public ArrayList<Forme2D> formes;

	public ZoneDessin(ArrayList<Forme2D> formes) {
		setFocusable(true);
		addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		this.formes = formes;
	}

	@Override
	public void paint(Graphics g) {
		for (Forme2D f : formes) {
			f.draw(g);
		}
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int size = (int) (Math.random() * 100);
		Random rng = new Random();
		float r = rng.nextFloat();
		float g = rng.nextFloat();
		float b = rng.nextFloat();

		Color randomColor = new Color(r, g, b);
		switch (e.getKeyCode()) {
		case KeyEvent.VK_R:
			Carre c = new Carre(size, new Point(getWidth() / 2 - size / 2, getHeight() / 2 - size / 2));
			c.setColor(randomColor);
			formes.add(c);
			break;
		case KeyEvent.VK_C:
			Cercle ce = new Cercle(size, new Point(getWidth() / 2 - size / 2, getHeight() / 2 - size / 2));
			ce.setColor(randomColor);
			formes.add(ce);
			break;
		case KeyEvent.VK_T:
			for (int i = 0; i < formes.size(); i++) {
				for (int j = 1; j < formes.size() - i; j++) {
					int c1 = formes.get(j).getSize();
					int c2 = formes.get(j - 1).getSize();
					if (c1 > c2) {
						Forme2D grand = formes.get(j - 1);
						formes.set(j - 1, formes.get(j));
						formes.set(j, grand);
					}
				}
			}
			break;
		case KeyEvent.VK_D:
			if (formes.size() > 0) {
				formes.remove(formes.size() - 1);
			}
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getModifiers() == MouseEvent.BUTTON3_MASK) {
			for (Forme2D f : formes) {
				f.unFocus();
			}
		} else if (e.getModifiers() == MouseEvent.BUTTON1_MASK) {
			Point p = MouseInfo.getPointerInfo().getLocation();
			
			for(int i = formes.size() - 1; i >= 0; i--) {
				Point pos = formes.get(i).getPos();
				int longueur = formes.get(i).getSize();
				
				if ((p.getY() >= pos.getY() + 40 && p.getY() <= pos.getY() + 40 + longueur) && (p.getX() >= pos.getX() && p.getX() <= pos.getX() + longueur)){
					formes.get(i).setFocus();
					break;
				}
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		Point p = MouseInfo.getPointerInfo().getLocation();
		for (int i = formes.size() - 1; i >= 0; i--) {
			int longueur = formes.get(i).getSize();
			Point pos = formes.get(i).getPos();
			
			if ((p.getY() >= pos.getY() + 40 && p.getY() <= pos.getY() + 40 + longueur) && (p.getX() >= pos.getX() && p.getX() <= pos.getX() + longueur)){
				Point goodPos = new Point((int) (p.getX() - formes.get(i).getSize() / 2), (int) (p.getY() - formes.get(i).getSize() / 2) - 40);
				formes.get(i).setPos(goodPos);
				break;
			}
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
