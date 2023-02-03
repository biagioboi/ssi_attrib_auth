package com.unisa.issue;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProposalRequest {
    @JsonProperty
    private String comment;
    @JsonProperty
    private String connection_id;
    @JsonProperty
    private CredentialPreview credential_preview;
    @JsonProperty
    private Filter filter;

    public ProposalRequest() {
    }

    public ProposalRequest(String comment, String connection_id, CredentialPreview credential_preview, Filter filter) {
        this.comment = comment;
        this.connection_id = connection_id;
        this.credential_preview = credential_preview;
        this.filter = filter;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getConnection_id() {
        return connection_id;
    }

    public void setConnection_id(String connection_id) {
        this.connection_id = connection_id;
    }

    public CredentialPreview getCredential_preview() {
        return credential_preview;
    }

    public void setCredential_preview(CredentialPreview credential_preview) {
        this.credential_preview = credential_preview;
    }

    public Filter getFilter() {
        return filter;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    @Override
    public String toString() {
        return "ProposalRequest{" +
                "comment='" + comment + '\'' +
                ", connection_id='" + connection_id + '\'' +
                ", credentialPreview=" + credential_preview +
                ", filter=" + filter +
                '}';
    }
}
