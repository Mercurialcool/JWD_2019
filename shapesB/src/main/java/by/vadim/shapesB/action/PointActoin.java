package by.vadim.shapesB.action;

import by.vadim.shapesB.entity.Point;

public class PointActoin {
    public double getDistanse(Point point1,Point point2){
        double planeDistance=Math.hypot(point1.getX()-point2.getX(),point1.getY()-point2.getY());
        return Math.hypot(planeDistance,point1.getZ()-point2.getZ());

    }
    public double getDifferenceX(Point point1,Point point2){
        return point1.getX()-point2.getX();
    }
    public double getDifferenceY(Point point1,Point point2){
        return point1.getY()-point2.getY();
    }
    public double getDifferenceZ(Point point1,Point point2){
        return point1.getZ()-point2.getZ();
    }
}
