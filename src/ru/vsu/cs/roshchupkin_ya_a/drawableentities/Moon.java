package ru.vsu.cs.roshchupkin_ya_a.drawableentities;

import ru.vsu.cs.roshchupkin_ya_a.utils.RandomUtils;

import java.awt.*;

public class Moon extends DrawableEntity {
    private final double shadowSizeDifFactor = 0.97;

    private final int moonCoverage = (RandomUtils.getRandomBool() ? -1 : 1) * RandomUtils.getRandomIntBetween(0, 100);

    private final double radiusFactor;
    private final Color color;
    private final Color skyColor;

    public Moon(double xFactor, double yFactor, double radiusFactor, Color color, Color skyColor) {
        super(xFactor, yFactor, radiusFactor, radiusFactor);
        this.radiusFactor = radiusFactor;
        this.color = color;
        this.skyColor = skyColor;
    }

    @Override
    public void draw(Graphics2D g, int currWidth, int currHeight) {
        Color oldColor = g.getColor();

        g.setColor(color);
        g.fillOval(
                (int) (currWidth * xFactor),
                (int) (currHeight * yFactor),
                (int) ((currWidth + currHeight) * radiusFactor),
                (int) ((currWidth + currHeight) * radiusFactor));

        if (moonCoverage != 0) {
            g.setColor(skyColor);
            g.fillOval(
                    (int) (currWidth * calculateXFactorForShadow()),
                    (int) (currHeight * calculateYFactorForShadow()),
                    (int) ((currWidth + currHeight) * radiusFactor * shadowSizeDifFactor),
                    (int) ((currWidth + currHeight) * radiusFactor * shadowSizeDifFactor));
        }

        g.setColor(oldColor);
    }

    private double calculateXFactorForShadow() {
        return xFactor + calculateMoveToCenter()
                + calculateLeftCornerToCenterD(radiusFactor) * calculateCoverageFactor();
    }

    private double calculateYFactorForShadow() {
        return yFactor + calculateMoveToCenter()
                + calculateLeftCornerToCenterD(radiusFactor) * calculateCoverageFactor();
    }

    private double calculateMoveToCenter() {
        return (calculateLeftCornerToCenterD(radiusFactor)
                - calculateLeftCornerToCenterD(radiusFactor * shadowSizeDifFactor));
    }

    private double calculateLeftCornerToCenterD(double r) {
        return Math.sqrt(2 * r * r);
    }

    private double calculateCoverageFactor() {
        return moonCoverage / (double) Math.abs(moonCoverage) * (1 - Math.abs(moonCoverage) / 100.0);
    }
}
