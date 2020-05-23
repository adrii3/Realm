package com.example.realm.model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class Jugador extends RealmObject {

    @PrimaryKey
    private int idJugador;
    private String nombre;
    private String apellido;
    private int edad;
    private int telefono;
    private String dni;
    private String equipo;

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public String setNombre(String nombre) {
        this.nombre = nombre;
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public RealmList<Liga> getLigas() {
        return ligas;
    }

    public void setLigas(RealmList<Liga> ligas) {
        this.ligas = ligas;
    }

    private RealmList<Liga> ligas;

    @Override
    public String toString() {
        return "Id: '" + idJugador + '\'' +
                ", Nombre: '" + nombre + '\'' +
                ", Apellido '" + apellido + '\'' +
                ", Teléfono '" + telefono + '\'' +
                ", Dirección '" + edad + '\'' + "\n";
    }
}
