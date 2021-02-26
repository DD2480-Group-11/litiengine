package de.gurkenlabs.litiengine.util.geom;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class Vector2DTest {
    /**
     * Test dotProduct in Vector2D class
     */
    @Test
    public void dotProductTest(){
        Vector2D v1 = new Vector2D(1,2);
        Vector2D v2 = new Vector2D(3,4);    
        assertEquals(11, v1.dotProduct(v2),0.001);
    }
    public void addTest(){
        Vector2D v1 = new Vector2D(1,2);
        Vector2D v2 = new Vector2D(3,4);
        Vector2D v3 = new Vector2D(4,6);
        boolean isTrue = v3==v1.add(v2);
        assertTrue(isTrue);

    }
}