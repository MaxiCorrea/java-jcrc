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

public class JCrcTest {

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
    Card card = new CardBuilder().build();
    model.addNewCard(card);
    assertFalse(model.getAllCards().isEmpty());
    assertEquals(1, model.getAllCards().size());
    assertEquals(card, model.getAllCards().get(0));
  }

  @Test
  public void shouldBeAbleToAddTwoCards() {
    JCrc model = new JCrc();
    Card card1 = new CardBuilder().build();
    model.addNewCard(card1);
    assertFalse(model.getAllCards().isEmpty());
    assertEquals(1, model.getAllCards().size());
    assertEquals(card1, model.getAllCards().get(0));
    Card card2 = new CardBuilder().build();
    model.addNewCard(card2);
    assertEquals(2, model.getAllCards().size());
    assertEquals(card2, model.getAllCards().get(1));
  }

  @Test
  public void shouldBeAbleToRemoveAllTheCards() {
    JCrc model = new JCrc();
    model.addNewCard(new CardBuilder().build());
    model.addNewCard(new CardBuilder().build());
    model.addNewCard(new CardBuilder().build());
    assertEquals(3, model.getNumberOfCards());
    model.removeAll();
    assertFalse(model.containCards());
  }

  @Test
  public void shouldBeAbleToRemoveACard() {
    JCrc model = new JCrc();
    Card aCard = new CardBuilder().build();
    model.addNewCard(aCard);
    assertEquals(1, model.getNumberOfCards());
    model.removeCard(aCard);
    assertFalse(model.containCards());
  }

  @Test
  public void shouldBeAbleToEditACard() {
    JCrc model = new JCrc();
    Card aCard = new CardBuilder().withName("Customer").build();
    Card bCard = new CardBuilder().withNumber(1).withName("Employee").build();
    model.addNewCard(aCard);
    model.editCard(bCard);
    assertEquals(bCard.getName() , model.getAllCards().get(0).getName());
  }

  @Test
  public void shouldBeAbleToMoveACardDown() {
    JCrc model = new JCrc();
    Card card1 = new CardBuilder().build();
    Card card2 = new CardBuilder().build();
    model.addNewCard(card1);
    model.addNewCard(card2);
    assertEquals(card1 , model.getAllCards().get(0));
    assertEquals(card2 , model.getAllCards().get(1)); 
    model.moveDownCard(card1);
    assertEquals(card2 , model.getAllCards().get(0));
    assertEquals(card1 , model.getAllCards().get(1)); 
  }
  
  @Test
  public void shouldBeAbleToMoveACardUp() {
    JCrc model = new JCrc();
    Card card1 = new CardBuilder().build();
    Card card2 = new CardBuilder().build();
    model.addNewCard(card1);
    model.addNewCard(card2);
    assertEquals(card1 , model.getAllCards().get(0));
    assertEquals(card2 , model.getAllCards().get(1)); 
    model.moveUpCard(card2);
    assertEquals(card2 , model.getAllCards().get(0));
    assertEquals(card1 , model.getAllCards().get(1)); 
  }
  
  @Test
  public void shouldBeAbleToNotifyAnObserverForOneChangeOperation() {
    JCrc model = new JCrc();
    Observer observer = mock(Observer.class);
    model.addObserver(observer);
    model.addNewCard( new CardBuilder().build());
    model.addNewCard( new CardBuilder().build());
    model.addNewCard( new CardBuilder().build());
    model.addNewCard( new CardBuilder().build());
    verify(observer , times(4)).update();
    verifyNoMoreInteractions(observer);
  }

}
