package com.maxicorrea.jcrc.print;

import com.maxicorrea.jcrc.models.JCrc;

public interface Format {

  void print(JCrc model , String location) throws PrintException;
  
}
