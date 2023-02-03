package com.unisa.schema;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SchemaResponse {

    @JsonProperty
    private String schema_id;
    @JsonProperty
    private Schema schema;
    @JsonProperty
    private int seqNo;

    public SchemaResponse(){

    }

    public SchemaResponse(String schema_id, Schema schema, int seqNo) {
        this.schema_id = schema_id;
        this.schema = schema;
        this.seqNo = seqNo;
    }

    public String getSchema_id() {
        return schema_id;
    }

    public void setSchema_id(String schema_id) {
        this.schema_id = schema_id;
    }

    public Schema getSchema() {
        return schema;
    }

    public void setSchema(Schema schema) {
        this.schema = schema;
    }

    public int getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(int seqNo) {
        this.seqNo = seqNo;
    }

    @Override
    public String toString() {
        return "SchemaResponse{" +
                "schema_id='" + schema_id + '\'' +
                ", schema=" + schema +
                ", seqNo=" + seqNo +
                '}';
    }
}
