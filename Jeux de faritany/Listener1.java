package Controller;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.util.Vector;

import javax.swing.text.View;
import javax.swing.tree.TreeCellRenderer;

import View.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import GOP.*;

public class Listener1 extends MouseAdapter {
	private Ellipse2D.Double ellipse;

	private Terrain terrain;


	public Listener1(Ellipse2D.Double ellipse,Terrain t) {
		this.ellipse = ellipse;
		this.terrain = t;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(ellipse.contains(e.getPoint())){
			if(terrain.getEllipseUsed().contains(ellipse)) {
				return;
			}
			if(terrain.getJoueur() == 1){
				terrain.setJoueur(0);
			}
			else{
				terrain.setJoueur(1);
			}
			// System.out.println(terrain.getJoueur());
			Points click = new Points((int)ellipse.getX() , (int)ellipse.getY());
			terrain.getPlayers()[terrain.getJoueur()].getPoints().add(click);
			terrain.getEllipseUsed().add(ellipse);
		}
	}

}