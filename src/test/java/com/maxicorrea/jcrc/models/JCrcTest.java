package com.maxicorrea.jcrc.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import org.junit.Test;
import com.maxicorrea.jcrc.models.Card.Builder;

public class JCrcTest {

  private static final int ONE = 1;
  
  @Test
  public void initiallyShouldNotHaveCards() {
    JCrc model = new JCrc();
    assertNotNull(model.getAllCards());
    assertTrue(model.getAllCards().isEmpty());
    assertFalse(model.containCards());
  }

  @Test
  public void shouldBeAbleToAddACard() {
    JCrc model = new JCrc();
    Card card = new Builder().build();
    model.addNewCard(card);
    assertFalse(model.getAllCards().isEmpty());
    assertEquals(ONE, model.getAllCards().size());
    assertEquals(card, model.getAllCards().get(0));
  }

  @Test
  public void shouldBeAbleToAddTwoCards() {
    JCrc model = new JCrc();
    Card card1 = new Builder().build();
    model.addNewCard(card1);
    assertFalse(model.getAllCards().isEmpty());
    assertEquals(ONE, model.getAllCards().size());
    assertEquals(card1, model.getAllCards().get(0));
    Card card2 = new Builder().build();
    model.addNewCard(card2);
    assertEquals(2, model.getAllCards().size());
    assertEquals(card2, model.getAllCards().get(1));
  }

  @Test
  public void shouldBeAbleToRemoveAllTheCards() {
    JCrc model = new JCrc();
    model.addNewCard(new Builder().build());
    model.addNewCard(new Builder().build());
    model.addNewCard(new Builder().build());
    assertEquals(3, model.getNumberOfCards());
    model.removeAll();
    assertFalse(model.containCards());
  }

  @Test
  public void shouldBeAbleToRemoveACard() {
    JCrc model = new JCrc();
    Card aCard = new Builder().build();
    model.addNewCard(aCard);
    assertEquals(ONE, model.getNumberOfCards());
    model.removeCard(aCard);
    assertFalse(model.containCards());
  }

  @Test
  public void shouldBeAbleToEditACard() {
    JCrc model = new JCrc();
    Card aCard = new Builder().withName("Customer").build();
    Card bCard = new Builder().withNumber(1).withName("Employee").build();
    model.addNewCard(aCard);
    model.editCard(bCard);
    assertEquals(bCard.getName(), model.getAllCards().get(0).getName());
  }

  @Test
  public void shouldBeAbleToMoveACardDown() {
    JCrc model = new JCrc();
    Card card1 = new Builder().build();
    Card card2 = new Builder().build();
    model.addNewCard(card1);
    model.addNewCard(card2);
    assertEquals(card1, model.getAllCards().get(0));
    assertEquals(card2, model.getAllCards().get(1));
    model.moveDownCard(card1);
    assertEquals(card2, model.getAllCards().get(0));
    assertEquals(card1, model.getAllCards().get(1));
  }

  @Test
  public void shouldBeAbleToMoveACardUp() {
    JCrc model = new JCrc();
    Card card1 = new Builder().build();
    Card card2 = new Builder().build();
    model.addNewCard(card1);
    model.addNewCard(card2);
    assertEquals(card1, model.getAllCards().get(0));
    assertEquals(card2, model.getAllCards().get(1));
    model.moveUpCard(card2);
    assertEquals(card2, model.getAllCards().get(0));
    assertEquals(card1, model.getAllCards().get(1));
  }

  @Test
  public void shouldBeAbleToNotifyAnObserverForOneChangeOperation() {
    JCrc model = new JCrc();
    Observer observer = mock(Observer.class);
    model.addObserver(observer);
    model.addNewCard(new Builder().build());
    model.addNewCard(new Builder().build());
    model.addNewCard(new Builder().build());
    model.addNewCard(new Builder().build());
    verify(observer, times(4)).update();
    verifyNoMoreInteractions(observer);
  }

}
