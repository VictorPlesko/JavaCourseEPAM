package com.plesko.lesson3.entity;

public enum ColorBall {

    RED("Red"),
    ORANGE("Orange"),
    YELLOW("Yellow"),
    GREEN("Green"),
    BLUE("Blue"),
    VIOLET("Violet");

    private String colorTitle;

    ColorBall(String colorTitle) {
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
