package com.maxicorrea.jcrc.print.pdf;

import static org.junit.Assert.*;
import org.junit.Test;
import com.maxicorrea.jcrc.models.Card;
import com.maxicorrea.jcrc.models.CardBuilder;
import com.maxicorrea.jcrc.models.Type;

public class CardBeanTest {

  private static final String ANY_NAME = "ANY_NAME";
  private static final String ANY_SUPERCLASS = "ANY_SUPERCLASS";
  private static final String ANY_SUBCLASS = "ANY_SUBCLASS";
  private static final String RESPONSABILITIES = "A\nB\nC";
  private static final String COLLABORATORS = "D\nE";

  @Test
  public void shouldStoreAllTheDataOnACard() {
    Card card = new CardBuilder().withName(ANY_NAME).withSuperclass(ANY_SUPERCLASS)
        .withSubclass(ANY_SUBCLASS).withType(Type.INTERFACE).withResponsabilities(RESPONSABILITIES)
        .withCollaborators(COLLABORATORS).build();
    CardBean bean = new CardBean(card);
    assertEquals(card.getName(), bean.getName());
    assertEquals(card.getSuperclass(), bean.getSuperclass());
    assertEquals(card.getSubclass(), bean.getSubclass());
    assertEquals(card.getType().toString(), bean.getType());
    assertFalse(bean.getResponsibilities().isEmpty());
    assertFalse(bean.getCollaborators().isEmpty());
  }

}
