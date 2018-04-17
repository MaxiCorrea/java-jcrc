package com.maxicorrea.jcrc.export;

import org.json.simple.JSONObject;
import com.maxicorrea.jcrc.models.Card;
import com.maxicorrea.jcrc.models.JCrc;

class JSONFormat implements Format {

  private static final String NAME_FORMAT = "JSON Format";

  @Override
  public String getName() {
    return NAME_FORMAT;
  }

  @SuppressWarnings("unchecked")
  @Override
  public String exportToString(JCrc model) {
    JSONObject jsonObject = new JSONObject();
    StringBuilder out = new StringBuilder("[ \n");
    for( int index = 0 ; index < model.getAllCards().size() ; ++index) {
      Card card = model.getAllCards().get(index);
      jsonObject.put("responsibilities", card.getResponsabilities());
      jsonObject.put("collaborators", card.getCollaborators());
      jsonObject.put("name", card.getName());
      jsonObject.put("superclass", card.getSubclass());
      jsonObject.put("subclass", card.getSubclass());
      jsonObject.put("type", card.getType().toString());
      out.append(jsonObject.toJSONString()).append("\n");
      if(index + 1 < model.getAllCards().size()) {
        out.append(",\n");
      }
    }
    StringBuilder b = new StringBuilder();
    for(char x : out.toString().toCharArray()) {
      if(x == ',') {
        b.append("\n");
      }
      b.append(x);
    }
    b.append("]").append("\n");
    return b.toString();
  }

}
