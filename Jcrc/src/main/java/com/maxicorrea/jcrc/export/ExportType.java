package com.maxicorrea.jcrc.export;

public enum ExportType {

  JSON {
    @Override
    Format getFormat() {
      return new JSONFormat();
    }
  };

  abstract Format getFormat();

}
