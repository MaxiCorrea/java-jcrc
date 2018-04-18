package com.maxicorrea.jcrc.print.pdf;

import static org.junit.Assert.*;
import org.junit.Test;
import com.maxicorrea.jcrc.models.CardBuilder;
import com.maxicorrea.jcrc.models.JCrc;

public class CardBeanDataSourceTest {

  private static final int ONE = 1;

  @Test
  public void shouldReturnACollectionOfBeansThatRepresentTheModelCards() {
    JCrc model = new JCrc();
    CardBeanDataSource beanDataSource = new CardBeanDataSource(model);
    assertTrue(beanDataSource.getBeanCollection().isEmpty());
    model.addNewCard(new CardBuilder().build());
    assertFalse(beanDataSource.getBeanCollection().isEmpty());
    assertEquals(ONE, beanDataSource.getBeanCollection().size());
  }

}
