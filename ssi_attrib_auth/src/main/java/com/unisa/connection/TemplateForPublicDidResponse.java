package com.unisa.connection;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TemplateForPublicDidResponse {

    @JsonProperty
    private PublicDidResponse result;

    public TemplateForPublicDidResponse() {}
    public TemplateForPublicDidResponse(PublicDidResponse result) {
        this.result = result;
    }

    public PublicDidResponse getResult() {
        return result;
    }

    public void setResult(PublicDidResponse result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "TemplateForPublicDidResponse{" +
                "result=" + result +
                '}';
    }
}
