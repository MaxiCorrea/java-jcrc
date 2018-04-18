package com.maxicorrea.jcrc.print;

import com.maxicorrea.jcrc.models.JCrc;

public class Printer {

  public static Printer create(PrintType printType) {
    return new Printer(printType.getFormat());
  }

  private Format format;

  Printer(Format format) {
    this.format = format;
  }

  public void print(JCrc model, String location) throws Exception {
    format.print(model, location);
  }

}
