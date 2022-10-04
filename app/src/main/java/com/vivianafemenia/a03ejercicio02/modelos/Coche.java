package com.vivianafemenia.a03ejercicio02.modelos;

import java.io.Serializable;

public class Coche implements Serializable {
    private String modelocoche;
    private String marcacoche;
    private String colorcoche;

    public Coche(String modelocoche, String marcacoche, String colorcoche) {
        this.modelocoche = modelocoche;
        this.marcacoche = marcacoche;
        this.colorcoche = colorcoche;
    }

    public String getModelocoche() {
        return modelocoche;
    }

    public void setModelocoche(String modelocoche) {
        this.modelocoche = modelocoche;
    }

    public String getMarcacoche() {
        return marcacoche;
    }

    public void setMarcacoche(String marcacoche) {
        this.marcacoche = marcacoche;
    }

    public String getColorcoche() {
        return colorcoche;
    }

    public void setColorcoche(String colorcoche) {
        this.colorcoche = colorcoche;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "modelocoche='" + modelocoche + '\'' +
                ", marcacoche='" + marcacoche + '\'' +
                ", colorcoche='" + colorcoche + '\'' +
                '}';
    }
}
