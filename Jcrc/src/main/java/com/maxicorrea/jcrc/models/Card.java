package com.maxicorrea.jcrc.models;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

public class Card {

  private int number;
  private String name;
  private String superclass;
  private String subclass;
  private Type type;
  private Set<String> responsabilities;
  private Set<String> collaborators;

  public static class Builder {

    private int number = 0;
    private String name = "";
    private String superclass = "";
    private String subclass = "";
    private Type type = Type.NORMAL;
    private Set<String> responsabilities = new HashSet<>();
    private Set<String> collaborators = new HashSet<>();

    public Builder withNumber(int number) {
      this.number = number;
      return this;
    }

    public Builder withName(String name) {
      this.name = name;
      return this;
    }

    public Builder withSuperClass(String superclass) {
      this.superclass = superclass;
      return this;
    }

    public Builder withSubClass(String subclass) {
      this.subclass = subclass;
      return this;
    }

    public Builder withType(Type type) {
      this.type = type;
      return this;
    }

    public Builder withResponsabilities(String responsabilities) {
      for (String responsibility : responsabilities.trim().split("[\n]")) {
        this.responsabilities.add(responsibility);
      }
      return this;
    }

    public Builder withCollaborators(String collaborators) {
      for (String colaborator : collaborators.trim().split("[\n]")) {
        this.collaborators.add(colaborator);
      }
      return this;
    }

    public Card build() {
      return new Card(this);
    }

  }

  private Card(Builder builder) {
    this.number = builder.number;
    this.name = builder.name;
    this.type = builder.type;
    this.superclass = builder.superclass;
    this.subclass = builder.subclass;
    this.collaborators = builder.collaborators;
    this.responsabilities = builder.responsabilities;
  }

  public void copyDataOf(Card other) {
    this.name = other.getName();
    this.superclass = other.getSuperclass();
    this.subclass = other.getSubclass();
    this.type = other.getType();
    this.responsabilities = new HashSet<>(other.responsabilities);
    this.collaborators = new HashSet<>(other.collaborators);
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

  public Set<String> getResponsabilities() {
    return Collections.unmodifiableSet(responsabilities);
  }

  public Set<String> getCollaborators() {
    return Collections.unmodifiableSet(collaborators);
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
    final Card other = (Card) obj;
    return Integer.compare(number, other.number) == 0 && Objects.equals(name, other.name)
        && Objects.equals(type, other.type) && Objects.equals(superclass, other.superclass)
        && Objects.equals(subclass, other.subclass)
        && Objects.equals(collaborators, other.collaborators)
        && Objects.equals(responsabilities, other.responsabilities);
  }

}
