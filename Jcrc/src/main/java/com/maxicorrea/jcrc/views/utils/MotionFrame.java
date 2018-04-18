package com.maxicorrea.jcrc.views.utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import com.maxicorrea.jcrc.application.AppConfig;

public class MotionFrame extends JLabel {

  private static final long serialVersionUID = 1L;
  static final Icon MINI_ICON = IconLoader.load(AppConfig.url("mini"));
  static final Icon CLOSE_ICON = IconLoader.load(AppConfig.url("close"));

  private Point p1;
  private Point p2;
  private JLabel mini;
  private JLabel close;
  private JFrame mainFrame;

  public MotionFrame(JFrame mainFrame) {
    super("  JCRC Card Maker", JLabel.LEFT);
    this.mainFrame = mainFrame;
    mainFrame.setTitle("JCRC Card Maker");
    setForeground(Color.BLACK);
    setFont(getFont().deriveFont(Font.BOLD));
    setLayout(new FlowLayout(FlowLayout.RIGHT));
    add(getLabelMini());
    add(getLabelClose());
    setPreferredSize(new Dimension(990, 40));
    addMouseListener();
    addMouseMotionListener();
  }

  private void addMouseListener() {
    addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        p1 = new Point(e.getX(), e.getY());
      }
    });
  }

  private void addMouseMotionListener() {
    addMouseMotionListener(new MouseMotionAdapter() {
      @Override
      public void mouseDragged(MouseEvent e) {
        p2 = MouseInfo.getPointerInfo().getLocation();
        mainFrame.setLocation(p2.x - p1.x, p2.y - p1.y);
      }
    });
  }

  JLabel getLabelClose() {
    if (close == null) {
      close = new JLabel();
      close.setIcon(CLOSE_ICON);
      close.addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
          closeFrame();
          System.exit(0);
        }
      });
    }
    return close;
  }

  void closeFrame() {
    mainFrame.setVisible(false);
    mainFrame.dispose();
  }

  JLabel getLabelMini() {
    if (mini == null) {
      mini = new JLabel();
      mini.setIcon(MINI_ICON);
      mini.addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
          iconifiedFrame();
        }
      });
    }
    return mini;
  }

  void iconifiedFrame() {
    mainFrame.setState(JFrame.ICONIFIED);
  }

}
