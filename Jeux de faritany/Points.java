package GOP;

import java.awt.Point;

public class Points extends Point {

    public Player player;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Points(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean equals(Object objet) {
        if (objet instanceof Points) {
            Points p = ((Points) objet);
            return p.x == x && p.y == y;
        }
        return false;
    }

}
