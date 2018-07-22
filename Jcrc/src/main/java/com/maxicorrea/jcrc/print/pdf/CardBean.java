package com.maxicorrea.jcrc.print.pdf;

import java.util.Set;
import com.maxicorrea.jcrc.models.Card;

public class CardBean {

  private static String getStringWithAsterisksPerLine(Set<String> lines) {
    StringBuilder result = new StringBuilder();
    for (String line : lines) {
      result.append(" * ").append(line).append("\n");
    }
    return result.toString();
  }

  private Card card;

  public CardBean() {
    super();
  }

  public CardBean(Card card) {
    this.card = card;
  }

  public String getName() {
    return card.getName();
  }

  public String getSuperclass() {
    return card.getSuperclass();
  }

  public String getSubclass() {
    return card.getSubclass();
  }

  public String getType() {
    return String.valueOf(card.getType());
  }

  public String getResponsibilities() {
    return getStringWithAsterisksPerLine(card.getResponsabilities());
  }

  public String getCollaborators() {
    return getStringWithAsterisksPerLine(card.getCollaborators());
  }

}
