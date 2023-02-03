package com.unisa.connection;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InvitationDetails {

    @JsonProperty
    private String created_at;
    @JsonProperty
    private String state;
    @JsonProperty
    private String updated_at;
    @JsonProperty
    private String their_role;
    @JsonProperty
    private String invitation_msg_id;
    @JsonProperty
    private String accept;
    @JsonProperty
    private String connection_id;
    @JsonProperty
    private String invitation_mode;
    @JsonProperty
    private String routing_state;
    @JsonProperty
    private String invitation_key;
    @JsonProperty
    private String rfc23_state;
    @JsonProperty
    private String their_label;

    @JsonProperty
    private String request_id;
    @JsonProperty
    private String my_did;


    @Override
    public String toString() {
        return "InvitationDetails{" +
                "created_at='" + created_at + '\'' +
                ", state='" + state + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", their_role='" + their_role + '\'' +
                ", invitation_msg_id='" + invitation_msg_id + '\'' +
                ", accept='" + accept + '\'' +
                ", connection_id='" + connection_id + '\'' +
                ", invitation_mode='" + invitation_mode + '\'' +
                ", routing_state='" + routing_state + '\'' +
                ", invitation_key='" + invitation_key + '\'' +
                ", rfc23_state='" + rfc23_state + '\'' +
                ", their_label='" + their_label + '\'' +
                ", request_id='" + request_id + '\'' +
                ", my_did='" + my_did + '\'' +
                '}';
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public String getMy_did() {
        return my_did;
    }

    public void setMy_did(String my_did) {
        this.my_did = my_did;
    }

    public InvitationDetails() {

    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
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

    public String getTheir_role() {
        return their_role;
    }

    public void setTheir_role(String their_role) {
        this.their_role = their_role;
    }

    public String getInvitation_msg_id() {
        return invitation_msg_id;
    }

    public void setInvitation_msg_id(String invitation_msg_id) {
        this.invitation_msg_id = invitation_msg_id;
    }

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = accept;
    }

    public String getConnection_id() {
        return connection_id;
    }

    public void setConnection_id(String connection_id) {
        this.connection_id = connection_id;
    }

    public String getInvitation_mode() {
        return invitation_mode;
    }

    public void setInvitation_mode(String invitation_mode) {
        this.invitation_mode = invitation_mode;
    }

    public String getRouting_state() {
        return routing_state;
    }

    public void setRouting_state(String routing_state) {
        this.routing_state = routing_state;
    }

    public String getInvitation_key() {
        return invitation_key;
    }

    public void setInvitation_key(String invitation_key) {
        this.invitation_key = invitation_key;
    }

    public String getRfc23_state() {
        return rfc23_state;
    }

    public void setRfc23_state(String rfc23_state) {
        this.rfc23_state = rfc23_state;
    }

    public String getTheir_label() {
        return their_label;
    }

    public void setTheir_label(String their_label) {
        this.their_label = their_label;
    }

}
