package by.vadim.shapesB.action;

import by.vadim.shapesB.entity.Tetrahedron;

public class SplitAction {
    public double defineXoYCutArea(Tetrahedron tetrahedron){
        TetrahedronValuesUpdater tetrahedronValuesUpdater =new TetrahedronValuesUpdater();
        double baseArea= tetrahedronValuesUpdater.defineTriangleArea(tetrahedron.getBaseVertex1(),tetrahedron.getBaseVertex2(),tetrahedron.getBaseVertex3());
        double similarCoefficent=Math.abs((tetrahedron.getApex().getZ())/(tetrahedron.getApex().getZ()-tetrahedron.getBaseVertex1().getZ()));
        return baseArea*similarCoefficent;
    }
    public  boolean isCutXoY(Tetrahedron tetrahedron){
        return Math.signum(tetrahedron.getApex().getZ())!=Math.signum(tetrahedron.getBaseVertex1().getZ());

    }
    public  boolean isCutXoZ(Tetrahedron tetrahedron){
        double maxY=Math.max(Math.max(tetrahedron.getBaseVertex1().getY(),tetrahedron.getBaseVertex2().getY()),tetrahedron.getBaseVertex3().getY());
        double minY=Math.min(Math.min(tetrahedron.getBaseVertex1().getY(),tetrahedron.getBaseVertex2().getY()),tetrahedron.getBaseVertex3().getY());
        return Math.signum(maxY)!=Math.signum(minY);

    }
    public  boolean isCutYoZ(Tetrahedron tetrahedron){
        double maxX=Math.max(Math.max(tetrahedron.getBaseVertex1().getX(),tetrahedron.getBaseVertex2().getX()),tetrahedron.getBaseVertex3().getX());
        double minX=Math.min(Math.min(tetrahedron.getBaseVertex1().getX(),tetrahedron.getBaseVertex2().getX()),tetrahedron.getBaseVertex3().getX());
        return Math.signum(maxX)!=Math.signum(minX);

    }
}
