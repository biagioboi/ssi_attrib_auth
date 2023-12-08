package com.unisa.issue;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IssueResponseByFormatOffer {

    @JsonProperty
    private IssueResponseByFormatOfferIndy indy;

    public IssueResponseByFormatOffer() {}

    public IssueResponseByFormatOffer(IssueResponseByFormatOfferIndy indy) {
        this.indy = indy;
    }

    public IssueResponseByFormatOfferIndy getIndy() {
        return indy;
    }

    public void setIndy(IssueResponseByFormatOfferIndy indy) {
        this.indy = indy;
    }

    @Override
    public String toString() {
        return "IssueResponseByFormatOffer{" +
                "indy=" + indy +
                '}';
    }
}
