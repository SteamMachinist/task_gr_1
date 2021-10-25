package ru.vsu.cs.roshchupkin_ya_a.drawableentities;

import ru.vsu.cs.roshchupkin_ya_a.drawableentities.ship.Ship;

import java.awt.*;

public class World extends ComplexDrawableEntity {
    private final StarrySky sky;
    private final double skyXFactor = xFactor;
    private final double skyYFactor = yFactor;
    private final double skyWidthFactor = widthFactor;
    private final double skyHeightFactor = 0.6 * heightFactor;
    private final Color skyColor = new Color(17, 27, 35);
    private final Color starsColor = new Color(197, 175, 252);

    private final Moon moon;
    private final double moonXFactor = xFactor + 0.85 * widthFactor;
    private final double moonYFactor = yFactor + 0.15 * heightFactor;
    private final double moonSizeFactor = 0.06 * (widthFactor + heightFactor) / 2;
    private final Color moonColor = new Color(245, 245, 129);

    private final WavyOcean ocean;
    private final double oceanXFactor = xFactor;
    private final double oceanYFactor = yFactor + 0.6 * heightFactor;
    private final double oceanWidthFactor = widthFactor;
    private final double oceanHeightFactor = 0.4 * heightFactor;
    private final Color oceanColor1 = new Color(11, 11, 37);
    private final Color oceanColor2 = new Color(159, 224, 255);
    private final Color waveColor = new Color(227, 242, 255);

    private final Ship ship;
    private final double shipXFactor = xFactor + 0.33 * widthFactor;
    private final double shipYFactor = yFactor + 0.25 * heightFactor;
    private final double shipWidthFactor = 0.6 * widthFactor;
    private final double shipHeightFactor = 0.5 * heightFactor;
    private final Color shipBottomColor = new Color(3, 46, 72);
    private final Color shipBorderColor = new Color(2, 16, 26);
    private final Color shipDeckColor = new Color(241, 241, 245);
    private final Color shipPipesColor = new Color(157, 72, 82);
    private final Color shipWindowColor = new Color(239, 181, 84);
    //private final Color shipSmokeColor = new Color(37, 36, 36, 77);
    private final Color shipNameColor = new Color(255, 255, 255);
    private final String shipName = "Titanic";

    private final Iceberg iceberg;
    private final double icebergXFactor = xFactor + 0.02 * widthFactor;
    private final double icebergYFactor = yFactor + 0.35 * heightFactor;
    private final double icebergWidthFactor = 0.25 * widthFactor;
    private final double icebergHeightFactor = 0.5 * heightFactor;
    private final Color icebergBorderColor = new Color(0, 169, 169, 255);
    private final Color icebergInsideColor = new Color(141, 232, 236, 255);


    public World(double xFactor, double yFactor, double widthFactor, double heightFactor) {
        super(xFactor, yFactor, widthFactor, heightFactor);

        this.sky = new StarrySky(skyXFactor, skyYFactor, skyWidthFactor, skyHeightFactor, skyColor, starsColor);
        drawableEntities.add(sky);

        this.moon = new Moon(moonXFactor, moonYFactor, moonSizeFactor, moonColor, skyColor);
        drawableEntities.add(moon);

        this.ocean = new WavyOcean(oceanXFactor, oceanYFactor, oceanWidthFactor, oceanHeightFactor,
                oceanColor1, oceanColor2, waveColor);
        drawableEntities.add(ocean);

       this.ship = new Ship(shipXFactor, shipYFactor, shipWidthFactor, shipHeightFactor,
               shipBottomColor, shipBorderColor, shipDeckColor, shipPipesColor,
               shipWindowColor, shipNameColor, shipName);
        drawableEntities.add(ship);

        this.iceberg = new Iceberg(icebergXFactor, icebergYFactor, icebergWidthFactor, icebergHeightFactor,
                icebergBorderColor, icebergInsideColor);
        drawableEntities.add(iceberg);
    }
}
