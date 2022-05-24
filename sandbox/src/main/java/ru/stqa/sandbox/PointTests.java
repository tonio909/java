package ru.stqa.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {
    @Test
    public void pointTestEquals() {
        Point point = new Point(2.3556, 3.2464, 4.3907, 5.7832);
        Assert.assertEquals(point.distance(), 1.653051992527761);
    }

    @Test
    public void pointTestNotNull() {
        Point point = new Point(2.3556, 3.2464, 4.3907, 5.7832);
        Assert.assertNotNull(point.distance());
    }

    @Test
    public void pointTestNotEquals() {
        Point point = new Point(2.3556, 3.2464, 4.3907, 5.7832);
        Assert.assertNotEquals(point.distance(), 1);
    }
}
