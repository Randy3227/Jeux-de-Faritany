package jeuxRandy;
import java.awt.Color;
import java.util.Vector;

import javax.swing.text.html.parser.Element;

import GOP.*;
import View.*;
public class Main {

    public static void main(String[] args) {
        Frame frame = new Frame();
        
        Player[] p = new Player[2];
        p[0] = new Player("Randy", Color.RED);
        p[1] = new Player("Koto", Color.GREEN);

        Points p1 = new Points(1, 1);
        Points p2 = new Points(2, 2);
        Points p3 = new Points(3, 2);
        Points p4 = new Points(3, 1);
        Points p5 = new Points(4, 0);
        Points p6 = new Points(1, 2);
        Points p7 = new Points(1, 3);
        Points p8 = new Points(2, 3);
        // Points p9 = new Points(2,0);
        
        p[0].getPoints().add(p1);
        p[0].getPoints().add(p2);
        p[0].getPoints().add(p3);
        p[0].getPoints().add(p4);
        p[0].getPoints().add(p5);
        p[0].getPoints().add(p6);
        p[0].getPoints().add(p7);
        p[0].getPoints().add(p8);
        // p[0].getPoints().add(p9);
        Noeud n = new Noeud(p1,p1);
        // Vector<Points> neighboor = n.getAllNeighboorPoint(p1, 1, p[0]);
        // for (int i = 0; i < neighboor.size(); i++) {
        //     System.out.println((Points)neighboor.get(i));
        // }
        n.algorithm(n,p1, 1, p[0],null);
    }
}