package com.unisa.issue;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IssueResponseByFormatOfferIndy {
    @JsonProperty
    private String schema_id;
    @JsonProperty
    private String cred_def_id;
    @JsonProperty
    private IssueResponseByFormatOfferIndyKeyProof key_correctness_proof;

    public IssueResponseByFormatOfferIndy() {}

    public IssueResponseByFormatOfferIndy(String schema_id, String cred_def_id, IssueResponseByFormatOfferIndyKeyProof key_correctness_proof) {
        this.schema_id = schema_id;
        this.cred_def_id = cred_def_id;
        this.key_correctness_proof = key_correctness_proof;
    }

    public String getSchema_id() {
        return schema_id;
    }

    public void setSchema_id(String schema_id) {
        this.schema_id = schema_id;
    }

    public String getCred_def_id() {
        return cred_def_id;
    }

    public void setCred_def_id(String cred_def_id) {
        this.cred_def_id = cred_def_id;
    }

    public IssueResponseByFormatOfferIndyKeyProof getKey_correctness_proof() {
        return key_correctness_proof;
    }

    public void setKey_correctness_proof(IssueResponseByFormatOfferIndyKeyProof key_correctness_proof) {
        this.key_correctness_proof = key_correctness_proof;
    }

    @Override
    public String toString() {
        return "IssueResponseByFormatOfferIndy{" +
                "schema_id='" + schema_id + '\'' +
                ", cred_def_id='" + cred_def_id + '\'' +
                ", key_correctness_proof=" + key_correctness_proof +
                '}';
    }
}
