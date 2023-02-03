package com.unisa.issue;
import com.fasterxml.jackson.annotation.JsonProperty;
public class IssueRequest {

    @JsonProperty
    private String addr;
    @JsonProperty
    private ProposalRequest proposalRequest;

    public IssueRequest() {
    }

    public IssueRequest(String addr, ProposalRequest proposalRequest) {
        this.addr = addr;
        this.proposalRequest = proposalRequest;
    }

    public String getAddr() {
        return addr;
    }

    public ProposalRequest getProposalRequest() {
        return proposalRequest;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public void setProposalRequest(ProposalRequest proposalRequest) {
        this.proposalRequest = proposalRequest;
    }

    @Override
    public String toString() {
        return "IssueRequest{" +
                "addr='" + addr + '\'' +
                ", proposalRequest=" + proposalRequest +
                '}';
    }
}
