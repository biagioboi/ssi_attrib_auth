package com.unisa.issue;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IssueResponseByFormat {
    @JsonProperty
    private IssueResponseByFormatOffer cred_offer;
    @JsonProperty
    private IssueResponseByFormatProposal cred_proposal;

    public IssueResponseByFormat() {}
    public IssueResponseByFormat(IssueResponseByFormatOffer cred_offer, IssueResponseByFormatProposal cred_proposal) {
        this.cred_offer = cred_offer;
        this.cred_proposal = cred_proposal;
    }

    public IssueResponseByFormatOffer getCred_offer() {
        return cred_offer;
    }

    public void setCred_offer(IssueResponseByFormatOffer cred_offer) {
        this.cred_offer = cred_offer;
    }

    public IssueResponseByFormatProposal getCred_proposal() {
        return cred_proposal;
    }

    public void setCred_proposal(IssueResponseByFormatProposal cred_proposal) {
        this.cred_proposal = cred_proposal;
    }

    @Override
    public String toString() {
        return "IssueResponseByFormat{" +
                "cred_offer=" + cred_offer +
                ", cred_proposal=" + cred_proposal +
                '}';
    }
}
