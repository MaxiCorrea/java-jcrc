package com.maxicorrea.jcrc.views;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;
import com.maxicorrea.jcrc.models.Card;
import com.maxicorrea.jcrc.models.Card.Builder;
import com.maxicorrea.jcrc.models.JCrc;
import com.maxicorrea.jcrc.models.Observer;

public class ListCardsPanelTest {

  private Card card = new Builder().build();

  @Test
  public void shouldBeAnObserverOfTheModel() {
    JCrc model = new JCrc();
    JCrcView crcView = mock(JCrcView.class);
    when(crcView.getModel()).thenReturn(model);
    ListCardsPanel cardsPanel = new ListCardsPanel(crcView);
    model.addNewCard(card);
    verify(crcView, times(2)).getModel();
    assertTrue(cardsPanel instanceof Observer);
  }

}
