package com.example.loginprueba;

public class Cotizacion {
    String tipoProducto, tipoMaterial, detalles;
    String largo, ancho, alto, numero;

    public Cotizacion(String id, String tipoProducto, String tipoMaterial, String detalles, String largo, String ancho, String alto, String numero) {
        this.tipoProducto = tipoProducto;
        this.tipoMaterial = tipoMaterial;
        this.detalles = detalles;
        this.largo = largo;
        this.ancho = ancho;
        this.alto = alto;
        this.numero = numero;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public String getTipoMaterial() {
        return tipoMaterial;
    }

    public String getDetalles() {
        return detalles;
    }

    public String getLargo() {
        return largo;
    }

    public String getAncho() {
        return ancho;
    }

    public String getAlto() {
        return alto;
    }

    public String getNumero() {
        return numero;
    }
}
