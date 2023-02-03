package com.unisa.connection;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Invitation {

    @JsonProperty(value = "@type")
    private String type;


    @JsonProperty(value = "@id")
    private String id;

    @JsonProperty
    private String label;

    public Invitation(String type, String id, String label) {
        this.type = type;
        this.id = id;
        this.label = label;
    }

    public Invitation() {
    }

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

    @Override
    public String toString() {
        return "Invitation{" +
                "type='" + type + '\'' +
                ", id='" + id + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}
