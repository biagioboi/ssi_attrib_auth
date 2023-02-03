package com.unisa.issue;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CredentialPreview {

    @JsonProperty(value = "@type")
    @SerializedName("@type")
    private String type;
    @JsonProperty(value = "attributes")
    @SerializedName("attributes")
    private ArrayList<AttributeRequest> attributes;

    public CredentialPreview() {
    }

    public CredentialPreview(String type, ArrayList<AttributeRequest> attributes) {
        this.type = type;
        this.attributes = attributes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<AttributeRequest> getAttributes() {
        return attributes;
    }

    public void setAttributes(ArrayList<AttributeRequest> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "CredentialPreview{" +
                "type='" + type + '\'' +
                ", attributes=" + attributes +
                '}';
    }
}
