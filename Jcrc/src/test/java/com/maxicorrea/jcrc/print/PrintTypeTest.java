package com.maxicorrea.jcrc.print;

import static org.junit.Assert.*;
import org.junit.Test;
import com.maxicorrea.jcrc.print.pdf.PDFFormat;

public class PrintTypeTest {

  @Test
  public void thePDFenumerationShouldReturnAPDFFormatObject() {
    Format format = PrintType.PDF.getFormat();
    assertNotNull(format);
    assertTrue(format instanceof PDFFormat);
  }

}
