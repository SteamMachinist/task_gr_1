package ru.vsu.cs.roshchupkin_ya_a.drawableentities.ship;

import ru.vsu.cs.roshchupkin_ya_a.drawableentities.DrawableEntity;

import java.awt.*;

public class ShipDeck extends DrawableEntity {
    private final Color color;
    private final Color windowColor;
    private final Color borderColor;

    public ShipDeck(double xFactor, double yFactor, double widthFactor, double heightFactor, Color color, Color windowColor, Color borderColor) {
        super(xFactor, yFactor, widthFactor, heightFactor);
        this.color = color;
        this.windowColor = windowColor;
        this.borderColor = borderColor;
    }

    @Override
    public void draw(Graphics2D g, int currWidth, int currHeight) {
        Color oldColor = g.getColor();
        Stroke oldStroke = g.getStroke();
        g.setStroke(new BasicStroke((float) ((currWidth + currHeight) / 400.0)));

        g.setColor(color);
        g.fillRect(
                (int) (xFactor * currWidth),
                (int) (yFactor * currHeight),
                (int) (widthFactor * currWidth ),
                (int) (heightFactor * currHeight));


        g.setColor(windowColor);
        g.fillRect(
                (int) (xFactor * currWidth),
                (int) ((yFactor + 0.2 * heightFactor) * currHeight),
                (int) (widthFactor * currWidth * 0.90),
                (int) (heightFactor * currHeight * 0.2));
        g.fillRect(
                (int) (xFactor * currWidth),
                (int) ((yFactor + 0.2 * heightFactor) * currHeight + heightFactor * currHeight * 0.4),
                (int) (widthFactor * currWidth * 0.90),
                (int) (heightFactor * currHeight * 0.2));

        g.setColor(borderColor);
        g.drawRect(
                (int) (xFactor * currWidth),
                (int) (yFactor * currHeight),
                (int) (widthFactor * currWidth ),
                (int) (heightFactor * currHeight));

        g.setColor(oldColor);
        g.setStroke(oldStroke);
    }
}
