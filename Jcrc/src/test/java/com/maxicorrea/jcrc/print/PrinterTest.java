package com.maxicorrea.jcrc.print;

import org.junit.Test;
import com.maxicorrea.jcrc.application.AppConfig;
import com.maxicorrea.jcrc.models.JCrc;
import static org.mockito.Mockito.*;
import java.io.File;

public class PrinterTest {

  @Test
  public void shouldInvokeItsInternalFormatObjectToPerformPrinting() throws Exception {
    Format format = mock(Format.class);
    JCrc model = mock(JCrc.class);
    String location = "";
    Printer printer = new Printer(format);
    printer.print(model, location);
    verify(format).print(model, location);
    new File(AppConfig.url("cardjrprint")).delete();
  }

}
