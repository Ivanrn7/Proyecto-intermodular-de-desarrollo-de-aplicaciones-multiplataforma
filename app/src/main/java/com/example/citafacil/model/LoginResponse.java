
package com.example.citafacil.model;

public class LoginResponse {

    private String token;
    private String tipo;
    private long expiraEn;

    public String getToken() {
        return token;
    }

    public String getTipo() {
        return tipo;
    }

    public long getExpiraEn() {
        return expiraEn;
    }
}
