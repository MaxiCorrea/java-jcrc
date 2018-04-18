package com.maxicorrea.jcrc.views.utils;

import java.awt.Color;
import javax.swing.border.Border;
import org.jdesktop.swingx.border.DropShadowBorder;

public class ShadowBorder {
  
  private DropShadowBorder border;

  public ShadowBorder() {
    border = new DropShadowBorder(Color.BLACK, 17);
    border.setShadowOpacity(.5f);
    border.setShowLeftShadow(true);
    border.setShowTopShadow(true);
  }
  
  public Border getBorder() {
    return border;
  }
  
}
