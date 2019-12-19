package by.vadim.shapesB.entity;

public class Point {

    private double x;
    private double y;
    private double z;


    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }


    public double getY() {
        return y;
    }

    public void setY(double y) {

        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }


    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Double.hashCode( x);
        result = prime * result + Double.hashCode( y);
        result = prime * result + Double.hashCode( z);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Point otherPoint = (Point) obj;
        return (x == otherPoint.x && y == otherPoint.y && z == otherPoint.z);
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder("@Point");
        toString.append(" x= ");
        toString.append(x);
        toString.append(" y= ");
        toString.append(y);
        toString.append(" z= ");
        toString.append(z);
        return new String(toString);
    }
}
