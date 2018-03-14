package com.example.isaque.rondadigital.objetos;

/**
 * Created by isaque on 14/03/18.
 */

public class Usuario {
    private String email, senha;
    private int permissao;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getPermissao() {
        return permissao;
    }

    public void setPermissao(int permissao) {
        this.permissao = permissao;
    }
}
