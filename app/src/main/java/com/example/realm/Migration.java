package com.example.realm;

import android.util.Log;

import io.realm.DynamicRealm;
import io.realm.RealmMigration;
import io.realm.RealmSchema;

public class Migration implements RealmMigration {


    /* Version 0
            public class Jugador extends RealmObject {
            @PrimaryKey
            private int idJugador;
            private String nombre;
            private String dni;
            private String equipo;
            }
        */
    /* Version 1
            public class Jugador extends RealmObject {
            @PrimaryKey
            private int idJugador;
            private String nombre;
            private String apellido;
            private String telefono;
            private String edad
            }
        */

    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
        RealmSchema schema = realm.getSchema();

        if(oldVersion == 0) {
            Log.d("Migration", "actualitzant a la versió 1");
            schema.get("Jugador")
                    .addField("apellido", String.class)
                    .addField("telefono", String.class)
                    .addField("edad", int.class)
                    .removeField("dni")
                    .removeField("equipo");
            oldVersion++;
        }
    }
}
