package com.maxicorrea.jcrc.export.json;

import static org.junit.Assert.*;
import org.junit.Test;

public class JSONFormatTest {

  @Test
  public void shouldReturnTheNameOfTheFormat() {
    JSONFormat format = new JSONFormat();
    assertEquals(JSONFormat.NAME_FORMAT , format.getName());
  }

}
