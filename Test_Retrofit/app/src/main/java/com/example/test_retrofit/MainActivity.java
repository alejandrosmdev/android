package com.example.test_retrofit;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.test_retrofit.json_mapper.Movie;
import com.example.test_retrofit.json_mapper.MovieResponse;
import com.example.test_retrofit.retrofit.RetrofitClient;
import com.example.test_retrofit.services.ServicePantallaPrincipal;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private Button btnMostrarPeliculas;
    private Button btnMostrarPeliculaBuscada;
    private Button btnMostrarDetallesPeliculaPorId;

    /////PATRON SINGLETON
    private static MainActivity padre;
    public static MainActivity getInstance(){
        return padre;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // SINGLETON
        this.padre = this;
        // FIN SINGLETON

        ServicePantallaPrincipal service = new ServicePantallaPrincipal(padre);
        btnMostrarPeliculas = findViewById(R.id.popular_button);
        btnMostrarPeliculaBuscada = findViewById(R.id.search_button);
        btnMostrarDetallesPeliculaPorId = findViewById(R.id.details_button);

        btnMostrarPeliculas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                service.getPopularMovies();
            }
        });

        btnMostrarPeliculaBuscada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                service.getSearchedMovie();
            }
        });

        btnMostrarDetallesPeliculaPorId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                service.getMovieDetailsById();
            }
        });
    }
}