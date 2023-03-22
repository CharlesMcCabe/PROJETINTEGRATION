package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Action {

    private String symbol;
    private String interval;

    private ArrayList<TimeSeriesData> data = new ArrayList<>();
    private JsonNode jsonNode;  // Json original
    private JsonNode chartData; // les Json avec les Values pour le graphique

    public Action(JsonNode jsonNode) {
        try {
            this.jsonNode = jsonNode;
            symbol = jsonNode.at("/meta/symbol").asText();
            interval = jsonNode.at("/meta/interval").asText();
            for (int i = 0; i < jsonNode.at("/values").size(); i++) {
                TimeSeriesData datav = new TimeSeriesData(jsonNode.at("/values/" + i));
                data.add(datav);
                getTime(data.get(i));
            }
            chartData = jsonNode.at("/values");
            createChart();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getTime(TimeSeriesData data) throws ParseException {

        String temps = data.getDatetime();
        temps = temps.replaceAll(" ", "T");

        return temps;
    }


    public void createChart() throws ScriptException, NoSuchMethodException, IOException {

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("Node.js");

        engine.eval(Files.newBufferedReader(Paths.get("D:\\Users\\2180454\\OneDrive - Collège de Bois-de-Boulogne\\Documents\\APIFinance\\src\\main\\java\\org\\example\\Chart.js"), StandardCharsets.UTF_8));
        Invocable inv = (Invocable) engine;

        inv.invokeFunction("createChart", chartData);
    }

    public JsonNode getChartData() {
        return chartData;
    }
}

