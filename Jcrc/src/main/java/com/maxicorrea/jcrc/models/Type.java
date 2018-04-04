package com.maxicorrea.jcrc.models;

public enum Type {

  NORMAL, ABSTRACT, INTERFACE;

  @Override
  public String toString() {
    if (this == NORMAL) {
      return "Normal";
    }
    if (this == ABSTRACT) {
      return "Abstract";
    }
    if (this == INTERFACE) {
      return "Interface";
    }
    return "";
  }

}
