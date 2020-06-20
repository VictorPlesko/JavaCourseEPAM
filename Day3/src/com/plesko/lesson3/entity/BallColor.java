package com.plesko.lesson3.entity;

public enum BallColor {

    RED("Red"),
    ORANGE("Orange"),
    YELLOW("Yellow"),
    GREEN("Green"),
    BLUE("Blue"),
    VIOLET("Violet");

    private String colorTitle;

    BallColor(String colorTitle) {
        this.colorTitle = colorTitle;
    }

    public String getColorTitle() {
        return colorTitle;
    }

    @Override
    public String toString() {
        return String.format("Ball color: %s", colorTitle);
    }
}
