package com.unisa.issue;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {
    @JsonProperty
    private CredeExRecord cred_ex_record;

    public Result(CredeExRecord cred_ex_record) {
        this.cred_ex_record = cred_ex_record;
    }

    public Result() {
    }

    public CredeExRecord getCredential_exchange_id() {
        return cred_ex_record;
    }

    public void setCredential_exchange_id(CredeExRecord cred_ex_record) {
        this.cred_ex_record = cred_ex_record;
    }

    @Override
    public String toString() {
        return "Result{" +
                "cred_ex_record=" + cred_ex_record +
                '}';
    }
}
