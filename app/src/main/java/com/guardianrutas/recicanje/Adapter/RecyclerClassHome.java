package com.guardianrutas.recicanje.Adapter;

public class RecyclerClassHome {

    int categoria;
    String imagen;
    String texto;
    String titulo;

    public RecyclerClassHome() {
    }

    public RecyclerClassHome(int categoria, String imagen, String texto, String titulo) {
        this.categoria = categoria;
        this.imagen = imagen;
        this.texto = texto;
        this.titulo = titulo;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
