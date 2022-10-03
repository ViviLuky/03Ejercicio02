package com.vivianafemenia.a03ejercicio02;

import java.io.Serializable;

public class Bici implements Serializable {
    private String marcabici;
    private String pulgadas;

    public Bici(String marcabici, String pulgadas) {
        this.marcabici = marcabici;
        this.pulgadas = pulgadas;
    }

    public String getMarcabici() {
        return marcabici;
    }

    public void setMarcabici(String marcabici) {
        this.marcabici = marcabici;
    }

    public String getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(String pulgadas) {
        this.pulgadas = pulgadas;
    }

    @Override
    public String toString() {
        return "Bici{" +
                "marcabici='" + marcabici + '\'' +
                ", pulgadas='" + pulgadas + '\'' +
                '}';
    }
}
