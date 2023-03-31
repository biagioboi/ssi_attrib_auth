package com.unisa.schema;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SchemaRequestForAttributes {

    @JsonProperty
    private String schema_id;

    public SchemaRequestForAttributes(){

    }

    public SchemaRequestForAttributes(String schema_id) {
        this.schema_id = schema_id;
    }

    public String getSchema_id() {
        return schema_id;
    }

    public void setSchema_id(String schema_id) {
        this.schema_id = schema_id;
    }

    @Override
    public String toString() {
        return "SchemaResponse{" +
                "schema_id='" + schema_id + '\'' +
                '}';
    }
}
