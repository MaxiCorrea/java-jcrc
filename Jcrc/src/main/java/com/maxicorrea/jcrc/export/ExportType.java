package com.maxicorrea.jcrc.export;

import com.maxicorrea.jcrc.export.json.JSONFormat;

public enum ExportType {

  JSON {
    @Override
    Format getFormat() {
      return new JSONFormat();
    }
  };

  abstract Format getFormat();

}
