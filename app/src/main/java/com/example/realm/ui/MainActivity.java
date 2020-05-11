package com.example.realm.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.realm.R;
import com.example.realm.model.Jugador;
import com.example.realm.operaciones.OperacionesJugador;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    private EditText nombreEdit, dniEdit, equipoEdit, idCambioEdit, cambioEquipoEdit, cambioEquipoEditId;
    private Button botonGuardar, botonMostrarJugadores, botonMostrarPorNombre, botonMostrarPorId, botonCambiarEquipo, botonBorrar;
    private Jugador jugador;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        realm = Realm.getDefaultInstance();
        configView();
    }

    private void configView(){
        jugador = new Jugador();
        nombreEdit = findViewById(R.id.mainActivityEditTextNombre);
        dniEdit = findViewById(R.id.mainActivityEditTextDni);
        equipoEdit = findViewById(R.id.mainActivityEditTextEquipo);
        cambioEquipoEdit = findViewById(R.id.mainActivityEditTextCambiarEquipo);
        idCambioEdit = findViewById(R.id.mainActivityEditTextId);
        cambioEquipoEditId = findViewById(R.id.mainActivityEditTextCambiarEquipoId);

        botonGuardar = findViewById(R.id.mainActivityBotonGuardar);
        botonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jugador.setNombre(nombreEdit.getText().toString());
                jugador.setDni(dniEdit.getText().toString());
                jugador.setEquipo(equipoEdit.getText().toString());
                OperacionesJugador.añadirJugador(jugador);
                Toast toast= Toast.makeText(getApplicationContext(),"Jugador guardado", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        botonMostrarJugadores = findViewById(R.id.mainActivityBotonMostrarJugadores);
        botonMostrarJugadores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OperacionesJugador.allJugadores();
                Toast toast= Toast.makeText(getApplicationContext(),"En android studio podrás ver la lista de jugadores completa", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        botonMostrarPorNombre = findViewById(R.id.mainActivityBotonMostrarPorNombre);
        botonMostrarPorNombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OperacionesJugador.jugadoresPorNombre(nombreEdit.getText().toString());
                Toast toast= Toast.makeText(getApplicationContext(),"En android studio podrás ver la lista de jugadores por nombre", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        botonMostrarPorId = findViewById(R.id.mainActivityBotonMostrarPorId);
        botonMostrarPorId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OperacionesJugador.jugadoresPorId(Integer.parseInt(idCambioEdit.getText().toString()));
                Toast toast= Toast.makeText(getApplicationContext(),"En android studio podrás ver la lista de jugadores por ID", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        botonCambiarEquipo = findViewById(R.id.mainActivityBotonCambiarEquipo);
        botonCambiarEquipo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OperacionesJugador.updateJugadores(Integer.parseInt(cambioEquipoEditId.getText().toString()),jugador.setNombre(cambioEquipoEdit.getText().toString()));
                Toast toast= Toast.makeText(getApplicationContext(),"Nombre cambiado", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        botonBorrar = findViewById(R.id.mainActivityBorrarJugador);
        botonBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OperacionesJugador.borrarJugador(Integer.parseInt(idCambioEdit.getText().toString()));
                Toast toast= Toast.makeText(getApplicationContext(),"Jugador borrado", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}
