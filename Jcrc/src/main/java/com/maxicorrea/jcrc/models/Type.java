package com.maxicorrea.jcrc.models;

public enum Type {

  NORMAL {
    @Override
    public String toString() {
      return "Normal";
    }
  },
  ABSTRACT {
    @Override
    public String toString() {
      return "Abstract";
    }
  },
  INTERFACE {
    @Override
    public String toString() {
      return "Interface";
    }
  };

}
