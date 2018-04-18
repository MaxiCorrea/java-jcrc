package com.maxicorrea.jcrc.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import com.maxicorrea.jcrc.models.Card;
import com.maxicorrea.jcrc.models.Observer;
import com.maxicorrea.jcrc.views.utils.Button;

class ListCardsPanel extends JPanel implements Observer {
  private static final long serialVersionUID = 1L;

  private Button newCard;
  private Button removeAll;
  private Button export;
  private Button print;
  private JPanel contentPane;
  private JCrcView mainView;

  ListCardsPanel(JCrcView mainView) {
    super(new BorderLayout());
    setName("list-cards-view");
    this.mainView = mainView;
    mainView.getModel().addObserver(this);
    JPanel panelNorth = new JPanel();
    newCard = new Button("New Card");
    newCard.addActionListener((ActionEvent e) -> {
      mainView.showNewCardView();
    });
    removeAll = new Button("Remove All");
    removeAll.addActionListener((ActionEvent e) -> {
      mainView.removeAllWithDialog();
    });
    export = new Button("Export");
    export.addActionListener((ActionEvent e) ->{
      mainView.showExportView();
    });
    print = new Button("Print");
    print.addActionListener((ActionEvent e)->{
      mainView.printCards();
    });
    panelNorth.setLayout(new FlowLayout(FlowLayout.LEFT));
    panelNorth.add(newCard);
    panelNorth.add(removeAll);
    panelNorth.add(export);
    panelNorth.add(print);
    add(panelNorth, BorderLayout.NORTH);
    contentPane = new JPanel();
    contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
    JPanel centerPane = new JPanel();
    centerPane.add(contentPane);
    add(centerPane, BorderLayout.CENTER);
  }

  @Override
  public void update() {
    contentPane.removeAll();
    for (Card card : mainView.getModel().getAllCards()) {
      contentPane.add(new CardPanel(mainView, card));
    }
    contentPane.revalidate();
  }
}
