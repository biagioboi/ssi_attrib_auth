package com.unisa.issue;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class IssueResponseByFormatOfferIndyKeyProof {
    @JsonProperty
    private String c;
    @JsonProperty
    private String xz_cap;
    @JsonProperty
    private ArrayList<ArrayList<String>> xr_cap;
    @JsonProperty
    private String nonce;

    public IssueResponseByFormatOfferIndyKeyProof() {}
    public IssueResponseByFormatOfferIndyKeyProof(String c, String xz_cap, ArrayList<ArrayList<String>> xr_cap, String nonce) {
        this.c = c;
        this.xz_cap = xz_cap;
        this.xr_cap = xr_cap;
        this.nonce = nonce;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getXz_cap() {
        return xz_cap;
    }

    public void setXz_cap(String xz_cap) {
        this.xz_cap = xz_cap;
    }

    public ArrayList<ArrayList<String>> getXr_cap() {
        return xr_cap;
    }

    public void setXr_cap(ArrayList<ArrayList<String>> xr_cap) {
        this.xr_cap = xr_cap;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    @Override
    public String toString() {
        return "IssueResponseByFormatOfferIndyKeyProof{" +
                "c='" + c + '\'' +
                ", xz_cap='" + xz_cap + '\'' +
                ", xr_cap=" + xr_cap +
                ", nonce='" + nonce + '\'' +
                '}';
    }
}
