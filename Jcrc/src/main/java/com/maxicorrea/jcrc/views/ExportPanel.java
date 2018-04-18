package com.maxicorrea.jcrc.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import com.maxicorrea.jcrc.views.utils.Button;

class ExportPanel extends JPanel {

  private static final long serialVersionUID = 1L;
  private JLabel titleLabel;
  private JTextArea areaText;
  private Button close;

  ExportPanel(JCrcView mainView) {
    super(new BorderLayout());
    setName("export-view");
    titleLabel = new JLabel("Export JSON ", JLabel.LEFT);
    titleLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
    add(titleLabel, BorderLayout.NORTH);
    areaText = new JTextArea();
    areaText.setEditable(false);
    areaText.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
    add(areaText, BorderLayout.CENTER);
    JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    close = new Button("Close");
    close.addActionListener((ActionEvent e) -> mainView.closeExport());
    panel.add(close);
    add(panel, BorderLayout.SOUTH);
  }

  String getText() {
    return areaText.getText();
  }

  void setText(String text) {
    areaText.setText(text);
  }

}
