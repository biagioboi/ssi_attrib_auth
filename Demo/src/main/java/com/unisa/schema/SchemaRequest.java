package com.unisa.schema;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class SchemaRequest {

    @JsonProperty
    private ArrayList<String> attributes;
    @JsonProperty
    private String schema_name;
    @JsonProperty
    private String schema_version;
    public SchemaRequest(){}

    public SchemaRequest(ArrayList<String> attributes, String schema_name, String schema_version) {
        this.attributes = attributes;
        this.schema_name = schema_name;
        this.schema_version = schema_version;
    }

    public ArrayList<String> getAttributes() {
        return attributes;
    }

    public void setAttributes(ArrayList<String> attributes) {
        this.attributes = attributes;
    }

    public String getSchema_name() {
        return schema_name;
    }

    public void setSchema_name(String schema_name) {
        this.schema_name = schema_name;
    }

    public String getSchema_version() {
        return schema_version;
    }

    public void setSchema_version(String schema_version) {
        this.schema_version = schema_version;
    }

    @Override
    public String toString() {
        return "Schema{" +
                "attributes=" + attributes +
                ", schema_name='" + schema_name + '\'' +
                ", schema_version=" + schema_version +
                '}';
    }
}
