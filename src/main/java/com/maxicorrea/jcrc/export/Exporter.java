package com.maxicorrea.jcrc.export;

import com.maxicorrea.jcrc.models.JCrc;

public class Exporter {

  public static Exporter create(ExportType type) {
    return new Exporter(type.getFormat());
  }

  private Format format;

  Exporter(Format format) {
    this.format = format;
  }

  public String exportToString(JCrc model) {
    return format.exportToString(model);
  }

}
