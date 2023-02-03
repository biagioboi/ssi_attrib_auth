package com.unisa.connection;
import com.fasterxml.jackson.annotation.JsonProperty;
public class Addr {
    @JsonProperty
    String addr;

    public Addr(){

    }

    public Addr(String addr) {
        this.addr = addr;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
