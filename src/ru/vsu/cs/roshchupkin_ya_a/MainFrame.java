package ru.vsu.cs.roshchupkin_ya_a;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public final int pictureW = 1000;
    public final int pictureH = 600;

    public final int borderW = 16;
    public final int borderH = 39;

    public MainFrame() throws HeadlessException {
        this.setTitle("Titanic");
        this.setSize(pictureW + borderW, pictureH + borderH);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.add(new DrawPanel());
        this.setVisible(true);
    }
}
