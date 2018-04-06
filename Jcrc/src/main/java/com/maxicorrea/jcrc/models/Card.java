package com.maxicorrea.jcrc.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Card  {

  private int number;
  private String name;
  private String superclass;
  private String subclass;
  private Type type;
  private List<String> responsabilities;
  private List<String> collaborators;

  Card(CardBuilder builder) {
    this.number = builder.number;
    this.name = builder.name;
    this.superclass = builder.superclass;
    this.subclass = builder.subclass;
    this.type = builder.type;
    this.responsabilities = builder.responsabilitiesList;
    this.collaborators = builder.collaboratorsList;
  }

  void copyDataOf(Card other) {
    this.name = other.getName();
    this.superclass = other.getSuperclass();
    this.subclass = other.getSubclass();
    this.type = other.getType();
    this.responsabilities = new ArrayList<>(other.getResponsabilities());
    this.collaborators = new ArrayList<>(other.getCollaborators());
  }

  public int getNumber() {
    return number;
  }

  void setNumber(int number) {
    this.number = number;
  }

  public String getName() {
    return name;
  }

  public String getSuperclass() {
    return superclass;
  }

  public String getSubclass() {
    return subclass;
  }

  public Type getType() {
    return type;
  }

  public List<String> getResponsabilities() {
    return Collections.unmodifiableList(responsabilities);
  }

  public List<String> getCollaborators() {
    return Collections.unmodifiableList(collaborators);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + number;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Card other = (Card) obj;
    return number == other.number;
  }

}
