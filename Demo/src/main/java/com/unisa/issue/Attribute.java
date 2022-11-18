package com.unisa.issue;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class Attribute {

    @JsonProperty(value = "password")
    @SerializedName("password")
    private String password;
    @JsonProperty(value = "username")
    @SerializedName("username")
    private String username;
    @JsonProperty(value = "ruolo")
    @SerializedName("ruolo")
    private String ruolo;

    public Attribute() {
    }

    public Attribute(String password, String username, String ruolo) {
        this.password = password;
        this.username = username;
        this.ruolo = ruolo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    @Override
    public String toString() {
        return "Attribute{" +
                "mime_type='" + password + '\'' +
                ", name='" + username + '\'' +
                ", value='" + ruolo + '\'' +
                '}';
    }
}
