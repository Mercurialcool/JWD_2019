package by.vadim.shapesB.entity;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {

    @Test
    public void equalTest() {
        Point point1 = new Point(0, 1, 3);
        Point point2 = new Point(0, 1, 3);
        Assert.assertTrue(point1.equals(point2));
    }


}
