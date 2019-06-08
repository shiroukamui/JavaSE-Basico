package com.erosennin.amazonviewer.challenges;

public enum Day {

    SUNDAY("Domingo"),
    MONDAY("Lunes"),
    TUESDAY("Martes"),
    WEDNESDAY("Miercoles"),
    THURSDAY("Jueves"),
    FRIDAY("Viernes"),
    SATURDAY("Sabado");

    private String spanish;

    Day(String spanish) {
        this.spanish = spanish;
    }

    public String getSpanish() {
        return spanish;
    }
}
