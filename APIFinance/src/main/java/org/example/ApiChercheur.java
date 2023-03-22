package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class ApiChercheur {

    protected JsonNode actionJson;
    protected String symbole;
    protected Action action;
    protected String url;

    public ApiChercheur() throws IOException {

    }

    public void trouverJson() {


        try {

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
