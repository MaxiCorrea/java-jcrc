package com.maxicorrea.jcrc.print.pdf;

import java.util.ArrayList;
import java.util.Collection;
import com.maxicorrea.jcrc.models.Card;
import com.maxicorrea.jcrc.models.JCrc;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class CardBeanDataSource {

  private JCrc model;

  public CardBeanDataSource(JCrc model) {
    this.model = model;
  }

  public JRDataSource createReportDataSource() {
    return new JRBeanCollectionDataSource(getBeanCollection());
  }

  Collection<CardBean> getBeanCollection() {
    Collection<CardBean> cards = new ArrayList<>();
    for (Card card : model.getAllCards()) {
      cards.add(new CardBean(card));
    }
    return cards;
  }

}
