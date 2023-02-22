package org.example;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

public class Action {

    private String symbol;
    private String interval;

    private ArrayList<TimeSeriesData> data;
    private JsonNode jsonNode;


    public Action(JsonNode jsonNode) {
        try {
            this.jsonNode = jsonNode;
            symbol = jsonNode.at("/meta/symbol").asText();
            interval = jsonNode.at("/meta/interval").asText();
            JsonNode values = jsonNode.at("/values/0");
            ObjectMapper mapper = new ObjectMapper();
            for (int i = 0; i < jsonNode.at("/values").size(); i++) {
                TimeSeriesData datav = new TimeSeriesData(jsonNode.at("/values/" + i));
                data.add(datav);
            }

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
