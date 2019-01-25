package com.ch.myr.validator.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ValidatorUtilsTest {

  @Test
  public void getErrorCode_ShortNameIsNull() {
    String shortName = null;
    String errorCode = ValidatorUtils.getErrorCode(shortName, "address", "NotNull");
    assertEquals("ADDRESS_NOTNULL_ERROR", errorCode);
  }
  
  @Test
  public void getErrorCode_ShortNameNotNull() {
    String shortName = "CCC";
    String errorCode = ValidatorUtils.getErrorCode(shortName, "address", "NotNull");
    assertEquals("CCC_ADDRESS_NOTNULL_ERROR", errorCode);
  }

  @Test
  public void getClassName_OnlyClassName() {
    String fullName="Validator";
    String className = ValidatorUtils.getClassName(fullName);
    assertEquals(fullName, className);
  }
  
  @Test
  public void getClassName_WithPackageClassName() {
    String fullName="com.ch.myr.util.Validator";
    String className = ValidatorUtils.getClassName(fullName);
    assertEquals("Validator", className);
  }
}
