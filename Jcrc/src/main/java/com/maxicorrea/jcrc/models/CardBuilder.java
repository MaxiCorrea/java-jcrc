package com.maxicorrea.jcrc.models;

import java.util.ArrayList;
import java.util.List;

public class CardBuilder {

  int number;
  String name;
  String superclass;
  String subclass;
  Type type;
  List<String> responsabilitiesList;
  List<String> collaboratorsList;

  public CardBuilder() {
    name = "";
    superclass = "";
    subclass = "";
    type = Type.NORMAL;
    responsabilitiesList = new ArrayList<>();
    collaboratorsList = new ArrayList<>();
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

  public CardBuilder withResponsabilities(String responsabilities) {
    for(String responsibility : responsabilities.trim().split("[\n]")) {
      responsabilitiesList.add(responsibility);
    }
    return this;
  }

  public CardBuilder withCollaborators(String collaborators) {
    for(String colaborator : collaborators.trim().split("[\n]")) {
      collaboratorsList.add(colaborator);
    }
    return this;
  }

  public Card build() {
    return new Card(this);
  }

}
