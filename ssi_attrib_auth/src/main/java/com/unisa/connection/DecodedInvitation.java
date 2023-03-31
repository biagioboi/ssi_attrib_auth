package com.unisa.connection;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import com.unisa.schema.Service;

import java.util.ArrayList;

public class DecodedInvitation {

    @JsonProperty(value = "@type")
    @SerializedName("@type")
    private String type;
    @JsonProperty(value = "@id")
    @SerializedName("@id")
    private String id;
    @JsonProperty
    private ArrayList<String> handshake_protocols;
    @JsonProperty
    private String label;
    @JsonProperty
    private ArrayList<Service> services;


    public DecodedInvitation(String type, String id, ArrayList<String> handshake_protocols, String label, ArrayList<Service> service) {
        this.type = type;
        this.id = id;
        this.handshake_protocols = handshake_protocols;
        this.label = label;
        this.services = service;

    }
    public DecodedInvitation(){}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<String> getHandshake_protocols() {
        return handshake_protocols;
    }

    public void setHandshake_protocols(ArrayList<String> handshake_protocols) {
        this.handshake_protocols = handshake_protocols;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ArrayList<Service> getService() {
        return services;
    }

    public void setService(ArrayList<Service> service) {
        this.services = service;
    }


    @Override
    public String toString() {
        return "DecodedInvitation{" +
                "type='" + type + '\'' +
                ", id='" + id + '\'' +
                ", handshake_protocols=" + handshake_protocols +
                ", label='" + label + '\'' +
                ", services=" + services +
                '}';
    }
}
