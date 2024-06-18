package View;

import Controller.*;
import GOP.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Terrain extends JPanel {

  private JFileChooser fileChooser;

  public JFileChooser getFileChooser() {
    return fileChooser;
  }

  public void setFileChooser(JFileChooser fileChooser) {
    this.fileChooser = fileChooser;
  }

  private JMenuBar menuBar;
  public JMenuBar getMenuBar() {
    return menuBar;
  }

  public void setMenuBar(JMenuBar menuBar) {
    this.menuBar = menuBar;
  }

  public int dimension;

  private Vector<Ellipse2D.Double> ellipse = new Vector<>();
  private Vector<Ellipse2D.Double> ellipseUsed = new Vector<>();

  public Vector<Ellipse2D.Double> getEllipseUsed() {
    return ellipseUsed;
  }

  public void setEllipseUsed(Vector<Ellipse2D.Double> ellipseUsed) {
    this.ellipseUsed = ellipseUsed;
  }

  private int joueur = 0;

  public int getJoueur() {
    return joueur;
  }

  public void setJoueur(int joueur) {
    this.joueur = joueur;
  }

  private Player[] players;

  public Player[] getPlayers() {
    return players;
  }

  public void setPlayers(Player[] players) {
    this.players = players;
  }

  public int getCote() {
    return 50;
  }

  private GOP gop;

  public Terrain getTerrain(){
    return this;
  }
  public Terrain(int dimension, Player[] players) {
    super(true);
    int height = (int)dimension/getCote();
    setPreferredSize(new Dimension(1920, 1000));
    this.dimension = dimension;
    this.players = players;
    for (int i = 1; i < height; i++) {
      for (int j = 1; j < height; j++) {
        ellipse.add(new Ellipse2D.Double(i*getCote()-10,j*getCote()-10,10,10));
        Listener1 listener1 = new Listener1(ellipse.get(ellipse.size()-1), this);
        this.addMouseListener(listener1);
      }
    }

    fileChooser = new JFileChooser();
    fileChooser.setCurrentDirectory(new File(""));
    fileChooser.setFileFilter(new FileNameExtensionFilter("Saved Game", "save"));
    menuBar = new JMenuBar();
    JMenu menu = new JMenu("Appuyez ici pour enregistrer");
    menuBar.add(menu);
    JMenuItem save = new JMenuItem("Save");
    JMenuItem load = new JMenuItem("Load");
    save.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
          for (int i = 0; i < getPlayers().length; i++) { 
            }
        }
    });
    load.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
          
        }
    });
    menu.add(save);
    menu.add(load);
  }

  public void paintComponent(Graphics g1) {
    super.paintComponent(g1);
    Graphics2D g = (Graphics2D) g1.create();
    int x = 0;
    int y = 0;
    int height = (int)dimension / getCote();

    g.setColor(Color.BLACK);
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < height; j++) {
        g.drawRect(j * getCote()-5, i * getCote()-5, getCote(), getCote());
      }
    }

    for (Ellipse2D e : ellipse) {
      g.setColor(Color.GRAY);
      g.fill(e);      
    }
    for (int i = 0; i < players.length; i++) {
      g.setColor(getPlayers()[i].getColor());
      for (Points point : getPlayers()[i].getPoints())
        g.fillOval((int) (point.getX()), (int) (point.getY()), 10, 10);
    }

    // for (int i = 0; i < getPlayers().length; i++) {
    //   for (int index = 0; index < getPlayers()[i].getPoints().size(); index++) {
    //     g.drawLine((int)((Points)getPlayers()[i].getPoints().get(index)).getX(), (int)((Points)getPlayers()[i].getPoints().get(index)).getY(), (int)((Points)getPlayers()[i].getPoints().get(index+1)).getX(), (int)((Points)getPlayers()[i].getPoints().get(index+1)).getY());
    //   }
    // }
    
    try {
      Thread.sleep(50);
    } catch (Exception e) {
    }
    repaint();
  }
}