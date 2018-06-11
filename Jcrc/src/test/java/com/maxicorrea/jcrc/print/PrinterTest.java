package com.maxicorrea.jcrc.print;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.Test;
import com.maxicorrea.jcrc.application.AppConfig;
import com.maxicorrea.jcrc.models.JCrc;

public class PrinterTest {

  @Test
  public void shouldInvokeItsInternalFormatObjectToPerformPrinting() throws Exception {
    Format format = mock(Format.class);
    JCrc model = mock(JCrc.class);
    String location = "";
    Printer printer = new Printer(format);
    printer.print(model, location);
    verify(format).print(model, location);
    Files.delete(Paths.get(AppConfig.url("cardjrprint")));
  }

}
