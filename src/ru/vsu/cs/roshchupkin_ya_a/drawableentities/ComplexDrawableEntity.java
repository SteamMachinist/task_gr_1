package ru.vsu.cs.roshchupkin_ya_a.drawableentities;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class ComplexDrawableEntity extends DrawableEntity {
    protected final List<DrawableEntity> drawableEntities = new ArrayList<>();

    public ComplexDrawableEntity(double xFactor, double yFactor, double widthFactor, double heightFactor) {
        super(xFactor, yFactor, widthFactor, heightFactor);
    }

    public ComplexDrawableEntity(double xFactor, double yFactor, double widthFactor, double heightFactor,
                                 List<DrawableEntity> drawableEntities) {
        super(xFactor, yFactor, widthFactor, heightFactor);
        this.drawableEntities.addAll(drawableEntities);
    }

    @Override
    public void draw(Graphics2D g, int currWidth, int currHeight) {
        for (DrawableEntity entity : drawableEntities) {
            entity.draw(g, currWidth, currHeight);
        }
    }
}
