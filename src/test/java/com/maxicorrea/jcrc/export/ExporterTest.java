package com.maxicorrea.jcrc.export;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.junit.Test;
import com.maxicorrea.jcrc.models.JCrc;

public class ExporterTest {

  @Test
  public void shouldInvokeYourFormatObjectToPerformTheExport() {
    Format format = mock(Format.class);
    JCrc model = mock(JCrc.class);
    Exporter exporter = new Exporter(format);
    exporter.exportToString(model);
    verify(format).exportToString(model);
  }

}
