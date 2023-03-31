package com.unisa.schema;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CredentialDefinitionResonse {
    @JsonProperty
    private String credential_definition_id;

    public CredentialDefinitionResonse() {
    }

    public CredentialDefinitionResonse(String credential_definition_id) {
        this.credential_definition_id = credential_definition_id;
    }

    public String getCredential_definition_id() {
        return credential_definition_id;
    }

    public void setCredential_definition_id(String credential_definition_id) {
        this.credential_definition_id = credential_definition_id;
    }

    @Override
    public String toString() {
        return "CredentialDefinitionResonse{" +
                "credential_definition_id='" + credential_definition_id + '\'' +
                '}';
    }
}
