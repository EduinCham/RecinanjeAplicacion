package com.guardianrutas.recicanje.Adapter;

import java.lang.ref.SoftReference;

public class RecyclerClassCategory {


    int cantidad;
    String id;
    String identificador;
    String imagen;
    String texto;

    public RecyclerClassCategory() {
    }

    public RecyclerClassCategory(int cantidad, String id, String identificador, String imagen, String texto) {
        this.cantidad = cantidad;
        this.id = id;
        this.identificador = identificador;
        this.imagen = imagen;
        this.texto = texto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
