package com.maxicorrea.jcrc.models;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class CardTest {

  private static final String ANY_NAME = "ANY_NAME";
  private static final String ANY_SUPERCLASS = "ANY_SUPERCLASS";
  private static final String ANY_SUBCLASS = "ANY_SUBCLASS";
  private static final List<String> EMPTY_RESPONSABILITIES = new ArrayList<>();
  private static final List<String> EMPTY_COLLABORATORS = new ArrayList<>();

  @Test
  public void shouldSetAllYourDataCorrectly() {
    Card card = new Card(0, ANY_NAME, ANY_SUPERCLASS, ANY_SUBCLASS, Type.NORMAL,
        EMPTY_RESPONSABILITIES, EMPTY_COLLABORATORS);
    assertEquals(ANY_NAME , card.getName());
    assertEquals(ANY_SUPERCLASS , card.getSuperclass());
    assertEquals(ANY_SUBCLASS , card.getSubclass());
    assertEquals(Type.NORMAL , card.getType());
    assertEquals(EMPTY_RESPONSABILITIES, card.getResponsabilities());
    assertEquals(EMPTY_COLLABORATORS, card.getCollaborators());
  }

  @Test
  public void shouldCopyTheDataFromAnotherCard() {
    Card expected = new CardBuilder().withName("Product").withNumber(45).withType(Type.ABSTRACT).build();
    Card card = new Card(0, ANY_NAME, ANY_SUPERCLASS, ANY_SUBCLASS, Type.NORMAL,
        EMPTY_RESPONSABILITIES, EMPTY_COLLABORATORS);
    card.copyDataOf(expected);
    assertEquals(expected.getName() , card.getName());
    assertEquals(expected.getSuperclass() , card.getSuperclass());
    assertEquals(expected.getSubclass() , card.getSubclass());
    assertEquals(expected.getType() , card.getType());
    assertEquals(expected.getResponsabilities(), card.getResponsabilities());
    assertEquals(expected.getCollaborators(), card.getCollaborators());
  }
  
  @Test
  public void testEquals() {
    Card card = new CardBuilder().withCollaborators("").withName(ANY_NAME).build();
    assertFalse(card.equals(null));
    assertTrue(card.equals(card));
    Card another = new CardBuilder().build();
    assertFalse(card.equals(another));
    Card expected =new CardBuilder().withCollaborators("").withName(ANY_NAME).build();
    assertEquals(expected , card);
  }
 
}
