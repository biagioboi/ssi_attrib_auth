package com.unisa.connection;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class InvitationRequest {

    @JsonProperty
    private ArrayList<String> handshake_protocols;

    @JsonProperty
    private boolean use_public_did;

    public InvitationRequest(){

    }

    public InvitationRequest(ArrayList<String> handshake_protocols, boolean use_public_did) {
        this.handshake_protocols = handshake_protocols;
        this.use_public_did = use_public_did;
    }

    public ArrayList<String> getHandshake_protocols() {
        return handshake_protocols;
    }

    public void setHandshake_protocols(ArrayList<String> handshake_protocols) {
        this.handshake_protocols = handshake_protocols;
    }

    public boolean isUse_public_did() {
        return use_public_did;
    }

    public void setUse_public_did(boolean use_public_did) {
        this.use_public_did = use_public_did;
    }

    @Override
    public String toString() {
        return "InvitationRequest{" +
                "handshake_protocols=" + handshake_protocols +
                ", use_public_did=" + use_public_did +
                '}';
    }
}
