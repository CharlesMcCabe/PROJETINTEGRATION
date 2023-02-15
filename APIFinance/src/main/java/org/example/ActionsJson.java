package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import com.fasterxml.jackson.databind.JsonNode;
public class ActionsJson {
    private HashMap<String, JsonNode> actions;
    public ActionsJson(ArrayList<String> symboles) throws IOException {
        for(String symbole: symboles){
            ApiChercheur action = new ApiChercheur(symbole);
            actions.put(symbole, action.getActionJson());
        }
    }
    public HashMap<String, JsonNode> getActionsJson(){
        return actions;
    }
}
