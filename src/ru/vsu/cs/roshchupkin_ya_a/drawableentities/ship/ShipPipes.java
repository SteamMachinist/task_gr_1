package ru.vsu.cs.roshchupkin_ya_a.drawableentities.ship;

import ru.vsu.cs.roshchupkin_ya_a.drawableentities.DrawableEntity;

import java.awt.*;

public class ShipPipes extends DrawableEntity {
    private final Color pipesColor;
    private final Color borderColor;
    private final Color bottomColor;

    public ShipPipes(double xFactor, double yFactor, double widthFactor, double heightFactor,
                     Color pipesColor, Color borderColor, Color bottomColor) {
        super(xFactor, yFactor, widthFactor, heightFactor);
        this.pipesColor = pipesColor;
        this.borderColor = borderColor;
        this.bottomColor = bottomColor;
    }

    @Override
    public void draw(Graphics2D g, int currWidth, int currHeight) {
        Color oldColor = g.getColor();

        g.setColor(borderColor);
        Stroke oldStroke = g.getStroke();
        g.setStroke(new BasicStroke((float) ((currWidth + currHeight) / 400.0)));
        for (int n = 0; n < 4; n++) {
            g.drawRect(
                    (int) ((xFactor + n * widthFactor / 4)  * currWidth),
                    (int) (yFactor * currHeight),
                    (int) (widthFactor * currWidth / 8),
                    (int) (heightFactor * currHeight));
        }

        g.setColor(pipesColor);
        for (int n = 0; n < 4; n++) {
            g.fillRect(
                    (int) ((xFactor + n * widthFactor / 4)  * currWidth),
                    (int) (yFactor * currHeight),
                    (int) (widthFactor * currWidth / 8),
                    (int) (heightFactor * currHeight));
        }

        g.setColor(bottomColor);
        for (int n = 0; n < 4; n++) {
            g.fillRect(
                    (int) ((xFactor + n * widthFactor / 4)  * currWidth),
                    (int) (yFactor * currHeight),
                    (int) (widthFactor * currWidth / 8),
                    (int) (heightFactor * currHeight / 4));
        }

        g.setColor(oldColor);
        g.setStroke(oldStroke);
    }
}
