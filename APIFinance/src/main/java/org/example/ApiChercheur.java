package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;

public class ApiChercheur {
    private JsonNode actionJson;
    private String symbole;
    private Action action;

    public ApiChercheur(String symbole) throws IOException {
        this.symbole = symbole;
        trouverJson(symbole);
    }

    public void trouverJson(String symbol) {




            try {

            // AlphaVantage API endpoint URL
            String url = "https://api.twelvedata.com/time_series?symbol=" + symbol + "&interval=5min&apikey=e5805002196241eca2ec213f7506c6f1";

            // Create the HTTP GET request
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(url);

            // Execute the request and get the response
            HttpResponse response = client.execute(request);

            // Get the response body as a String
            String responseBody = EntityUtils.toString(response.getEntity());

            // Convert the response to a JSON object using Jackson
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(responseBody);

            String jsonString = jsonNode.toString();
            JsonNode priceNode = jsonNode.at("/values/0/close");
            Double price = priceNode.asDouble();
            System.out.println("Price of " + symbol + " is " + price);
action = new Action(jsonNode);


            actionJson = jsonNode;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public JsonNode getActionJson() {

        return actionJson;
    }

    public Action getAction() {

        return action;
    }
}

