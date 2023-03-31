package com.unisa.issue;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class AttributeRequest {

    @JsonProperty(value = "mime-type")
    @SerializedName("mime-type")
    private String mime_type;
    @JsonProperty(value = "name")
    @SerializedName("name")
    private String name;
    @JsonProperty(value = "value")
    @SerializedName("value")
    private String value;

    public AttributeRequest() {
    }

    public AttributeRequest(String mime_type, String name, String value) {
        this.mime_type = mime_type;
        this.name = name;
        this.value = value;
    }

    public String getMime_type() {
        return mime_type;
    }

    public void setMime_type(String mime_type) {
        this.mime_type = mime_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Attribute{" +
                "mime_type='" + mime_type + '\'' +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
