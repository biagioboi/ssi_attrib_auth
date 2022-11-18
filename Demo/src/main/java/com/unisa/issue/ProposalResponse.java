package com.unisa.issue;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProposalResponse {
    @JsonProperty
    private String role;
    @JsonProperty
    private String auto_offer;
    @JsonProperty
    private String auto_issue;
    @JsonProperty
    private String auto_remove;
    @JsonProperty
    private CredentialPreview cred_preview;
    @JsonProperty
    private String cred_ex_id;
    @JsonProperty
    private String conn_id;
    @JsonProperty
    private String state;
    @JsonProperty
    private String updated_at;
    @JsonProperty
    private String created_at;
    @JsonProperty
    private String initiator;

    public ProposalResponse() {
    }

    public ProposalResponse(String role, String auto_offer, String auto_issue, String auto_remove, CredentialPreview cred_preview, String cred_ex_id, String conn_id, String state, String updated_at, String created_at, String initiator) {
        this.role = role;
        this.auto_offer = auto_offer;
        this.auto_issue = auto_issue;
        this.auto_remove = auto_remove;
        this.cred_preview = cred_preview;
        this.cred_ex_id = cred_ex_id;
        this.conn_id = conn_id;
        this.state = state;
        this.updated_at = updated_at;
        this.created_at = created_at;
        this.initiator = initiator;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAuto_offer() {
        return auto_offer;
    }

    public void setAuto_offer(String auto_offer) {
        this.auto_offer = auto_offer;
    }

    public String getAuto_issue() {
        return auto_issue;
    }

    public void setAuto_issue(String auto_issue) {
        this.auto_issue = auto_issue;
    }

    public String getAuto_remove() {
        return auto_remove;
    }

    public void setAuto_remove(String auto_remove) {
        this.auto_remove = auto_remove;
    }

    public CredentialPreview getCred_preview() {
        return cred_preview;
    }

    public void setCred_preview(CredentialPreview cred_preview) {
        this.cred_preview = cred_preview;
    }

    public String getCred_ex_id() {
        return cred_ex_id;
    }

    public void setCred_ex_id(String cred_ex_id) {
        this.cred_ex_id = cred_ex_id;
    }

    public String getConn_id() {
        return conn_id;
    }

    public void setConn_id(String conn_id) {
        this.conn_id = conn_id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getInitiator() {
        return initiator;
    }

    public void setInitiator(String initiator) {
        this.initiator = initiator;
    }

    @Override
    public String toString() {
        return "ProposalResponse{" +
                "role='" + role + '\'' +
                ", auto_offer='" + auto_offer + '\'' +
                ", auto_issue='" + auto_issue + '\'' +
                ", auto_remove='" + auto_remove + '\'' +
                ", cred_preview=" + cred_preview +
                ", cred_ex_id='" + cred_ex_id + '\'' +
                ", conn_id='" + conn_id + '\'' +
                ", state='" + state + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", created_at='" + created_at + '\'' +
                ", initiator='" + initiator + '\'' +
                '}';
    }
}
