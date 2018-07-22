package com.maxicorrea.jcrc.views.utils;

import static org.junit.Assert.*;
import org.junit.Test;

public class ButtonTest {

  private static final String ANY_TEXT = "ANY_TEXT";
  
  @Test
  public void shouldCreateAButtonWithoutBordersAndWithoutFocusPainted() {
    Button button = new Button(ANY_TEXT);
    assertEquals(ANY_TEXT , button.getJButton().getText());
    assertFalse(button.getJButton().isBorderPainted());
    assertFalse(button.getJButton().isFocusPainted());
  }

}
