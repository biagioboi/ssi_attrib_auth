package com.unisa.issue;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IssueResponse {

    @JsonProperty
    private String initiator;

    @JsonProperty
    private String cred_ex_id;

    @JsonProperty
    private IssueResponseByFormat by_format;

    @JsonProperty
    private boolean auto_remove;

    @JsonProperty
    private String created_at;

    @JsonProperty
    private String role;

    public IssueResponse() {}
    public IssueResponse(String initiator, String cred_ex_id, IssueResponseByFormat by_format, boolean auto_remove, String created_at, String role) {
        this.initiator = initiator;
        this.cred_ex_id = cred_ex_id;
        this.by_format = by_format;
        this.auto_remove = auto_remove;
        this.created_at = created_at;
        this.role = role;
    }

    public String getInitiator() {
        return initiator;
    }

    public void setInitiator(String initiator) {
        this.initiator = initiator;
    }

    public String getCred_ex_id() {
        return cred_ex_id;
    }

    public void setCred_ex_id(String cred_ex_id) {
        this.cred_ex_id = cred_ex_id;
    }

    public IssueResponseByFormat getBy_format() {
        return by_format;
    }

    public void setBy_format(IssueResponseByFormat by_format) {
        this.by_format = by_format;
    }

    public boolean isAuto_remove() {
        return auto_remove;
    }

    public void setAuto_remove(boolean auto_remove) {
        this.auto_remove = auto_remove;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "IssueResponse{" +
                "initiator='" + initiator + '\'' +
                ", cred_ex_id='" + cred_ex_id + '\'' +
                ", by_format=" + by_format +
                ", auto_remove=" + auto_remove +
                ", created_at='" + created_at + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
