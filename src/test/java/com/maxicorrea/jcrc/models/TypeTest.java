package com.maxicorrea.jcrc.models;

import static org.junit.Assert.*;
import org.junit.Test;

public class TypeTest {

  @Test
  public void shouldReturnHisNameWithTheFirstLetterInCapitalLettersAndTheRestInMinuscule() {
    assertEquals("Abstract", Type.ABSTRACT.toString());
    assertEquals("Interface", Type.INTERFACE.toString());
    assertEquals("Normal", Type.NORMAL.toString());
  }

}
