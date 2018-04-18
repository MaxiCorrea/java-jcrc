package com.maxicorrea.jcrc.print.pdf;

import static org.junit.Assert.*;
import org.junit.Test;

public class PDFFormatTest {

  @Test
  public void shouldAddTheExtensionToTheFileIfItDoesNot() {
    PDFFormat pdfFormat = new PDFFormat();
    assertEquals("file.pdf" , pdfFormat.addExtension("file.pdf"));
    assertEquals("file.pdf" , pdfFormat.addExtension("file"));
  }

}
