package ru.khasang.rgbcircles;

/**
 * Created by Oleksandr on 30/11/2015.
 */
public class SimpleCircle {

    protected int x;
    protected int y;
    protected int radius;
    private int color;

    public SimpleCircle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getColor() {
        return this.color;
    }

    public SimpleCircle getCirceArea() {
        return new SimpleCircle(x, y, radius*3);
    }

    public boolean isInteresect(SimpleCircle circle) {
        return radius + circle.radius >= Math.sqrt(Math.pow(x-circle.x, 2) + Math.pow(y - circle.y,2));
        //вфівфі
    }
}
