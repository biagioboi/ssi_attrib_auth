package com.unisa.issue;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IssueResponseByFormatProposal {
    @JsonProperty
    private Indy indy;

    public IssueResponseByFormatProposal() {}

    public IssueResponseByFormatProposal(Indy indy) {
        this.indy = indy;
    }

    public Indy getIndy() {
        return indy;
    }

    public void setIndy(Indy indy) {
        this.indy = indy;
    }

    @Override
    public String toString() {
        return "IssueResponseByFormatProposalIndy{" +
                "indy=" + indy +
                '}';
    }
}
