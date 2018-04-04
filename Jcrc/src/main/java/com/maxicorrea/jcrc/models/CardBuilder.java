package com.maxicorrea.jcrc.models;

import java.util.ArrayList;
import java.util.List;

public class CardBuilder {

  int number;
  String name;
  String superclass;
  String subclass;
  Type type;
  List<String> responsabilities;
  List<String> collaborators;

  public CardBuilder() {
    name = "";
    superclass = "";
    subclass = "";
    type = Type.NORMAL;
    responsabilities = new ArrayList<>();
    collaborators = new ArrayList<>();
  }

  public CardBuilder withNumber(int number) {
    this.number = number;
    return this;
  }

  public CardBuilder withName(String name) {
    this.name = name;
    return this;
  }

  public CardBuilder withSuperclass(String superclass) {
    this.superclass = superclass;
    return this;
  }

  public CardBuilder withSubclass(String subclass) {
    this.subclass = subclass;
    return this;
  }

  public CardBuilder withType(Type type) {
    this.type = type;
    return this;
  }

  public CardBuilder withResponsability(String responsability) {
    responsabilities.add(responsability);
    return this;
  }

  public CardBuilder withCollaborator(String collaborator) {
    collaborators.add(collaborator);
    return this;
  }

  public Card build() {
    return new Card(this);
  }

}
