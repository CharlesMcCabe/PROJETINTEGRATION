package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class ApiChercheur {
    private JsonNode actionJson;
    private String symbole;

    public ApiChercheur(String symbole) throws IOException {
        this.symbole = symbole;
        trouverJson(symbole);
    }

    public void trouverJson(String symbol) {
        try {
            // AlphaVantage API endpoint URL
            String url = "https://www.alphavantage.co/query";

            // API parameters
            String function = "TIME_SERIES_DAILY_ADJUSTED";
            String apiKey = "G7JEWLBGCCURCQX8";

            // Build the URL with the parameters
            String fullUrl = String.format("%s?function=%s&symbol=%s&apikey=%s", url, function, symbol, apiKey);

            // Create the HTTP GET request
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(fullUrl);

            // Execute the request and get the response
            HttpResponse response = client.execute(request);

            // Get the response body as a String
            String responseBody = EntityUtils.toString(response.getEntity());

            // Convert the response to a JSON object using Jackson
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(responseBody);

            actionJson = jsonNode;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public JsonNode getActionJson() {

        return actionJson;
    }

}

