package ru.vsu.cs.roshchupkin_ya_a.drawableentities;

import ru.vsu.cs.roshchupkin_ya_a.utils.RandomUtils;

import java.awt.*;

public class StarrySky extends DrawableEntity {
    private final Color skyColor;
    private final Color starsColor;

    private final int starsNumber = RandomUtils.getRandomIntBetween(60, 110);
    private final double[] rndXStars = RandomUtils.getRandomArray(starsNumber, 0, widthFactor);
    private final double[] rndYStars = RandomUtils.getRandomArray(starsNumber, 0, heightFactor);

    public StarrySky(double xFactor, double yFactor, double widthFactor, double heightFactor, Color skyColor, Color starsColor) {
        super(xFactor, yFactor, widthFactor, heightFactor);
        this.skyColor = skyColor;
        this.starsColor = starsColor;
    }

    @Override
    public void draw(Graphics2D g, int currWidth, int currHeight) {
        Color oldColor = g.getColor();

        drawSky(g, currWidth, currHeight);
        drawRandomStars(g, currWidth, currHeight);

        g.setColor(oldColor);
    }

    private void drawSky(Graphics2D g, int currWidth, int currHeight) {
        g.setColor(skyColor);
        g.fillRect(
                (int) (currWidth * xFactor),
                (int) (currHeight * yFactor),
                (int) (currWidth * widthFactor),
                (int) (currHeight * heightFactor));
    }

    private void drawRandomStars(Graphics2D g, int currWidth, int currHeight) {
        g.setColor(starsColor);
        for (int n = 0; n < starsNumber; n++) {

            g.fillOval(
                    (int) ((xFactor + rndXStars[n]) * currWidth),
                    (int) ((yFactor + rndYStars[n]) * currHeight),
                    (int) calculateStarSize(currWidth, currHeight),
                    (int) calculateStarSize(currWidth, currHeight));
        }
    }

    private double calculateStarSize(int width, int height) {
        return Math.ceil((Math.max(width, height) / 350.0)) + 1;
    }

    private double getCurrentSkyWidth(int currWidth) {
        return currWidth * widthFactor;
    }

    private double getCurrentSkyHeight(int currHeight) {
        return currHeight * heightFactor;
    }
}
