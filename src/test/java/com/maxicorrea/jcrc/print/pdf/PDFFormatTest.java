package com.maxicorrea.jcrc.print.pdf;

import static org.junit.Assert.*;
import org.junit.Test;
import com.maxicorrea.jcrc.models.JCrc;
import com.maxicorrea.jcrc.print.PrintException;

public class PDFFormatTest {

  @Test
  public void shouldAddTheExtensionToTheFileIfItDoesNot() {
    PDFFormat pdfFormat = new PDFFormat();
    assertEquals("file.pdf" , pdfFormat.addExtension("file.pdf"));
    assertEquals("file.pdf" , pdfFormat.addExtension("file"));
  }

  @Test(expected = PrintException.class)
  public void shouldThrowAnExceptionForAnInvalidLocation() throws PrintException {
    PDFFormat format = new PDFFormat();
    format.print( new JCrc(), "/locura/automatica");
  }
  
  
}
