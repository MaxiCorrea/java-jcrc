package com.maxicorrea.jcrc.views;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class ExportPanelTest {

  @Test
  public void shouldBeAbleToSetTheExportedContent() {
    JCrcView view = mock(JCrcView.class);
    ExportPanel exportPanel = new ExportPanel(view);
    String expectedText = "Expected Text";
    exportPanel.setText(expectedText);
    assertEquals(expectedText , exportPanel.getText());
  }

}
