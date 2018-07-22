package com.maxicorrea.jcrc.views.utils;

import java.io.Serializable;
import javax.swing.JButton;

public class Button implements Serializable {
  private static final long serialVersionUID = 1L;

  private JButton jButton;

  public Button(String text) {
    jButton = new JButton(text);
    jButton.setBorderPainted(false);
    jButton.setFocusPainted(false);
  }

  public JButton getJButton() {
    return jButton;
  }
}
