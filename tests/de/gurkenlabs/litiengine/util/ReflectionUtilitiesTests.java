package de.gurkenlabs.litiengine.util;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class ReflectionUtilitiesTests {
  @Test
  public void testGetField() {
    assertNotNull(ReflectionUtilities.getField(TestImpl.class, "integerField"));
    assertNotNull(ReflectionUtilities.getField(ChildImpl.class, "integerField"));
    assertNull(ReflectionUtilities.getField(TestImpl.class, "nananananan"));
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
  }
  

  private class TestImpl {
    @SuppressWarnings("unused")
    private int integerField;
  }
  
  private class ChildImpl extends TestImpl{
  }
}
