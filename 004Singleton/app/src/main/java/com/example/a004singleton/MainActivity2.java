package com.example.a004singleton;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.a004singleton.services.ServicePantallaPrincipal;

public class MainActivity2 extends AppCompatActivity {

    private Button btnSaludar2;
    private ServicePantallaPrincipal spPrincipal;

    /////PATRON SINGLETON
    private static MainActivity2 padre;
    public static MainActivity2 getInstance(){
        return padre;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_segunda_activity);

        this.padre = this;

        btnSaludar2 = findViewById(R.id.btnSaludar2);
        spPrincipal = new ServicePantallaPrincipal();

        btnSaludar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spPrincipal.altaUsuario();
//                ServicePantallaPrincipal service = new ServicePantallaPrincipal();
//                service.saludar(MainActivity.this);
            }
        });
    }
}