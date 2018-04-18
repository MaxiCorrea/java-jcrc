package com.maxicorrea.jcrc.print;

import com.maxicorrea.jcrc.print.pdf.PDFFormat;

public enum PrintType {

  PDF {
    @Override
    Format getFormat() {
      return new PDFFormat();
    }
  };
  
  abstract Format getFormat();
  
}
