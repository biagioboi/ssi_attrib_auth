package com.unisa.issue;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class CredentialList {
    @JsonProperty
    ArrayList<Credential> results;

    public CredentialList() {
    }

    public CredentialList(ArrayList<Credential> results) {
        this.results = results;
    }

    public ArrayList<Credential> getResults() {
        return results;
    }

    public void setResults(ArrayList<Credential> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "CredentialList{" +
                "results=" + results +
                '}';
    }
}
