package com.maxicorrea.jcrc.views;

import static org.junit.Assert.*;
import org.junit.Test;
import com.maxicorrea.jcrc.models.JCrc;
import static org.mockito.Mockito.*;

public class NoCardPanelTest {

  @Test
  public void shouldShowAMessageIndicatingThatItDoesNotContainCards() {
    JCrc model = mock(JCrc.class);
    JCrcView mainView = new JCrcView(model);
    NoCardPanel cardPanel = new NoCardPanel(mainView);
    String expectedMessage = "You don't have any cards yet.";
    assertEquals(expectedMessage , cardPanel.getMessageText());
  }

  @Test
  public void aButtonShouldAddANewCard() {
    JCrc model = mock(JCrc.class);
    JCrcView mainView = new JCrcView(model);
    NoCardPanel cardPanel = new NoCardPanel(mainView);
    String expectedText = "New card";
    assertEquals(expectedText , cardPanel.getNewCardButtonText());
  }
  
}
