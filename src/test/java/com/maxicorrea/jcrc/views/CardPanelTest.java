package com.maxicorrea.jcrc.views;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.Test;
import com.maxicorrea.jcrc.models.Card;
import com.maxicorrea.jcrc.models.Card.Builder;
import com.maxicorrea.jcrc.models.Type;

public class CardPanelTest {

  private static final String ANY_SUPERCLASS = "ANY_SUPERCLASS";
  private static final String ANY_SUBCLASS = "ANY_SUBCLASS";
  private static final String ANY_COLLABORATORS = "collaborators";
  private static final String ANY_RESPONSIBILITES = "responsibilities";

  @Test
  public void shouldBeAbleToViewTheDataOnACard() {
    Card card = new Builder().withSuperClass(ANY_SUPERCLASS).withSubClass(ANY_SUBCLASS)
        .withType(Type.NORMAL).withCollaborators(ANY_COLLABORATORS)
        .withResponsabilities(ANY_RESPONSIBILITES).build();
    JCrcView view = mock(JCrcView.class);
    CardPanel cardPanel = new CardPanel(view, card);
    assertTrue(cardPanel.getSuperclassText().contains(card.getSuperclass()));
    assertTrue(cardPanel.getSubclassText().contains(card.getSubclass()));
    assertTrue(cardPanel.getTypeText().contains(card.getType().toString()));
    assertNotNull(cardPanel.getResposibilities());
    assertFalse(cardPanel.getResposibilities().isEmpty());;
    assertNotNull(cardPanel.getCollaborators());
    assertFalse(cardPanel.getCollaborators().isEmpty());
  }

}
