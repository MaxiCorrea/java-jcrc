package com.maxicorrea.jcrc.views.utils;

import java.io.Serializable;
import javax.swing.JButton;

public class Button implements Serializable {
  private static final long serialVersionUID = 1L;

  private JButton button;

  public Button(String text) {
    button = new JButton(text);
    button.setBorderPainted(false);
    button.setFocusPainted(false);
  }

  public JButton getJButton() {
    return button;
  }
}
