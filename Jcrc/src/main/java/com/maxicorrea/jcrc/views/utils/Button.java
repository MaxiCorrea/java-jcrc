package com.maxicorrea.jcrc.views.utils;

import javax.swing.JButton;

public class Button extends JButton {
  private static final long serialVersionUID = 1L;

  public Button(String text) {
    super(text);
    setBorderPainted(false);
    setFocusPainted(false);
  }
  
}
