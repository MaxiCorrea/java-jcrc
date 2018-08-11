package com.maxicorrea.jcrc.print;

public class PrintException extends Exception {
  private static final long serialVersionUID = 1L;

  static final String ERROR_MESSAGE = "Error when printing the cards";
  
  public PrintException() {
    super(ERROR_MESSAGE);
  }
  
}
