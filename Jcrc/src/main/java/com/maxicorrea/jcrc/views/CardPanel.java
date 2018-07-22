package com.maxicorrea.jcrc.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.maxicorrea.jcrc.models.Card;
import com.maxicorrea.jcrc.views.utils.Button;
import com.maxicorrea.jcrc.views.utils.ShadowBorder;

class CardPanel extends JPanel {

  private static final long serialVersionUID = 1L;

  private Button edit;
  private Button remove;
  private JLabel type;
  private JLabel superClass;
  private JLabel className;
  private JLabel subClass;
  private List<JLabel> responsabilities;
  private List<JLabel> collaborators;

  CardPanel(JCrcView mainView, Card card) {
    super(new BorderLayout());
    setBorder(new ShadowBorder().getBorder());
    JPanel northPane = new JPanel(new GridLayout(3, 1));
    northPane.setPreferredSize(new Dimension(700, 100));
    northPane.setBorder(BorderFactory.createLineBorder(Color.PINK));
    type = new JLabel(" " + card.getType(), JLabel.LEFT);
    superClass = new JLabel(card.getSuperclass() + " ", JLabel.RIGHT);
    JPanel panel = new JPanel(new BorderLayout());
    panel.add(type, BorderLayout.WEST);
    panel.add(superClass, BorderLayout.EAST);
    northPane.add(panel);
    className = new JLabel(card.getName() + " ", JLabel.CENTER);
    className.setFont(new Font(Font.DIALOG, Font.PLAIN, 30));
    northPane.add(className);
    subClass = new JLabel(card.getSubclass() + " ", JLabel.RIGHT);
    northPane.add(subClass);
    add(northPane, BorderLayout.NORTH);
    JPanel centerPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
    centerPane.setBorder(BorderFactory.createLineBorder(Color.PINK));
    JPanel extra1 = new JPanel(new GridLayout(card.getResponsabilities().size(), 1));
    loadResponsabilities(card, extra1);
    centerPane.add(extra1);
    add(centerPane, BorderLayout.CENTER);
    JPanel eastPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
    eastPane.setBorder(BorderFactory.createLineBorder(Color.PINK));
    JPanel extra2 = new JPanel(new GridLayout(card.getCollaborators().size(), 1));
    loadCollaborators(card, extra2);
    eastPane.add(extra2);
    add(eastPane, BorderLayout.EAST);
    JPanel southPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
    edit = new Button("Edit card #" + card.getNumber());
    edit.getJButton().addActionListener((ActionEvent e) -> mainView.showEditCardView(card));
    southPane.add(edit.getJButton());
    remove = new Button("Delete");
    remove.getJButton().addActionListener((ActionEvent e) -> mainView.removeCard(card));
    southPane.add(remove.getJButton());
    add(southPane, BorderLayout.SOUTH);
  }

  private void loadResponsabilities(Card card, JPanel extra1) {
    responsabilities = new ArrayList<>();
    for (String responsabily : card.getResponsabilities()) {
      JLabel label = new JLabel("* " + responsabily, JLabel.LEFT);
      responsabilities.add(label);
      extra1.add(label);
    }
  }

  private void loadCollaborators(Card card, JPanel extra2) {
    collaborators = new ArrayList<>();
    for (String collaborator : card.getCollaborators()) {
      JLabel label = new JLabel("* " + collaborator, JLabel.LEFT);
      collaborators.add(label);
      extra2.add(label);
    }
  }

  String getTypeText() {
    return type.getText();
  }

  String getSuperclassText() {
    return superClass.getText();
  }

  String getSubclassText() {
    return subClass.getText();
  }

  List<JLabel> getResposibilities() {
    return responsabilities;
  }

  List<JLabel> getCollaborators() {
    return collaborators;
  }

}
