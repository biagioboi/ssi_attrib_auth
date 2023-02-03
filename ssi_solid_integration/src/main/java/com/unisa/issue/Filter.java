package com.unisa.issue;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Filter {
    @JsonProperty
    private Indy indy;

    public Filter() {
    }

    public Filter(Indy indy) {
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
        return "Filter{" +
                "indy=" + indy +
                '}';
    }
}
