package de.gurkenlabs.litiengine.util;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import de.gurkenlabs.litiengine.util.geom.Vector2D;
import java.util.Collection;
import java.util.Collections;
import java.lang.reflect.Method;
import java.util.ArrayList;
import de.gurkenlabs.litiengine.entities.Material;


public class ReflectionUtilitiesTests {
  @Test
  public void testGetField() {
    assertNotNull(ReflectionUtilities.getField(TestImpl.class, "integerField"));
    assertNotNull(ReflectionUtilities.getField(ChildImpl.class, "integerField"));
    assertNull(ReflectionUtilities.getField(TestImpl.class, "nananananan"));
  }


  /**
   * Test getSetters-funktion
   */
  @Test
  public void testGetSetters() {
    Collection<Method> result =  ReflectionUtilities.getSetters(Vector2D.class);
    Collection<Method> expected = new ArrayList<>();

    Method[] a = result.toArray(new Method[result.size()]);
    Method[] b = expected.toArray(new Method[expected.size()]);

    assertArrayEquals(a, b);
    
  }

  /**
   * Test setting field values va setFieldValue function.
   * Could not get the string Array field to work, possible bug in code.
   */
  @Test
  public void testSetFieldValue(){
    TestClass tc = new TestClass();

    ReflectionUtilities.setFieldValue(TestClass.class, tc, "integerField", "10");
    ReflectionUtilities.setFieldValue(TestClass.class, tc, "booleanField", "true");
    ReflectionUtilities.setFieldValue(TestClass.class, tc, "floatField", "3.6f");
    ReflectionUtilities.setFieldValue(TestClass.class, tc, "doubleField", "4.2");
    ReflectionUtilities.setFieldValue(TestClass.class, tc, "shortField", "5");
    ReflectionUtilities.setFieldValue(TestClass.class, tc, "byteField", "12");
    ReflectionUtilities.setFieldValue(TestClass.class, tc, "longField", "23");
    ReflectionUtilities.setFieldValue(TestClass.class, tc, "stringField", "ten");

    assertEquals(tc.integerField,10);
    assertEquals(tc.booleanField,true);
    assertEquals(tc.floatField,3.6f);
    assertEquals(tc.doubleField,4.2);
    assertEquals(tc.shortField,5);
    assertEquals(tc.byteField,12);
    assertEquals(tc.longField,23);
    assertEquals(tc.stringField,"ten");
  }

  /**
   * Test setting non-existing field and setting final field
   */
  @Test
  public void testBadSetFieldValue(){
    TestClass tc = new TestClass();

    //Test non-existing field
    boolean result = ReflectionUtilities.setFieldValue(TestClass.class, tc, "nonExistingField", "10");
    assertFalse(result);

    //Test final field
    result = ReflectionUtilities.setFieldValue(TestClass.class, tc, "finalIntField", "10");
    assertFalse(result);

  }


  /**
   * Test material field
   */
  @Test
  public void testSetFieldValueMaterial(){
    TestClass tc = new TestClass();
    Material expected = new Material("FLESH");
  
    boolean result = ReflectionUtilities.setFieldValue(TestClass.class, tc, "materialField", "FLESH");
    System.out.println("RESULT:" + result);
    System.out.println("FIELD: " + tc.materialField);
    System.out.println("Expected: " + expected);
    assertEquals(tc.materialField, expected);
  
  }

  /**
   * Testclass for testSetFieldValue and testBadSetFieldValue
   */
  private class TestClass {
    @SuppressWarnings("unused")
    public int integerField;
    public boolean booleanField;
    public float floatField;
    public double doubleField;
    public short shortField;
    public byte byteField;
    public long longField;
    public String stringField;
    public String[] stringArrayField;
    
    public final int finalIntField = 20;

    public Vector2D vectorField;
    public Material materialField;
  }
  

  private class TestImpl {
    @SuppressWarnings("unused")
    private int integerField;
  }
  
  private class ChildImpl extends TestImpl{
  }
}
