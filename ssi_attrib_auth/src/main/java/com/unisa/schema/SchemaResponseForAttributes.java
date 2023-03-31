package com.unisa.schema;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SchemaResponseForAttributes {


    @JsonProperty
    private Schema schema;


    public SchemaResponseForAttributes(){

    }

    public SchemaResponseForAttributes(Schema schema) {
        this.schema = schema;
    }

    public Schema getSchema() {
        return schema;
    }

    public void setSchema(Schema schema) {
        this.schema = schema;
    }

    @Override
    public String toString() {
        return "SchemaResponseForAttributes{" +
                "schema='" + schema + '\'' +
                '}';
    }
}
