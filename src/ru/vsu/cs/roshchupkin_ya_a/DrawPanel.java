package ru.vsu.cs.roshchupkin_ya_a;

import ru.vsu.cs.roshchupkin_ya_a.drawableentities.*;

import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {
    private final World world;

    public DrawPanel() {
        this.world = new World(0, 0, 1, 1);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D gr = (Graphics2D) g;
        world.draw(gr, getWidth(), getHeight());
    }
}
