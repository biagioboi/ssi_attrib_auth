package com.unisa.schema;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CredentialDefinitionRequest {
    @JsonProperty
    private String schema_id;
    @JsonProperty
    private String tag;


    public CredentialDefinitionRequest(String schema_id, String tag) {
        this.schema_id = schema_id;
        this.tag = tag;
    }

    public String getSchema_id() {
        return schema_id;
    }

    public void setSchema_id(String schema_id) {
        this.schema_id = schema_id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "CredentialDefinitionRequest{" +
                "schema_id='" + schema_id + '\'' +
                ", tag='" + tag + '\'' +
                '}';
    }
}
