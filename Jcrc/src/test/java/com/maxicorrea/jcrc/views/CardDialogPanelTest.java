package com.maxicorrea.jcrc.views;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import org.junit.Test;
import com.maxicorrea.jcrc.models.Card;
import com.maxicorrea.jcrc.models.CardBuilder;
import com.maxicorrea.jcrc.models.Type;

public class CardDialogPanelTest {

  private static final String ANY_SUPERCLASS = "ANY_SUPERCLASS";
  private static final String ANY_SUBCLASS = "ANY_SUBCLASS";
  private static final String ANY_COLLABORATORS = "collaborators";
  private static final String ANY_RESPONSIBILITES = "responsibilities";

  private Card card = new CardBuilder()
      .withSuperclass(ANY_SUPERCLASS)
       .withSubclass(ANY_SUBCLASS)
       .withType(Type.NORMAL)
       .withCollaborators(ANY_COLLABORATORS)
       .withResponsabilities(ANY_RESPONSIBILITES)
       .build();
  
  private JCrcView view = mock(JCrcView.class);
  
  @Test
  public void shouldBeAbleToEstablishTheDataOfACard() {
    CardDialogPanel cardDialogPanel = new CardDialogPanel(view);
    cardDialogPanel.setCard(card);
    assertEquals(card , cardDialogPanel.getCard());
  }

}


