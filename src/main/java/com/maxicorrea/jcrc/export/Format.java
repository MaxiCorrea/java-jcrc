package com.maxicorrea.jcrc.export;

import com.maxicorrea.jcrc.models.JCrc;

public interface Format {

  String getName();
  
  String exportToString(JCrc model);

}
