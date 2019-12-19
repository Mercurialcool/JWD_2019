package by.vadim.shapesB.entity;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TetrahedronTest {
    @Test
    public void equalTest(){
        Tetrahedron tetrahedron1 = new Tetrahedron(1,
                new Point(0, 0, 1), new Point(1, 0, 0), new Point(0, 1, 0), new Point(0, 0, 0));
        Tetrahedron tetrahedron2 = new Tetrahedron(1,
                new Point(0, 0, 1), new Point(1, 0, 0), new Point(0, 1, 0), new Point(0, 0, 0));
        Assert.assertTrue(tetrahedron1.equals(tetrahedron2));
    }
    @Test
    public void notEqualTest(){
        Tetrahedron tetrahedron1 = new Tetrahedron(1,
                new Point(0, 0, 2), new Point(1, 0, 0), new Point(0, 1, 0), new Point(0, 0, 0));
        Tetrahedron tetrahedron2 = new Tetrahedron(1,
                new Point(0, 0, 1), new Point(1, 0, 0), new Point(0, 1, 0), new Point(0, 0, 0));
        Assert.assertFalse(tetrahedron1.equals(tetrahedron2));
    }
}
