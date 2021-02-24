package de.gurkenlabs.litiengine;

import de.gurkenlabs.litiengine.Direction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DirectionTests {
    private Direction directionTest;
    @Test
    public void fromAngleTest(){
        double[] angle = new double[5];
        Direction[] angleTest = new Direction[5];
        angle[0] = 22.5;
        angle[1] = 90;
        angle[2] = 180;
        angle[3] = 270;
        angle[4] = 337.5;
        angleTest[0] = Direction.fromAngle(angle[0]);
        angleTest[1] = Direction.fromAngle(angle[1]);
        angleTest[2] = Direction.fromAngle(angle[2]);
        angleTest[3] = Direction.fromAngle(angle[3]);
        angleTest[4] = Direction.fromAngle(angle[4]);

        assertEquals(Direction.getDirection(0),angleTest[0]);
        assertEquals(Direction.getDirection(1),angleTest[1]);
        assertEquals(Direction.getDirection(2),angleTest[2]);
        assertEquals(Direction.getDirection(3),angleTest[3]);
        assertEquals(Direction.getDirection(0),angleTest[4]);
    }
        
}
