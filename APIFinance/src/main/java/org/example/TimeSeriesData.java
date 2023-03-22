package org.example;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

public class TimeSeriesData {

    private String datetime;

    private String open;

    private String high;

    private String low;

    private String close;

    private String volume;
    private JsonNode values;
    public TimeSeriesData(JsonNode values) {
        this.values = values;
        datetime = values.get("datetime").asText();
        open = values.get("open").asText();
        high = values.get("high").asText();
        low = values.get("low").asText();
        close = values.get("close").asText();
        volume = values.get("volume").asText();

    }

    public String getDatetime() {
        return datetime;
    }

    public String getOpen() {
        return open;
    }

    public String getHigh() {
        return high;
    }

    public String getLow() {
        return low;
    }

    public String getClose() {
        return close;
    }

    public String getVolume() {
        return volume;
    }

    public JsonNode getValues() {
        return values;
    }
}
