package com.unisa.issue;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Credential {
    @JsonProperty
    private String referent;
    @JsonProperty
    private Attribute attrs;
    @JsonProperty
    private String schema_id;
    @JsonProperty
    private String cred_def_id;
    @JsonProperty
    private String rev_reg_id;
    @JsonProperty
    private String cred_rev_id;

    public Credential() {
    }

    public Credential(String referent, Attribute attrs, String schema_id, String cred_def_id, String rev_reg_id, String cred_rev_id) {
        this.referent = referent;
        this.attrs = attrs;
        this.schema_id = schema_id;
        this.cred_def_id = cred_def_id;
        this.rev_reg_id = rev_reg_id;
        this.cred_rev_id = cred_rev_id;
    }

    public Attribute getAttrs() {
        return attrs;
    }

    public void setAttrs(Attribute attrs) {
        this.attrs = attrs;
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

    public String getRev_reg_id() {
        return rev_reg_id;
    }

    public void setRev_reg_id(String rev_reg_id) {
        this.rev_reg_id = rev_reg_id;
    }

    public String getCred_rev_id() {
        return cred_rev_id;
    }

    public void setCred_rev_id(String cred_rev_id) {
        this.cred_rev_id = cred_rev_id;
    }

    public String getReferent() {
        return referent;
    }

    public void setReferent(String referent) {
        this.referent = referent;
    }

    @Override
    public String toString() {
        return "Credential{" +
                "referent='" + referent + '\'' +
                ", attrs=" + attrs +
                ", schema_id='" + schema_id + '\'' +
                ", cred_def_id='" + cred_def_id + '\'' +
                ", rev_reg_id='" + rev_reg_id + '\'' +
                ", cred_rev_id='" + cred_rev_id + '\'' +
                '}';
    }
}
