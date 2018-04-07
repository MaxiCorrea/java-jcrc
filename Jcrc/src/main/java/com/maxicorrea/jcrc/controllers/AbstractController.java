package com.maxicorrea.jcrc.controllers;

import java.awt.event.ActionEvent;
import com.maxicorrea.jcrc.models.JCrc;
import com.maxicorrea.jcrc.views.AbstractView;

public abstract class AbstractController {

  private JCrc model;

  public AbstractController(AbstractView view) {
    model = view.getModel();
  }

  public JCrc getModel() {
    return model;
  }

  public abstract void handleEvent(ActionEvent event);

}
