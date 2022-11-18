package com.unisa.connection;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DidRequest {

    @JsonProperty
    private String seed;
    @JsonProperty
    private String role;
    @JsonProperty
    private String alias;

    public DidRequest(){

    }

    public String getSeed() {
        return seed;
    }

    public String getRole() {
        return role;
    }

    public String getAlias() {
        return alias;
    }

    public void setSeed(String seed) {
        this.seed = seed;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public DidRequest(String seed, String role, String alias) {
        this.seed = seed;
        this.role = role;
        this.alias = alias;
    }
}
