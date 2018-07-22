package com.maxicorrea.jcrc.views.utils;

import javax.swing.JButton;

public class Button {

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
