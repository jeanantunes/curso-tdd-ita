package com.jotait.model;

public class CamelCase {

    private String texto;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "CamelCase{" +
                "texto='" + texto + '\'' +
                '}';
    }
}
