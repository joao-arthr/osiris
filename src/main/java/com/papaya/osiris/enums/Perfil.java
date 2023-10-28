package com.papaya.osiris.enums;

import lombok.Getter;

@Getter
public enum Perfil {
    ADMIN("admin"),
    PRODUTOR("produtor"),
    USUARIO("usuario");

    private String role;

    Perfil(String role){
        this.role = role;
    }

}
