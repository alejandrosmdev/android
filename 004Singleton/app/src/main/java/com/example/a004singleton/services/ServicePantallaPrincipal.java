package com.example.a004singleton.services;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.a004singleton.MainActivity;
import com.example.a004singleton.MainActivity2;

public class ServicePantallaPrincipal {

    private  MainActivity padre;
    private MainActivity2 padre2;
    /*public ServicePantallaPrincipal(MainActivity padre) {
        this.padre = padre;
    }*/

    public void saludar() {
        Toast.makeText(MainActivity.getInstance(),
                "Saludar Android!",
                Toast.LENGTH_SHORT).show();
        // INTENT
        Intent intent = new Intent(MainActivity.getInstance(), MainActivity2.class);
        MainActivity.getInstance().startActivity(intent);
        // 2 LINEAS DE CODIGO
    }
    public void altaUsuario() {
        Toast.makeText(MainActivity2.getInstance(),
                "Hola 2º pantalla",
                Toast.LENGTH_SHORT).show();
    }


    /*public void saludar(Context context) {
        Toast.makeText(context,
                "Saludar Android!",
                Toast.LENGTH_SHORT).show();
    }*/
}
