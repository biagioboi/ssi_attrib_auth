package com.unisa.model;


import org.springframework.security.core.GrantedAuthority;

public  class Ruolo implements GrantedAuthority {
    private String nome;

    public Ruolo(String nome) {
        this.nome = nome;
    }



    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public String getAuthority() {
        return this.nome;
    }


}
