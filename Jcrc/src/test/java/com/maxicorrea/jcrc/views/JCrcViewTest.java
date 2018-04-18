package com.maxicorrea.jcrc.views;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.junit.Test;
import com.maxicorrea.jcrc.models.Card;
import com.maxicorrea.jcrc.models.CardBuilder;
import com.maxicorrea.jcrc.models.JCrc;

public class JCrcViewTest {

  private Card card = new CardBuilder().build();

  @Test
  public void shouldInvokeTheModelToAddAnewCard() {
    JCrc model = mock(JCrc.class);
    JCrcView view = new JCrcView(model);
    view.addNewCard(card);
    verify(model).addNewCard(card);
  }

  @Test
  public void shouldInvokeTheModelToRemoveACard() {
    JCrc model = mock(JCrc.class);
    JCrcView view = new JCrcView(model);
    view.removeCard(card);
    verify(model).removeCard(card);
    verify(model).containCards();
  }

  @Test
  public void shouldInvokeTheModelToEditACard() {
    JCrc model = mock(JCrc.class);
    JCrcView view = new JCrcView(model);
    view.endEditCard(card);
    verify(model).editCard(card);
  }

  @Test
  public void shouldInvokeTheModelToRemoveAllCards() {
    JCrc model = mock(JCrc.class);
    JCrcView view = new JCrcView(model);
    view.removeAll();
    verify(model).removeAll();
  }

  @Test
  public void shouldInvokeTheModelToCancelEditOrNewCard() {
    JCrc model = mock(JCrc.class);
    JCrcView view = new JCrcView(model);
    view.cancelEditOrNewCard();
    verify(model).containCards();
  }

}
