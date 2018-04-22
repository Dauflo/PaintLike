package com.dauflo.www;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MainFrame extends JFrame{

	public static void main(String[] args) {
		ArrayList<Forme2D> formes = new ArrayList<Forme2D>();
		
		JFrame myFrame = new JFrame("PaintLike");
		myFrame.setSize(500, 500);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setResizable(false);
		myFrame.setVisible(true);
		
		Container myPanel = myFrame.getContentPane();
		
		JLabel myLabel = new JLabel("PaintLike", SwingConstants.CENTER);
		myPanel.add(myLabel, BorderLayout.NORTH);
		
		ZoneDessin dessin = new ZoneDessin(formes);
		myPanel.add(dessin, BorderLayout.CENTER);
		
		myFrame.setContentPane(myPanel);;
	}
	
}
