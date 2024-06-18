package GOP;

import java.awt.Point;
import java.io.File;
import java.io.FileWriter;
import java.util.Vector;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.swing.text.PlainDocument;

import View.*;

public class GOP {
   private Player player;

   public Player getPlayer() {
      return player;
   }

   public void setPlayer(Player player) {
      this.player = player;
   }

   public GOP(Player player) {
      this.player = player;
   }
   public GOP(){

   }

   public Points getStartPoint(Points p) {
      return p;
   }

   // public Vector<Points> algorithm(Points p, int cote,Player player) {
   //    Vector<Points> needed = new Vector<Points>();
   //    Vector<Points> notNeeded = new Vector<Points>();
   //    needed.add(p);
      
   //    while (needed.size()>0) {
   //       needed.sort((a, b) -> b.getCout() - a.getCout());
   //       Points a_etudie = needed.get(0);
   //       needed.remove(0);
   //       notNeeded.add(a_etudie);

   //       Vector<Points> voisin = getAllNeighboorPoint(p, cote,player);
   //          for (Points points : voisin) {
   //             if (!notNeeded.contains(points) || points.equals(p)){
   //                points.setCout(a_etudie.getCout() + 1);
   //                points.setParent(a_etudie);
   
   //                if (points.equals(p) && points.getCout() >= 3) {
   //                   System.out.println("Yes");
   //                   return getPath(points);
   //                }
   //                if (!points.equals(p)) {
   //                   needed.add(points);
   //                }
   //             }
   //          }
   //    }

   //    return null;
   // }

   // private Vector<Points> getPath(Points points) {
   //    Vector<Points> p = new Vector<Points>();
   //    while (points.getParent() != null) {
   //       p.add(0, points);
   //       points = points.getParent();
   //    }
   //    return p;
   // }


   // public boolean estPolygoneFerme(Vector<Points> points) {
   //      if (points.size() <= 3) {
   //          return false;
   //      }
   //       Points premierPoint = points.get(0);
   //       Points dernierPoint = points.get(points.size() - 1);
   //      if(premierPoint.equals(dernierPoint)){
   //         return true;
   //      }
   //  }


   public void save(Vector<Points> data,Terrain t){
      int result = t.getFileChooser().showSaveDialog(t);
      if(result == t.getFileChooser().APPROVE_OPTION) {
          File choosedFile = t.getFileChooser().getSelectedFile();
          try {
              FileWriter writer = new FileWriter(choosedFile,true);
              for (int i = 0; i < data.size(); i++) {
                  writer.write((String)((Points)data.get(i)).toString());
              }    
              writer.close();       
              
          } catch (Exception e) {
              System.out.println("Erreur de sauvegarde");
          }
      }
   }   

}