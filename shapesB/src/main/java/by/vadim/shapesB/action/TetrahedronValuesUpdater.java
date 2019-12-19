package by.vadim.shapesB.action;

import by.vadim.shapesB.entity.Point;
import by.vadim.shapesB.entity.Tetrahedron;
import by.vadim.shapesB.exeption.LessThanZeroException;


import java.util.stream.DoubleStream;

public class TetrahedronValuesUpdater {

    public double definePerimeter(Tetrahedron tetrahedron) {
        PointActoin pointActoin = new PointActoin();
        double edgeSize[] = new double[6];

        edgeSize[0] = pointActoin.getDistanse(tetrahedron.getBaseVertex1(), tetrahedron.getBaseVertex2());
        edgeSize[1] = pointActoin.getDistanse(tetrahedron.getBaseVertex1(), tetrahedron.getBaseVertex3());
        edgeSize[2] = pointActoin.getDistanse(tetrahedron.getBaseVertex2(), tetrahedron.getBaseVertex3());
        edgeSize[3] = pointActoin.getDistanse(tetrahedron.getApex(), tetrahedron.getBaseVertex1());
        edgeSize[4] = pointActoin.getDistanse(tetrahedron.getApex(), tetrahedron.getBaseVertex2());
        edgeSize[5] = pointActoin.getDistanse(tetrahedron.getApex(), tetrahedron.getBaseVertex3());
        return DoubleStream.of(edgeSize).sum();
    }

    public double defineSurfaceArea(Tetrahedron tetrahedron) {
        double surfaceArea[] = new double[4];
        surfaceArea[0] = defineTriangleArea(tetrahedron.getBaseVertex1(), tetrahedron.getBaseVertex2(), tetrahedron.getBaseVertex3());
        surfaceArea[1] = defineTriangleArea(tetrahedron.getBaseVertex1(), tetrahedron.getBaseVertex2(), tetrahedron.getApex());
        surfaceArea[2] = defineTriangleArea(tetrahedron.getBaseVertex2(), tetrahedron.getBaseVertex3(), tetrahedron.getApex());
        surfaceArea[3] = defineTriangleArea(tetrahedron.getBaseVertex1(), tetrahedron.getBaseVertex3(), tetrahedron.getApex());
        return DoubleStream.of(surfaceArea).sum();
    }
    public double defineVolume(Tetrahedron tetrahedron) throws LessThanZeroException {
      double baseArea= defineTriangleArea(tetrahedron.getBaseVertex1(), tetrahedron.getBaseVertex2(), tetrahedron.getBaseVertex3());
      double high=tetrahedron.getApex().getZ()-tetrahedron.getBaseVertex1().getZ();
      double result=high*baseArea/3.0;
        if(result==0){
            throw new LessThanZeroException("Invalid shape's height");
        }
      return result;
    }

    public double defineTriangleArea(Point point1, Point point2, Point point3) {
        double aX = point1.getX() - point2.getX();
        double aY = point1.getY() - point2.getY();
        double aZ = point1.getZ() - point2.getZ();
        double bX = point1.getX() - point3.getX();
        double bY = point1.getY() - point3.getY();
        double bZ = point1.getZ() - point3.getZ();
        double resultVectorX = aY * bZ - aZ * bY;
        double resultVectorY = aZ * bX - aX * bZ;
        double resultVectorZ = aX * bY - aY * bX;
        return Math.abs(Math.hypot(resultVectorZ, Math.hypot(resultVectorX, resultVectorY)) / 2.0);
    }

}
