package com.maxicorrea.jcrc.views;

import com.maxicorrea.jcrc.controllers.AbstractController;
import com.maxicorrea.jcrc.models.JCrc;

public abstract class AbstractView {

  private JCrc model;
  private AbstractController controller;

  public AbstractView(JCrc model) {
    this.model = model;
  }

  public JCrc getModel() {
    return model;
  }

  public AbstractController getController() {
    return controller;
  }
  
  public final void initialize() {
    controller = makeController();
  }

  abstract AbstractController makeController();

}
