package View;

import java.awt.Color;
import java.io.File;
import java.io.FileWriter;
import java.util.Vector;

import javax.swing.JFrame;
import View.*;
import GOP.*;

public class Frame extends JFrame {
    Terrain field = new Terrain(1000, new Player[] {
            new Player("Randy", Color.RED),
            new Player("CPU", Color.BLUE)
    });

    public Frame() {
        super("Game of Point");
        setSize(1920, 1000);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(field);
        pack();
        setJMenuBar(field.getMenuBar());
        setVisible(true);
    }


}