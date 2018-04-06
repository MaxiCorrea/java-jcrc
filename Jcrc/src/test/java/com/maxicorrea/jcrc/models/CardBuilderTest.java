package com.maxicorrea.jcrc.models;

import static org.junit.Assert.*;
import org.junit.Test;

public class CardBuilderTest {

  private static final String EMPTY = "";
  private static final int ZERO = 0;

  @Test
  public void shouldCreateACardObjectWithDefaultValues() {
    Card card = new CardBuilder().build();
    assertEquals(ZERO, card.getNumber());
    assertEquals(EMPTY, card.getName());
    assertEquals(EMPTY, card.getSubclass());
    assertEquals(EMPTY, card.getSubclass());
    assertNotNull(card.getResponsabilities());
    assertEquals(ZERO , card.getResponsabilities().size());
    assertNotNull(card.getCollaborators());
    assertEquals(ZERO, card.getCollaborators().size());
  }
  
  @Test
  public void shouldAddOneResponsibilityPerLine() {
    Card card = new CardBuilder().withResponsabilities("line").build();
    assertEquals("line",card.getResponsabilities().get(0));
    assertEquals(1 , card.getResponsabilities().size());
    card = new CardBuilder().withResponsabilities(String.format("%s\n%s", "line1" , "line2")).build();
    assertEquals("line1",card.getResponsabilities().get(0));
    assertEquals("line2",card.getResponsabilities().get(1));
    assertEquals(2 , card.getResponsabilities().size());
    card = new CardBuilder().withResponsabilities(String.format("%s\n%s\n%s", "line1" , "line2","line3")).build();
    assertEquals("line1",card.getResponsabilities().get(0));
    assertEquals("line2",card.getResponsabilities().get(1));
    assertEquals("line3",card.getResponsabilities().get(2));
    assertEquals(3 , card.getResponsabilities().size());
  }

  @Test
  public void shouldAddOneCollaboratorPerLine() {
    Card card = new CardBuilder().withCollaborators("line").build();
    assertEquals("line",card.getCollaborators().get(0));
    assertEquals(1 , card.getCollaborators().size());
    card = new CardBuilder().withCollaborators(String.format("%s\n%s", "line1" , "line2")).build();
    assertEquals("line1",card.getCollaborators().get(0));
    assertEquals("line2",card.getCollaborators().get(1));
    assertEquals(2 , card.getCollaborators().size());
    card = new CardBuilder().withCollaborators(String.format("%s\n%s\n%s", "line1" , "line2","line3")).build();
    assertEquals("line1",card.getCollaborators().get(0));
    assertEquals("line2",card.getCollaborators().get(1));
    assertEquals("line3",card.getCollaborators().get(2));
    assertEquals(3 , card.getCollaborators().size());
  }
  
}
