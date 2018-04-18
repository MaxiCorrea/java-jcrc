package com.maxicorrea.jcrc.export.json;

import static org.junit.Assert.*;
import org.junit.Test;
import com.maxicorrea.jcrc.models.CardBuilder;
import com.maxicorrea.jcrc.models.JCrc;

public class JSONFormatTest {

  @Test
  public void shouldReturnTheNameOfTheFormat() {
    JSONFormat format = new JSONFormat();
    assertEquals(JSONFormat.NAME_FORMAT , format.getName());
  }

  @Test
  public void shouldReturnARepresentationOfTheModel() {
    JCrc crc = new JCrc();
    JSONFormat format = new JSONFormat();
    String output = format.exportToString(crc);
    assertNotNull(output);
    assertFalse(output.isEmpty());
    crc.addNewCard( new CardBuilder().build());
    output = format.exportToString(crc);
    assertNotNull(output);
    assertFalse(output.isEmpty());
  }
  
}
