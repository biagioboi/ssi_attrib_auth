package com.unisa.issue;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IssueRequest {
    @JsonProperty
    private String comment;
    @JsonProperty
    private String connection_id;
    @JsonProperty
    private CredentialPreview credential_preview;

    @JsonProperty
    private boolean auto_issue;

    @JsonProperty
    private boolean auto_remove;

    @JsonProperty
    private Filter filter;

    public IssueRequest() {
    }

    public IssueRequest(String comment, String connection_id, CredentialPreview credential_preview, boolean auto_issue, boolean auto_remove, Filter filter) {
        this.comment = comment;
        this.connection_id = connection_id;
        this.credential_preview = credential_preview;
        this.auto_issue = auto_issue;
        this.auto_remove = auto_remove;
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

    public boolean isAuto_issue() {
        return auto_issue;
    }

    public void setAuto_issue(boolean auto_issue) {
        this.auto_issue = auto_issue;
    }

    public boolean isAuto_remove() {
        return auto_remove;
    }

    public void setAuto_remove(boolean auto_remove) {
        this.auto_remove = auto_remove;
    }

    @Override
    public String toString() {
        return "ProposalRequest{" +
                "comment='" + comment + '\'' +
                ", auto_issue='" + auto_issue + '\'' +
                ", auto_remove='" + auto_remove + '\'' +
                ", connection_id='" + connection_id + '\'' +
                ", credential_preview=" + credential_preview +
                ", filter=" + filter +
                '}';
    }
}
