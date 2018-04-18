package com.maxicorrea.jcrc.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Card {

  private int number;
  private String name;
  private String superclass;
  private String subclass;
  private Type type;
  private List<String> responsabilities;
  private List<String> collaborators;

  Card(CardBuilder builder) {
    this(builder.number, builder.name, builder.superclass, builder.subclass, builder.type,
        builder.responsabilitiesList, builder.collaboratorsList);
  }

  Card(int number, String name, String superclass, String subclass, Type type,
      List<String> responsabilities, List<String> collaborators) {
    this.number = number;
    this.name = name;
    this.superclass = superclass;
    this.subclass = subclass;
    this.type = type;
    this.responsabilities = responsabilities;
    this.collaborators = collaborators;
  }

  public void copyDataOf(Card other) {
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
    result = prime * result + ((collaborators == null) ? 0 : collaborators.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + number;
    result = prime * result + ((responsabilities == null) ? 0 : responsabilities.hashCode());
    result = prime * result + ((subclass == null) ? 0 : subclass.hashCode());
    result = prime * result + ((superclass == null) ? 0 : superclass.hashCode());
    result = prime * result + ((type == null) ? 0 : type.hashCode());
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
    if (collaborators == null && other.collaborators != null) {
      return false;
    } else if (!collaborators.equals(other.collaborators))
      return false;
    if (name == null && other.name != null) {
      return false;
    } else if (!name.equals(other.name))
      return false;
    if (number != other.number)
      return false;
    if (responsabilities == null && other.responsabilities != null) {
      return false;
    } else if (!responsabilities.equals(other.responsabilities))
      return false;
    if (subclass == null && other.subclass != null) {
      return false;
    } else if (!subclass.equals(other.subclass))
      return false;
    if (superclass == null && other.superclass != null) {
      return false;
    } else if (!superclass.equals(other.superclass))
      return false;
    return type == other.type;
  }

}
