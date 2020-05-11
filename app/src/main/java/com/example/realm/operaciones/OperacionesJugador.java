package com.example.realm.operaciones;

import android.util.Log;

import com.example.realm.model.Jugador;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class OperacionesJugador {
    private final static int calcularId(){
        Realm realm = Realm.getDefaultInstance();
        Number idNum = realm.where(Jugador.class).max("idJugador");
        int nextId;
        if(idNum == null){
            nextId = 0;
        }else{
            nextId = idNum.intValue()+1;
        }
        return nextId;
    }

    public final static void añadirJugador(final Jugador jugador){
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                int indice = OperacionesJugador.calcularId();
                Jugador realmJugador = realm.createObject(Jugador.class, indice);
                realmJugador.setNombre(jugador.getNombre());
                realmJugador.setDni(jugador.getDni());
                realmJugador.setEquipo(jugador.getEquipo());
            }
        });
    }
    public final static List<Jugador> allJugadores(){
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Jugador> jugadors = realm.where(Jugador.class).findAll();
        for (Jugador jugador : jugadors){
            Log.d("alljugadores","ID: "+ jugador.getIdJugador() + " Nombre: " + jugador.getNombre()+ " DNI: " + jugador.getDni() + " Equipo: " + jugador.getEquipo());
        }
        return jugadors;
    }

    public final static Jugador jugadoresPorNombre(String nombre){
        Realm realm = Realm.getDefaultInstance();
        Jugador jugador = realm.where(Jugador.class).equalTo("nombre", nombre).findFirst();
        if(jugador != null){
            Log.d("jugador","ID: "+ jugador.getIdJugador() + " Nombre: " + jugador.getNombre()+ " DNI: " + jugador.getDni() + " Equipo: " + jugador.getEquipo());
        }
        return jugador;
    }

    public final static Jugador jugadoresPorId(int id){
        Realm realm = Realm.getDefaultInstance();
        Jugador jugador = realm.where(Jugador.class).equalTo("idJugador", id).findFirst();
        if(jugador != null){
            Log.d("jugador","ID: "+ jugador.getIdJugador() + " Nombre: " + jugador.getNombre()+ " DNI: " + jugador.getDni() + " Equipo: " + jugador.getEquipo());
        }
        return jugador;
    }

    public final static void updateJugadores(int id, String equipo){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Jugador jugador = realm.where(Jugador.class).equalTo("idJugador", id).findFirst();
        jugador.setEquipo(equipo);
        realm.insertOrUpdate(jugador);
        realm.commitTransaction();
        if(jugador != null){
            Log.d("jugador","ID: "+ jugador.getIdJugador() + " Nombre: " + jugador.getNombre()+ " DNI: " + jugador.getDni() + " Equipo: " + jugador.getEquipo());
        }
    }

    public final static void borrarJugador(int id){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Jugador jugador = realm.where(Jugador.class).equalTo("idJugador", id).findFirst();
        jugador.deleteFromRealm();
        realm.commitTransaction();
    }
}
