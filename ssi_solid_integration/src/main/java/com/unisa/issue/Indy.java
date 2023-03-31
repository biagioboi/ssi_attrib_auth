package com.unisa.issue;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class Indy {

    @JsonProperty
    private String cred_def_id;
    @JsonProperty
    private String issuer_did;
    @JsonProperty
    private String schema_id;
    @JsonProperty
    private String schema_issuer_did;
    @JsonProperty
    private String schema_name;
    @JsonProperty
    private String schema_version;

    public Indy() {}

    public Indy(String cred_def_id, String issuer_did, String schema_id, String schema_issuer_did, String schema_name, String schema_version) {
        this.cred_def_id = cred_def_id;
        this.issuer_did = issuer_did;
        this.schema_id = schema_id;
        this.schema_issuer_did = schema_issuer_did;
        this.schema_name = schema_name;
        this.schema_version = schema_version;
    }

    public String getCred_def_id() {
        return cred_def_id;
    }

    public void setCred_def_id(String cred_def_id) {
        this.cred_def_id = cred_def_id;
    }

    public String getissuer_did() {
        return issuer_did;
    }

    public void setissuer_did(String issuer_did) {
        this.issuer_did = issuer_did;
    }

    public String getSchema_id() {
        return schema_id;
    }

    public void setSchema_id(String schema_id) {
        this.schema_id = schema_id;
    }

    public String getSchema_issuer_did() {
        return schema_issuer_did;
    }

    public void setSchema_issuer_did(String schema_issuer_did) {
        this.schema_issuer_did = schema_issuer_did;
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
        return "Indy{" +
                "cred_def_id='" + cred_def_id + '\'' +
                ", issuer_did='" + issuer_did + '\'' +
                ", schema_id='" + schema_id + '\'' +
                ", schema_issuer_did='" + schema_issuer_did + '\'' +
                ", schema_name='" + schema_name + '\'' +
                ", schema_version='" + schema_version + '\'' +
                '}';
    }
}

