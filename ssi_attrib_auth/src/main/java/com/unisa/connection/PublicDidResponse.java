package com.unisa.connection;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PublicDidResponse {
    @JsonProperty
    private String did;
    @JsonProperty
    private String verkey;
    @JsonProperty
    private String posture;
    @JsonProperty
    private String key_type;
    @JsonProperty
    private String method;

    public PublicDidResponse() {}

    public PublicDidResponse(String result, String verkey, String posture, String key_type, String method) {
        this.did = result;
        this.verkey = verkey;
        this.posture = posture;
        this.key_type = key_type;
        this.method = method;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getVerkey() {
        return verkey;
    }

    public void setVerkey(String verkey) {
        this.verkey = verkey;
    }

    public String getPosture() {
        return posture;
    }

    public void setPosture(String posture) {
        this.posture = posture;
    }

    public String getKey_type() {
        return key_type;
    }

    public void setKey_type(String key_type) {
        this.key_type = key_type;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String toString() {
        return "PublicDidResponse{" +
                "did='" + did + '\'' +
                ", verkey='" + verkey + '\'' +
                ", posture='" + posture + '\'' +
                ", key_type='" + key_type + '\'' +
                ", method='" + method + '\'' +
                '}';
    }
}
