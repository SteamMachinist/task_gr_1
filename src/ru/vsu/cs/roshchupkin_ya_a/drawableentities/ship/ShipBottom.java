package ru.vsu.cs.roshchupkin_ya_a.drawableentities.ship;

import ru.vsu.cs.roshchupkin_ya_a.drawableentities.DrawableEntity;

import java.awt.*;

public class ShipBottom extends DrawableEntity {
    private final double[] xPointFactors = {
            xFactor,
            xFactor + 0.2 * widthFactor,
            xFactor + 0.95 * widthFactor,
            xFactor + widthFactor};
    private final double[] yPointFactors = {
            yFactor,
            yFactor + 0.75 * heightFactor,
            yFactor + 0.75 * heightFactor,
            yFactor};
    private final int windowsNumber = 14;

    private final Color color;
    private final Color borderColor;
    private final Color windowColor;
    private final Color nameColor;
    private final String name;

    public ShipBottom(double xFactor, double yFactor, double widthFactor, double heightFactor,
                      Color color, Color borderColor, Color windowColor, Color nameColor, String name) {
        super(xFactor, yFactor, widthFactor, heightFactor);
        this.color = color;
        this.borderColor = borderColor;
        this.windowColor = windowColor;
        this.nameColor = nameColor;
        this.name = name;
    }

    @Override
    public void draw(Graphics2D g, int currWidth, int currHeight) {
        Color oldColor = g.getColor();
        drawHull(g, currWidth, currHeight);
        drawName(g, currWidth, currHeight);
        drawWindows(g, currWidth, currHeight);
        g.setColor(oldColor);
    }

    private void drawHull(Graphics2D g, int currWidth, int currHeight){
        g.setColor(borderColor);
        Stroke oldStroke = g.getStroke();
        g.setStroke(new BasicStroke((float) ((currWidth + currHeight) / 400.0)));
        for(int n = 0; n < 10; n++){
            g.drawArc(
                    (int) ((xPointFactors[1] + 0.075 * n * widthFactor - 0.003) * currWidth),
                    (int) (yPointFactors[1] * currHeight * 0.945),
                    (int) (0.087 * currWidth * widthFactor),
                    (int) (0.25 * heightFactor * currHeight),
                    -30, -120);
        }
        g.drawPolygon(calculateXPoints(currWidth), calculateYPoints(currHeight), xPointFactors.length);

        g.setColor(color);
        g.fillPolygon(calculateXPoints(currWidth), calculateYPoints(currHeight), xPointFactors.length);
        for(int n = 0; n < 10; n++){
            g.fillArc(
                    (int) ((xPointFactors[1] + 0.075 * n * widthFactor - 0.003) * currWidth),
                    (int) (yPointFactors[1] * currHeight * 0.945),
                    (int) (0.087 * currWidth * widthFactor),
                    (int) (0.25 * heightFactor * currHeight),
                    -30, -120);
        }
        g.setStroke(oldStroke);
    }

    private void drawWindows(Graphics2D g, int currWidth, int currHeight){
        g.setColor(windowColor);
        for(int n = 0; n < windowsNumber; n++){
            g.fillOval(
                    (int) (calculateXPoints(currWidth)[0] + (currWidth * widthFactor / 20 * n ) + 2 * widthFactor * currWidth * 0.12),
                    (int) (calculateYPoints(currHeight)[0] + (heightFactor * 0.05 * currHeight)),
                    (int) (currWidth * widthFactor / 45),
                    (int) (currHeight * heightFactor / 9));
        }

        for(int n = 0; n < windowsNumber - 1; n++){
            g.fillOval(
                    (int) (calculateXPoints(currWidth)[0] + (currWidth * widthFactor / 20 * n) + 2.22 * widthFactor * currWidth * 0.12),
                    (int) (calculateYPoints(currHeight)[0] + (heightFactor * 0.05 * currHeight) + (currHeight * heightFactor / 6)),
                    (int) (currWidth * widthFactor / 45),
                    (int) (currHeight * heightFactor / 9));
        }
    }

    private void drawName(Graphics2D g, int currWidth, int currHeight){
        g.setFont(new Font(null, Font.PLAIN, (int) ((currWidth + currHeight) * (widthFactor + heightFactor)) / 60));
        g.setColor(nameColor);
        g.drawString(name, (float) (calculateXPoints(currWidth)[0] + widthFactor * currWidth * 0.1),
                (float) (calculateYPoints(currHeight)[0] + heightFactor * currHeight * 0.22));
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
