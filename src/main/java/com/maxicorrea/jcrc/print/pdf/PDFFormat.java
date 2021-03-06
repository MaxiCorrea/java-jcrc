package com.maxicorrea.jcrc.print.pdf;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import com.maxicorrea.jcrc.application.AppConfig;
import com.maxicorrea.jcrc.models.JCrc;
import com.maxicorrea.jcrc.print.Format;
import com.maxicorrea.jcrc.print.PrintException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;

public class PDFFormat implements Format {

  @Override
  public void print(JCrc model, String location) throws PrintException{
    try {
      JasperFillManager.fillReportToFile(AppConfig.url("cardjasper"), new HashMap<>(),
          new CardBeanDataSource(model).createReportDataSource());
      JasperExportManager.exportReportToPdfFile(AppConfig.url("cardjrprint"), addExtension(location));
      Files.delete(Paths.get(AppConfig.url("cardjrprint")));
    } catch(Exception jrex) {
      throw new PrintException();
    }
  }

  String addExtension(String location) {
    if (location.lastIndexOf(".pdf") == -1) {
      return location + ".pdf";
    }
    return location;
  }

}
