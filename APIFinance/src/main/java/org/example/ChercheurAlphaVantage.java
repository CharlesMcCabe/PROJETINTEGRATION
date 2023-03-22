package org.example;

import java.io.IOException;

public class ChercheurAlphaVantage extends ApiChercheur{
    public ChercheurAlphaVantage(String symbole) throws IOException {
        this.symbole = symbole;
        this.url ="https://www.alphavantage.co/query?function=TIME_SERIES_WEEKLY&symbol=" + symbole + "&apikey=G7JEWLBGCCURCQX8";
        trouverJson();

        action = new Action(actionJson);

    }



}
