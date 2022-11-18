package com.unisa.connection;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DidResponse {
    @JsonProperty
    private String did;
    @JsonProperty
    private String seed;
    @JsonProperty
    private String verkey;

    public DidResponse(){

    }

    public DidResponse(String did, String seed, String verkey) {
        this.did = did;
        this.seed = seed;
        this.verkey = verkey;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getSeed() {
        return seed;
    }

    public void setSeed(String seed) {
        this.seed = seed;
    }

    public String getVerkey() {
        return verkey;
    }

    public void setVerkey(String verkey) {
        this.verkey = verkey;
    }

    @Override
    public String toString() {
        return "DidResponse{" +
                "did='" + did + '\'' +
                ", seed='" + seed + '\'' +
                ", verkey='" + verkey + '\'' +
                '}';
    }
}
