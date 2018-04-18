package com.maxicorrea.jcrc.views.utils;

import static org.junit.Assert.*;
import org.junit.Test;
import com.maxicorrea.jcrc.application.AppConfig;

public class IconLoaderTest {

  @Test
  public void shouldLoadAllIcons() {
    assertNotNull(IconLoader.load(AppConfig.url("close")));
    assertNotNull(IconLoader.load(AppConfig.url("mini")));
  }
  
}
