package com.maxicorrea.jcrc.print;

import static org.junit.Assert.*;
import org.junit.Test;

public class PrintExceptionTest {

  @Test
  public void shouldIndicateAMessageAboutTheError() {
    PrintException exception = new PrintException();
    assertEquals(PrintException.ERROR_MESSAGE , exception.getMessage());
  }

}
