package GOP;

import java.awt.Color;
import java.util.Vector;

public class Player {

    private String name;

    private Vector<Points> points = new Vector<>();

    private Color color;

    public Color getColor() {
        return color;
    }

    public Player(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Vector<Points> getPoints() {
        return points;
    }

    public void setPoints(Vector<Points> points) {
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}