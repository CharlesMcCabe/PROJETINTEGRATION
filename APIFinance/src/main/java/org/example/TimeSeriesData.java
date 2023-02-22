package org.example;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

public class TimeSeriesData {

    private String datetime;

    private double open;

    private double high;

    private double low;

    private double close;


    private double volume;
    private JsonNode values;
    public TimeSeriesData(JsonNode values) {
        this.values = values;
        datetime = values.get("/datetime").asText();
    }

}
