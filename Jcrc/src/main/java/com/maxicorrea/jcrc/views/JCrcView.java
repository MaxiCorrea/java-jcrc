package com.maxicorrea.jcrc.views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import com.maxicorrea.jcrc.application.AppConfig;
import com.maxicorrea.jcrc.export.ExportType;
import com.maxicorrea.jcrc.export.Exporter;
import com.maxicorrea.jcrc.models.Card;
import com.maxicorrea.jcrc.models.JCrc;
import com.maxicorrea.jcrc.print.PrintException;
import com.maxicorrea.jcrc.print.PrintType;
import com.maxicorrea.jcrc.print.Printer;
import com.maxicorrea.jcrc.views.utils.MotionFrame;

public class JCrcView {

  private static final String PDF_READY_MESSAGE = "Your PDF file is now ready.";
  private static final String REMOVE_ALL_MESSAGE = "Are you sure you want to delete all the cards?";
  private static final int WIDTH = 1_100;
  private static final int HEIGHT = 600;

  private JFrame frame;
  private JPanel contentPane;
  private JPanel cardPanel;
  private CardLayout cardLayout;

  private NoCardPanel noCardPanel;
  private CardDialogPanel cardDialogPanel;
  private ListCardsPanel listCardsPanel;
  private ExportPanel exportPanel;

  private JCrc model;

  public JCrcView(JCrc model) {
    this.model = model;
    UIManager.put("ScrollBar.thumbShadow", Color.WHITE);
    UIManager.put("ScrollBar.background", Color.WHITE);
    UIManager.put("ScrollBar.foreground", Color.WHITE);
    UIManager.put("ScrollBar.width", Integer.valueOf(15));
    frame = new JFrame();
    frame.setIconImage(
        Toolkit.getDefaultToolkit().getImage(getClass().getResource(AppConfig.url("app_icon"))));
    frame.setUndecorated(true);
    frame.setSize(WIDTH, HEIGHT);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    contentPane = new JPanel(new BorderLayout());
    contentPane.add(new MotionFrame(frame), BorderLayout.NORTH);
    cardPanel = new JPanel();
    cardLayout = new CardLayout();
    cardPanel.setLayout(cardLayout);
    noCardPanel = new NoCardPanel(this);
    cardPanel.add(noCardPanel, noCardPanel.getName());
    cardDialogPanel = new CardDialogPanel(this);
    cardPanel.add(cardDialogPanel, cardDialogPanel.getName());
    listCardsPanel = new ListCardsPanel(this);
    cardPanel.add(listCardsPanel, listCardsPanel.getName());
    exportPanel = new ExportPanel(this);
    cardPanel.add(exportPanel, exportPanel.getName());
    JScrollPane scroll = new JScrollPane(cardPanel);
    scroll.getVerticalScrollBar().setUnitIncrement(16);
    contentPane.add(scroll, BorderLayout.CENTER);
    frame.setContentPane(contentPane);
  }

  JCrc getModel() {
    return model;
  }

  void addNewCard(Card card) {
    model.addNewCard(card);
    showPanel(listCardsPanel);
  }

  void removeCard(Card card) {
    model.removeCard(card);
    if (model.containCards()) {
      showPanel(listCardsPanel);
    } else {
      showPanel(noCardPanel);
    }
  }

  void cancelEditOrNewCard() {
    if (model.containCards()) {
      showPanel(listCardsPanel);
    } else {
      showPanel(noCardPanel);
    }
  }

  void showExportView() {
    Exporter export = Exporter.create(ExportType.JSON);
    String content = export.exportToString(getModel());
    exportPanel.setText(content);
    showPanel(exportPanel);
  }

  void showNewCardView() {
    cardDialogPanel.clearFields();
    cardDialogPanel.newMode();
    showPanel(cardDialogPanel);
  }

  void showEditCardView(Card card) {
    cardDialogPanel.setCard(card);
    cardDialogPanel.editMode();
    showPanel(cardDialogPanel);
  }

  void removeAllWithDialog() {
    if (JOptionPane.showConfirmDialog(frame, REMOVE_ALL_MESSAGE) == 0) {
     removeAll();
    }
  }
  
  void removeAll() {
    model.removeAll();
    showPanel(noCardPanel);
  }

  public void show() {
    if (!frame.isVisible()) {
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
    }
  }

  void endEditCard(Card card) {
    model.editCard(card);
    showPanel(listCardsPanel);
  }

  void closeExport() {
    showPanel(listCardsPanel);
  }

  void printCards() {
    String path = getSelectPathChooser();
    if (path != null) {
      new Thread(() -> {
        Printer print = Printer.create(PrintType.PDF);
        try {
          print.print(getModel(), path);
          JOptionPane.showMessageDialog(frame, PDF_READY_MESSAGE);
        } catch (PrintException e) {
          JOptionPane.showMessageDialog(frame, e.getMessage());
        }
      }).start();
    }
  }

  String getSelectPathChooser() {
    JFileChooser chooser = new JFileChooser();
    if (chooser.showSaveDialog(frame) == 0) {
      return chooser.getSelectedFile().getAbsolutePath();
    }
    return null;
  }

  private void showPanel(JPanel panel) {
    cardLayout.show(cardPanel, panel.getName());
  }

}
