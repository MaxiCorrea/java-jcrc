package com.maxicorrea.jcrc.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.maxicorrea.jcrc.views.utils.Button;
import com.maxicorrea.jcrc.views.utils.ShadowBorder;

public class NoCardPanel extends JPanel {
  private static final long serialVersionUID = 1L;

  private JLabel messageLabel;
  private Button newCardButton;

  public NoCardPanel(JCrcView mainView) {
    super(new FlowLayout(FlowLayout.CENTER, 0, 125));
    setName("no-card-view");
    JPanel dataPanel = new JPanel(new BorderLayout());
    dataPanel.setPreferredSize(new Dimension(650, 200));
    messageLabel = new JLabel("You don't have any cards yet.", JLabel.CENTER);
    messageLabel.setFont(new Font(Font.DIALOG, Font.ITALIC, 35));
    dataPanel.add(messageLabel, BorderLayout.CENTER);
    dataPanel.setBorder(new ShadowBorder().getBorder());
    JPanel extra = new JPanel();
    newCardButton = new Button("New card");
    newCardButton.addActionListener((ActionEvent e) -> mainView.showNewCardView());
    extra.add(newCardButton);
    dataPanel.add(extra, BorderLayout.SOUTH);
    add(dataPanel, BorderLayout.CENTER);
  }

  String getMessageText() {
    return messageLabel.getText();
  }

  String getNewCardButtonText() {
    return newCardButton.getText();
  }

}
