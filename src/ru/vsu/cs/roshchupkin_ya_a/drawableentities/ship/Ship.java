package ru.vsu.cs.roshchupkin_ya_a.drawableentities.ship;

import ru.vsu.cs.roshchupkin_ya_a.drawableentities.ComplexDrawableEntity;

import java.awt.*;

public class Ship extends ComplexDrawableEntity {
    private final ShipBottom bottom;
    private final double bottomXFactor = xFactor;
    private final double bottomYFactor = yFactor + 0.6 * heightFactor;
    private final double bottomWidthFactor = widthFactor;
    private final double bottomHeightFactor = 0.4 * heightFactor;

    private final ShipPipes pipes;
    private final double pipeXFactor = xFactor + 0.4 * widthFactor;
    private final double pipeYFactor = yFactor;
    private final double pipeWidthFactor = 0.5 * widthFactor;
    private final double pipeHeightFactor = 0.6 * heightFactor;

    private final ShipDeck deck;
    private final double deckXFactor = xFactor + 0.2 * widthFactor;
    private final double deckYFactor = yFactor + 0.3 * heightFactor;
    private final double deckWidthFactor = 0.7 * widthFactor;
    private final double deckHeightFactor = 0.3 * heightFactor;

    public Ship(double xFactor, double yFactor, double widthFactor, double heightFactor,
                Color bottomColor, Color borderColor, Color deckColor, Color pipesColor,
                Color windowColor, Color nameColor, String name) {
        super(xFactor, yFactor, widthFactor, heightFactor);

        this.bottom = new ShipBottom(bottomXFactor, bottomYFactor, bottomWidthFactor, bottomHeightFactor,
                bottomColor, borderColor, windowColor, nameColor, name);
        drawableEntities.add(bottom);

        this.pipes = new ShipPipes(pipeXFactor, pipeYFactor, pipeWidthFactor, pipeHeightFactor,
                pipesColor, borderColor, bottomColor);
        drawableEntities.add(pipes);

        this.deck = new ShipDeck(deckXFactor, deckYFactor, deckWidthFactor, deckHeightFactor,
                deckColor, windowColor, borderColor);
        drawableEntities.add(deck);
    }
}
