package com.maxicorrea.jcrc.print.pdf;

import java.util.List;
import com.maxicorrea.jcrc.models.Card;

public class CardBean {

  private String name;
  private String superclass;
  private String subclass;
  private String type;
  private String responsibilities;
  private String collaborators;

  public CardBean() {
    super();
  }

  public CardBean(Card card) {
    name = card.getName();
    superclass = card.getSuperclass();
    subclass = card.getSubclass();
    type = card.getType().toString();
    responsibilities = parse(card.getResponsabilities());
    collaborators = parse(card.getCollaborators());
  }

  private String parse(List<String> lines) {
    StringBuilder builder = new StringBuilder();
    for (String line : lines) {
      builder.append(" * ").append(line).append("\n");
    }
    return builder.toString();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSuperclass() {
    return superclass;
  }

  public void setSuperclass(String superclass) {
    this.superclass = superclass;
  }

  public String getSubclass() {
    return subclass;
  }

  public void setSubclass(String subclass) {
    this.subclass = subclass;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getResponsibilities() {
    return responsibilities;
  }

  public void setResponsibilities(String responsibilities) {
    this.responsibilities = responsibilities;
  }

  public String getCollaborators() {
    return collaborators;
  }

  public void setCollaborators(String collaborators) {
    this.collaborators = collaborators;
  }

}
