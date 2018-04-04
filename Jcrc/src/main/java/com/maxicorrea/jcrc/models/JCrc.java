package com.maxicorrea.jcrc.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JCrc {

  private List<Card> cards;

  public JCrc() {
    cards = new ArrayList<>();
  }

  public void addNewCard(Card card) {
    card.setNumber(cards.size() + 1);
    cards.add(card);
  }

  public void removeCard(Card card) {
    if (cards.remove(card)) {
      for (int index = 0; index < cards.size(); ++index) {
        cards.get(index).setNumber(index + 1);
      }
    }
  }

  public void editCard(Card card) {
    int index = cards.indexOf(card);
    if (index != -1) {
      cards.get(index).copyDataOf(card);
    }
  }

  public void removeAll() {
    cards.clear();
  }

  public void moveDownCard(Card card) {
    int index = cards.indexOf(card);
    if (index > 0 && index < cards.size() - 1) {
      swapObjects(index, index + 1);
      swapNumbers(index, index + 1);
    }
  }

  public void moveUpCard(Card card) {
    int index = cards.indexOf(card);
    if (index > 0 && index < cards.size() - 1) {
      swapObjects(index, index - 1);
      swapNumbers(index, index - 1);
    }
  }

  private void swapObjects(int index1, int index2) {
    Card card1 = cards.get(index1);
    Card card2 = cards.get(index2);
    cards.set(index1, card2);
    cards.set(index2, card1);
  }

  private void swapNumbers(int index1, int index2) {
    int numberOfCard1 = cards.get(index1).getNumber();
    int numberOfCard2 = cards.get(index2).getNumber();
    cards.get(index1).setNumber(numberOfCard2);
    cards.get(index2).setNumber(numberOfCard1);
  }

  public List<Card> getAllCards() {
    return Collections.unmodifiableList(cards);
  }

  public int getNumberOfCards() {
    return cards.size();
  }

}
