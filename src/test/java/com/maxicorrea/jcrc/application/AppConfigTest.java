package com.maxicorrea.jcrc.application;

import static org.junit.Assert.*;
import org.junit.Test;

public class AppConfigTest {

  @Test
  public void shouldReturnAllURLs() {
    assertNotNull(AppConfig.url("mini"));
    assertNotNull(AppConfig.url("close"));
    assertNotNull(AppConfig.url("app_icon"));
    assertNotNull(AppConfig.url("close"));
    assertNotNull(AppConfig.url("cardjasper"));
    assertNotNull(AppConfig.url("cardjrprint"));
  }

}
