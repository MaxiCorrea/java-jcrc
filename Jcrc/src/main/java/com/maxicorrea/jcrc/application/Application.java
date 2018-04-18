package com.maxicorrea.jcrc.application;

import javax.swing.SwingUtilities;
import com.maxicorrea.jcrc.models.JCrc;
import com.maxicorrea.jcrc.views.JCrcView;


public class Application {

  public static void main(String[] args) {
   SwingUtilities.invokeLater(()->{
     JCrc model = new JCrc();
     JCrcView crcView = new JCrcView(model);
     crcView.show();
   });
  }

}
