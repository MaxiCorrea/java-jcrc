package com.maxicorrea.jcrc.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXRadioGroup;
import com.maxicorrea.jcrc.models.Card;
import com.maxicorrea.jcrc.models.Card.Builder;
import com.maxicorrea.jcrc.models.Type;
import com.maxicorrea.jcrc.views.utils.Button;
import com.maxicorrea.jcrc.views.utils.ShadowBorder;

class CardDialogPanel extends JPanel {

  private static final long serialVersionUID = 1L;
  private JTextField fieldClassName;
  private JTextField fieldSuperclass;
  private JTextField fieldSubclass;
  private JXRadioGroup<Type> typeClass;
  private JTextArea areaResponsabilities;
  private JTextArea areaCollaborators;
  private Button aceptButton;
  private Button cancelButton;
  private boolean editMode;
  int number;

  CardDialogPanel(JCrcView mainView) {
    super(new FlowLayout(FlowLayout.CENTER, 0, 30));
    setName("card-dialog-view");
    JPanel dataPanel = new JPanel();
    dataPanel.setBorder( new ShadowBorder().getBorder()); 
    dataPanel.setPreferredSize(new Dimension(400, 490));
    JLabel labelTitle = new JLabel("   New card", JLabel.LEFT);
    labelTitle.setPreferredSize(new Dimension(390, 25));
    labelTitle.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
    dataPanel.add(labelTitle);
    JLabel labelLine = new JLabel("      ____________________________________________________   ");
    labelLine.setPreferredSize(new Dimension(400, 13));
    dataPanel.add(labelLine);
    fieldClassName = new JTextField();
    fieldClassName.setColumns(26);
    JLabel labelClassName = new JLabel("Class name", JLabel.LEFT);
    labelClassName.setPreferredSize(new Dimension(288, 15));
    dataPanel.add(labelClassName);
    dataPanel.add(fieldClassName);
    fieldSuperclass = new JTextField();
    fieldSuperclass.setColumns(26);
    JLabel labelSuperName = new JLabel("Superclass", JLabel.LEFT);
    labelSuperName.setPreferredSize(new Dimension(288, 15));
    dataPanel.add(labelSuperName);
    dataPanel.add(fieldSuperclass);
    fieldSubclass = new JTextField();
    fieldSubclass.setColumns(26);
    JLabel labelSubName = new JLabel("Subclass", JLabel.LEFT);
    labelSubName.setPreferredSize(new Dimension(288, 15));
    dataPanel.add(labelSubName);
    dataPanel.add(fieldSubclass);
    typeClass = new JXRadioGroup<>();
    typeClass.setValues(Type.values());
    typeClass.setSelectedValue(Type.NORMAL);
    dataPanel.add(typeClass);
    areaResponsabilities = new JTextArea();
    areaResponsabilities.setColumns(26);
    areaResponsabilities.setRows(4);
    JLabel labelResponsabilities = new JLabel("Responsibilities (1 per line):", JLabel.LEFT);
    labelResponsabilities.setPreferredSize(new Dimension(288, 15));
    dataPanel.add(labelResponsabilities);
    JScrollPane scrollResponsabilities = new JScrollPane(areaResponsabilities);
    dataPanel.add(scrollResponsabilities);
    areaCollaborators = new JTextArea();
    areaCollaborators.setColumns(26);
    areaCollaborators.setRows(4);
    JLabel labelCollaborators = new JLabel("Collaborators (1 per line):", JLabel.LEFT);
    labelCollaborators.setPreferredSize(new Dimension(288, 15));
    dataPanel.add(labelCollaborators);
    JScrollPane scrollCollaborators = new JScrollPane(areaCollaborators);
    dataPanel.add(scrollCollaborators);
    JPanel buttonsPane = new JPanel(new BorderLayout());
    buttonsPane.setPreferredSize(new Dimension(288, 40));
    JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    buttonsPane.add(leftPanel, BorderLayout.WEST);
    buttonsPane.add(rightPanel, BorderLayout.EAST);
    aceptButton = new Button("Save Card");
    aceptButton.getJButton().addActionListener((ActionEvent e) -> {
      if (editMode) {
        mainView.endEditCard(getCard());
      } else {
        mainView.addNewCard(getCard());
      }
    });
    leftPanel.add(aceptButton.getJButton());
    cancelButton = new Button("Cancel");
    cancelButton.getJButton().addActionListener((ActionEvent e) -> 
      mainView.cancelEditOrNewCard()
    );
    rightPanel.add(cancelButton.getJButton());
    dataPanel.add(buttonsPane);
    add(dataPanel);
  }

  void clearFields() {
    fieldClassName.setText("");
    fieldSubclass.setText("");
    fieldSuperclass.setText("");
    typeClass.setSelectedValue(Type.NORMAL);
    areaResponsabilities.setText("");
    areaCollaborators.setText("");
  }
  
  void setCard(Card card) {
    number = card.getNumber();
    fieldClassName.setText(card.getName());
    fieldSuperclass.setText(card.getSuperclass());
    fieldSubclass.setText(card.getSubclass());
    typeClass.setSelectedValue(card.getType());
    areaResponsabilities.setText("");
    for (String res : card.getResponsabilities()) {
      areaResponsabilities.append(res);
      areaResponsabilities.append("\n");
    }
    areaCollaborators.setText("");
    for (String col : card.getCollaborators()) {
      areaCollaborators.append(col);
      areaCollaborators.append("\n");
    }
  }

  Card getCard() {
    return new Builder().withName(fieldClassName.getText())
        .withSuperClass(fieldSuperclass.getText()).withSubClass(fieldSubclass.getText())
        .withType(typeClass.getSelectedValue()).withResponsabilities(areaResponsabilities.getText())
        .withCollaborators(areaCollaborators.getText()).withNumber(number).build();
  }

  void editMode() {
    editMode = true;
  }

  void newMode() {
    editMode = false;
  }

}
