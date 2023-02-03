package com.unisa.connection;

import com.fasterxml.jackson.annotation.JsonProperty;


public class InvitationResponse {


    @JsonProperty
    private Invitation invitation;

    @JsonProperty
    private String invitation_url;

    public InvitationResponse() {
    }

    public InvitationResponse(Invitation invitation) {
        this.invitation = invitation;
    }


    public Invitation getInvitation() {
        return invitation;
    }

    public void setInvitation(Invitation invitation,String invitation_url) {
        this.invitation = invitation;
        this.invitation_url = invitation_url;
    }

    public void setInvitation(Invitation invitation) {
        this.invitation = invitation;
    }

    public String getInvitation_url() {
        return invitation_url;
    }

    public void setInvitation_url(String invitation_url) {
        this.invitation_url = invitation_url;
    }

    @Override
    public String toString() {
        return "InvitationResponse{" +
                "invitation=" + invitation +
                ", invitation_url='" + invitation_url + '\'' +
                '}';
    }
}
