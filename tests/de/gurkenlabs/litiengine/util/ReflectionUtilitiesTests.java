package de.gurkenlabs.litiengine.util;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;


public class ReflectionUtilitiesTests {
  @Test
  public void testGetField() {
    assertNotNull(ReflectionUtilities.getField(TestImpl.class, "integerField"));
    assertNotNull(ReflectionUtilities.getField(ChildImpl.class, "integerField"));
    assertNull(ReflectionUtilities.getField(TestImpl.class, "nananananan"));
  }

  


  @AfterAll
  public static void printCCsetFieldValue() {
	  int sum = 0;
	  for(int i = 0; i < ReflectionUtilities.CCsetFieldValue.length; ++i) {
		  if(ReflectionUtilities.CCsetFieldValue[i] != 0)
			  sum++;
	  }
	  System.out.println("Code Coverage Count: " + sum);
  }

  private class TestImpl {
    @SuppressWarnings("unused")
    private int integerField;
  }
  
  private class ChildImpl extends TestImpl{
  }
}
