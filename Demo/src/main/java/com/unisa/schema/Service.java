package com.unisa.schema;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Service {
    @JsonProperty
    private String id;
    @JsonProperty
    private String type;
    @JsonProperty
    private ArrayList<String> recipientKeys;

    @JsonProperty
    private String serviceEndpoint;

    public Service(){

    }
    public Service(String id, String type, ArrayList<String> recipientKeys,String serviceEndpoint) {
        this.id = id;
        this.type = type;
        this.recipientKeys = recipientKeys;
        this.serviceEndpoint = serviceEndpoint;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<String> getRecipientKeys() {
        return recipientKeys;
    }

    public void setRecipientKeys(ArrayList<String> recipientKeys) {
        this.recipientKeys = recipientKeys;
    }

    public String getServiceEndpoint() {
        return serviceEndpoint;
    }

    public void setServiceEndpoint(String serviceEndpoint) {
        this.serviceEndpoint = serviceEndpoint;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", recipientKeys=" + recipientKeys +
                ", serviceEndpoint='" + serviceEndpoint + '\'' +
                '}';
    }
}
