package com.maxicorrea.jcrc.models;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class CardTest {

  @Test
  public void test() {
    Card card1 = new Card.Builder().build();
    Card card2 = new Card.Builder().build();
    assertTrue(card1.hashCode() == card2.hashCode());
  }
  
}
