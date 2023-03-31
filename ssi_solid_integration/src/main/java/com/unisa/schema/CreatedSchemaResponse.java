package com.unisa.schema;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class CreatedSchemaResponse {

    @JsonProperty
    private ArrayList<String> schema_ids;

    public CreatedSchemaResponse() {}
    public CreatedSchemaResponse(ArrayList<String> schema_ids) {
        this.schema_ids= schema_ids;
    }

    public ArrayList<String> getSchema_ids() {
        return schema_ids;
    }

    public void setSchema_ids(ArrayList<String> schema_ids) {
        this.schema_ids = schema_ids;
    }

    @Override
    public String toString() {
        return "SchemaResponse{" +
                "schema_ids=" + schema_ids +
                '}';
    }
}
