package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class ApiChercheurTwelveData extends ApiChercheur{

    public ApiChercheurTwelveData(String symbole) throws IOException {
        super();
        this.symbole = symbole;
        this.url = "https://api.twelvedata.com/time_series?symbol=" + symbole + "&interval=5min&apikey=e5805002196241eca2ec213f7506c6f1";
        trouverJson();

        action = new Action(actionJson);

    }

    public JsonNode getActionJson() {

        return actionJson;
    }

    public Action getAction() {

        return action;
    }
}

