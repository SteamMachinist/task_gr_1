package ru.vsu.cs.roshchupkin_ya_a.drawableentities;

import java.awt.*;

public abstract class DrawableEntity {
    protected final double xFactor;
    protected final double yFactor;
    protected final double widthFactor;
    protected final double heightFactor;

    public DrawableEntity(double xFactor, double yFactor, double widthFactor, double heightFactor) {
        this.xFactor = xFactor;
        this.yFactor = yFactor;
        this.widthFactor = widthFactor;
        this.heightFactor = heightFactor;
    }

    public abstract void draw(Graphics2D g, int currWidth, int currHeight);
}
