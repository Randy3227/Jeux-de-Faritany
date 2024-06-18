package GOP;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Vector;

public class Noeud {

    private Points depart;
    private Noeud[] nextNoeuds;
    private Noeud previousNoeud;
    private Points origine;

    public Noeud(Points o, Points depart) {
        origine = o;
        this.depart = depart;
    }

    public Points getDepart() {
        return depart;
    }

    public void setDepart(Points depart) {
        this.depart = depart;
    }

    public Noeud[] getNextNoeuds() {
        return nextNoeuds;
    }

    public Noeud getPreviousNoeud() {
        return previousNoeud;
    }

    public void setPreviousNoeud(Noeud previousNoeud) {
        this.previousNoeud = previousNoeud;
    }

    public Points getOrigine() {
        return origine;
    }

    public void setOrigine(Points origine) {
        this.origine = origine;
    }

    public ArrayList<Points> getAllNeighboorPoint(Points depart, int cote, Player player) {
        ArrayList<Points> allNeighboor = new ArrayList<Points>();
        Points p1 = new Points((int) depart.getX() + cote, (int) depart.getY());
        Points p2 = new Points((int) depart.getX() - cote, (int) depart.getY());
        Points p3 = new Points((int) depart.getX(), (int) depart.getY() + cote);
        Points p4 = new Points((int) depart.getX(), (int) depart.getY() - cote);
        Points p5 = new Points((int) depart.getX() + cote, (int) depart.getY() + cote);
        Points p6 = new Points((int) depart.getX() - cote, (int) depart.getY() + cote);
        Points p7 = new Points((int) depart.getX() - cote, (int) depart.getY() - cote);
        Points p8 = new Points((int) depart.getX() + cote, (int) depart.getY() - cote);
        Points[] neighboorPoints = { p1, p2, p3, p4, p5, p6, p7, p8 };
        for (int i = 0; i < neighboorPoints.length; i++) {
            for (int j = 0; j < player.getPoints().size(); j++) {
                if (neighboorPoints[i].equals((Points) (player.getPoints().get(j)))) {
                    allNeighboor.add(neighboorPoints[i]);
                }
            }
        }
        return allNeighboor;
    }

    public void algorithm(Noeud debut, Points depart, int cote, Player player, Noeud previous) {
        debut.depart = depart;
        debut.setPreviousNoeud(previous);
        ArrayList<Points> my_neighboor = getAllNeighboorPoint(depart, cote, player);
        for (int i = 0; i < my_neighboor.size(); i++) {
            try {
                if (debut.getPreviousNoeud() == null || debut.getPreviousNoeud().depart.equals(my_neighboor.get(i))) {
                    System.out.println(debut.getPreviousNoeud());
                    algorithm(new Noeud(origine, my_neighboor.get(i)), (Points) my_neighboor.get(i), cote, player,
                            debut);
                }
                 else {
                    if (!debut.getPreviousNoeud().depart.equals((my_neighboor.get(i)))) {
                        debut.nextNoeuds = new Noeud[my_neighboor.size()];
                        debut.nextNoeuds[i] = new Noeud(debut.origine, (Points) my_neighboor.get(i));

                        if (my_neighboor.get(i).equals(debut.origine)) {
                            System.out.println("Polygone");
                            System.out.println(debut.getNextNoeuds()[i]);
                            System.exit(0);
                        } else {
                            algorithm(new Noeud(origine, my_neighboor.get(i)), (Points) my_neighboor.get(i), cote,
                                    player, debut);
                        }
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
