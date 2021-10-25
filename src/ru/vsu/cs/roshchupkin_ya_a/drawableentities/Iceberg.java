package ru.vsu.cs.roshchupkin_ya_a.drawableentities;

import java.awt.*;

public class Iceberg extends DrawableEntity {
    private final double[] xPointFactors = {
            xFactor + 0.6 * widthFactor,
            xFactor + 0.8 * widthFactor,
            xFactor + widthFactor,
            xFactor + 0.9 * widthFactor,
            xFactor + 0.2 * widthFactor,
            xFactor};
    private final double[] yPointFactors = {
            yFactor,
            yFactor + 0.4 * heightFactor,
            yFactor + 0.6 * heightFactor,
            yFactor + heightFactor,
            yFactor + heightFactor,
            yFactor + 0.5 * heightFactor};

    private final Color borderColor;
    private final Color insideColor;

    public Iceberg(double xFactor, double yFactor, double widthFactor, double heightFactor, Color borderColor, Color insideColor) {
        super(xFactor, yFactor, widthFactor, heightFactor);
        this.borderColor = borderColor;
        this.insideColor = insideColor;
    }

    @Override
    public void draw(Graphics2D g, int currWidth, int currHeight) {
        Color oldColor = g.getColor();
        Stroke oldStroke = g.getStroke();

        g.setStroke(new BasicStroke((float) ((currWidth + currHeight) / 400.0)));

        int[] xPoints = calculateXPoints(currWidth);
        int[] yPoints = calculateYPoints(currHeight);

        g.setColor(insideColor);
        g.fillPolygon(xPoints, yPoints, xPointFactors.length);
        g.setColor(borderColor);
        g.drawPolygon(xPoints, yPoints, xPointFactors.length);

        g.setColor(insideColor);
        for(int n = 0; n < 6; n++){
            g.fillArc(
                    (int) ((xPointFactors[4] + 0.118 * n * widthFactor - 0.002) * currWidth),
                    (int) (yPointFactors[3] * currHeight * 0.92),
                    (int) (0.13 * currWidth * widthFactor),
                    (int) (0.18 * heightFactor * currHeight),
                    -30, -120);
        }
        g.setColor(borderColor);
        for(int n = 0; n < 6; n++){
            g.drawArc(
                    (int) ((xPointFactors[4] + 0.118 * n * widthFactor - 0.002) * currWidth),
                    (int) (yPointFactors[3] * currHeight * 0.92),
                    (int) (0.13 * currWidth * widthFactor),
                    (int) (0.18 * heightFactor * currHeight),
                    -30, -120);
        }

        for (int n = 1; n < 4; n++){
            g.drawLine(xPoints[5], yPoints[5], xPoints[n], yPoints[n]);
        }

        g.setColor(oldColor);
        g.setStroke(oldStroke);
    }

    private int[] calculateXPoints(int width){
        int[] xPoints = new int[xPointFactors.length];
        for (int n = 0; n < xPointFactors.length; n++) {
            xPoints[n] = (int) (xPointFactors[n] * width);
        }
        return xPoints;
    }

    private int[] calculateYPoints(int height){
        int[] yPoints = new int[yPointFactors.length];
        for (int n = 0; n < yPointFactors.length; n++) {
            yPoints[n] = (int) (yPointFactors[n] * height);
        }
        return yPoints;
    }
}
