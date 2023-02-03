package com.unisa.connection;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class ConnectionsResponse {

    @JsonProperty
    private ArrayList<InvitationDetails> results;

    public ConnectionsResponse(){

    }

    public ConnectionsResponse(ArrayList<InvitationDetails> results) {
        this.results = results;
    }

    public ArrayList<InvitationDetails> getResults() {
        return results;
    }

    public void setResults(ArrayList<InvitationDetails> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "ConnectionSResponse{" +
                "resuts=" + results +
                '}';
    }
}
