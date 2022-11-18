package com.unisa.schema;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Schema {
    @JsonProperty
    private String ver;
    @JsonProperty
    private String id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String version;
    @JsonProperty
    private ArrayList<String> attrNames;

    public Schema(){

    }

    public Schema(String ver, String id, String name, String version, ArrayList<String> attrNames) {
        this.ver = ver;
        this.id = id;
        this.name = name;
        this.version = version;
        this.attrNames = attrNames;
    }

    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public ArrayList<String> getAttrNames() {
        return attrNames;
    }

    public void setAttrNames(ArrayList<String> attrNames) {
        this.attrNames = attrNames;
    }

    @Override
    public String toString() {
        return "Schema{" +
                "ver='" + ver + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", version='" + version + '\'' +
                ", attrNames=" + attrNames +
                '}';
    }
}
