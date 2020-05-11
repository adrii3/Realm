package com.example.realm.model;

import io.realm.RealmObject;

public class Liga extends RealmObject {

    private String nombreLiga;
    private String duracionLiga;

    public String getNombreLiga() {
        return nombreLiga;
    }

    public void setNombreLiga(String nombreLiga) {
        this.nombreLiga = nombreLiga;
    }

    public String getDuracionLiga() {
        return duracionLiga;
    }

    public void setDuracionLiga(String duracionLiga) {
        this.duracionLiga = duracionLiga;
    }


}
