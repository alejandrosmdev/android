package com.example.test_retrofit;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test_retrofit.services.ServicePantallaPrincipal;

public class MainActivity extends AppCompatActivity {
    private Button btnMostrarPeliculas;
    private Button btnMostrarPeliculaBuscada;
    private Button btnMostrarDetallesPeliculaPorId;
    private Button btnMostrarPeliculasRecomendadas;
    private Button btnMostrarGeneros;
    private Button btnMostrarPeliculasPorGenero;
    private Button btnMostrarPeliculasPorFecha;
    private Button btnMostrarPeliculasPorPuntaje;

    ///// PATRON SINGLETON
    private static MainActivity padre;
    public static MainActivity getInstance() {
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
        btnMostrarPeliculasRecomendadas = findViewById(R.id.recommendations_button);
        btnMostrarGeneros = findViewById(R.id.genres_button);
        btnMostrarPeliculasPorGenero = findViewById(R.id.movies_by_genre_button);
        btnMostrarPeliculasPorFecha = findViewById(R.id.movies_by_date_button);
        btnMostrarPeliculasPorPuntaje = findViewById(R.id.movies_by_rating_button);

        btnMostrarPeliculas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                service.getPopularMovies();
            }
        });

        btnMostrarPeliculaBuscada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                service.getSearchedMovie("titanic");
            }
        });

        btnMostrarDetallesPeliculaPorId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                service.getMovieDetailsById(550);
            }
        });

        btnMostrarPeliculasRecomendadas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                service.getRecommendedMovies(550); // ID de ejemplo
            }
        });

        btnMostrarGeneros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                service.getMovieGenres();
            }
        });

        btnMostrarPeliculasPorGenero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                service.getMoviesByGenre("28"); // Ejemplo: 28 es el ID del género "Acción"
            }
        });

        btnMostrarPeliculasPorFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                service.getMoviesByReleaseDate("2023-01-01", "2023-12-31"); // Ejemplo de rango de fechas
            }
        });

        btnMostrarPeliculasPorPuntaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                service.getMoviesByVoteAverage(7.5); // Ejemplo de puntaje mínimo
            }
        });
    }
}
