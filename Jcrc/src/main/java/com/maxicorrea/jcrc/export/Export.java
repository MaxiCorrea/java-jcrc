package com.maxicorrea.jcrc.export;

import com.maxicorrea.jcrc.models.JCrc;

public class Export {

  public static Export create(ExportType type) {
    return new Export(type);
  }

  private Format format;

  private Export(ExportType type) {
    this.format = type.getFormat();
  }

  public String exportToString(JCrc model) {
    return format.exportToString(model);
  }

}
