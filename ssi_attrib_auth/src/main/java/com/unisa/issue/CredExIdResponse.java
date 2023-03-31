package com.unisa.issue;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class CredExIdResponse {
    @JsonProperty
    private ArrayList<Result> results;

    public CredExIdResponse() {
    }

    public CredExIdResponse(ArrayList<Result> results) {
        this.results = results;
    }

    public ArrayList<Result> getResults() {
        return results;
    }

    public void setResults(ArrayList<Result> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "CredExIdResponse{" +
                "results=" + results +
                '}';
    }
}
