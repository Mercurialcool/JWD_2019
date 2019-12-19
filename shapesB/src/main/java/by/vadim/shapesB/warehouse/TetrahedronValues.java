package by.vadim.shapesB.warehouse;

import by.vadim.shapesB.entity.Point;


public class TetrahedronValues {
    private Point apex;
    private Point basePoint1;
    private Point basePoint2;
    private Point basePoint3;
    private double volume;
    private double surfaceArea;
    private double perimeter;

    public Point getApex() {
        return apex;
    }

    public void setApex(Point apex) {
        this.apex = apex;
    }

    public Point getBasePoint1() {
        return basePoint1;
    }

    public void setBasePoint1(Point basePoint1) {
        this.basePoint1 = basePoint1;
    }

    public Point getBasePoint2() {
        return basePoint2;
    }

    public void setBasePoint2(Point basePoint2) {
        this.basePoint2 = basePoint2;
    }

    public Point getBasePoint3() {
        return basePoint3;
    }

    public void setBasePoint3(Point basePoint3) {
        this.basePoint3 = basePoint3;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }
}
