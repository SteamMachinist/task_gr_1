package ru.vsu.cs.roshchupkin_ya_a.drawableentities;

import ru.vsu.cs.roshchupkin_ya_a.utils.RandomUtils;

import java.awt.*;

public class WavyOcean extends DrawableEntity {
    private final Color color1;
    private final Color color2;
    private final Color waveColor;

    private final int wavesNumber = RandomUtils.getRandomIntBetween(60, 90);

    private final double[] rndX = RandomUtils.getRandomArray(wavesNumber, 0, widthFactor);
    private final double[] rndY = RandomUtils.getRandomArray(wavesNumber, 0, heightFactor);

    private final double[] rndWidth = RandomUtils.getRandomArray(wavesNumber, 0.01, 0.06);
    private final double[] rndHeight = RandomUtils.getRandomArray(wavesNumber, 0.01, 0.06);

    private final int[] startAngle = RandomUtils.getRandomArray(wavesNumber, -60, 60);
    private final int[] arcAngle = RandomUtils.getRandomArray(wavesNumber, -120, 120);

    public WavyOcean(double xFactor, double yFactor, double widthFactor, double heightFactor,
                     Color color1, Color color2, Color waveColor) {
        super(xFactor, yFactor, widthFactor, heightFactor);
        this.color1 = color1;
        this.color2 = color2;
        this.waveColor = waveColor;
    }

    @Override
    public void draw(Graphics2D g, int currWidth, int currHeight) {
        Color oldColor = g.getColor();

        drawOcean(g, currWidth, currHeight);
        drawRandomWaves(g, currWidth, currHeight);

        g.setColor(oldColor);
    }

    private void drawOcean(Graphics2D g, int currWidth, int currHeight) {
        g.setPaint(new GradientPaint(
                (float) xFactor, (float) currHeight, color1,
                (float) (currHeight * 0.8), (float) (-currHeight * 1.3), color2));

        g.fillRect(
                (int) (currWidth * xFactor),
                (int) (currHeight * yFactor),
                (int) (currWidth * widthFactor),
                (int) (currHeight * heightFactor));
    }

    private void drawRandomWaves(Graphics2D g, int currWidth, int currHeight) {
        Stroke oldStroke = g.getStroke();

        g.setStroke(new BasicStroke((float) (Math.max(currWidth, currHeight) / 450)));
        g.setColor(waveColor);

        for (int n = 0; n < wavesNumber; n++) {
            g.drawArc(
                    (int) (currWidth * (xFactor + rndX[n])),
                    (int) (currHeight * (yFactor + rndY[n])),
                    (int) (currWidth * rndWidth[n] * widthFactor),
                    (int) (currHeight * rndHeight[n] * heightFactor),
                    startAngle[n], arcAngle[n]);
        }

        g.setStroke(oldStroke);
    }
}
