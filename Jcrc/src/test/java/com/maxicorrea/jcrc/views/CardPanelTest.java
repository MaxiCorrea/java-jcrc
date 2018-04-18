package com.maxicorrea.jcrc.views;

import static org.junit.Assert.*;
import org.junit.Test;
import com.maxicorrea.jcrc.models.Card;
import com.maxicorrea.jcrc.models.CardBuilder;
import com.maxicorrea.jcrc.models.Type;
import static org.mockito.Mockito.*;

public class CardPanelTest {

  private static final String ANY_SUPERCLASS = "ANY_SUPERCLASS";
  private static final String ANY_SUBCLASS = "ANY_SUBCLASS";
  private static final String ANY_COLLABORATORS = "collaborators";
  private static final String ANY_RESPONSIBILITES = "responsibilities";

  @Test
  public void shouldBeAbleToViewTheDataOnACard() {
    Card card = new CardBuilder()
                   .withSuperclass(ANY_SUPERCLASS)
                    .withSubclass(ANY_SUBCLASS)
                    .withType(Type.NORMAL)
                    .withCollaborators(ANY_COLLABORATORS)
                    .withResponsabilities(ANY_RESPONSIBILITES)
                    .build();
    JCrcView view = mock(JCrcView.class);
    CardPanel cardPanel = new CardPanel(view, card);
    assertTrue(cardPanel.getSuperclassText().contains(card.getSuperclass()));
    assertTrue(cardPanel.getSubclassText().contains(card.getSubclass()));
    assertTrue(cardPanel.getTypeText().contains(card.getType().toString()));
    assertNotNull(cardPanel.getResposibilities());
    assertFalse(cardPanel.getResposibilities().isEmpty());
    assertTrue(cardPanel.getResposibilities().get(0).getText().
        contains(card.getResponsabilities().get(0)));
    assertNotNull(cardPanel.getCollaborators());
    assertFalse(cardPanel.getCollaborators().isEmpty());
    assertTrue(cardPanel.getCollaborators().get(0).getText().
        contains(card.getCollaborators().get(0)));
  }

}
