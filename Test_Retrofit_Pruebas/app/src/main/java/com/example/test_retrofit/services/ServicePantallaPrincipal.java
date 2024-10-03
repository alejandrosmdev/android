package com.example.test_retrofit.services;

import android.widget.Toast;

import com.example.test_retrofit.MainActivity;
import com.example.test_retrofit.json_mapper.Genre;
import com.example.test_retrofit.json_mapper.GenreResponse;
import com.example.test_retrofit.json_mapper.Movie;
import com.example.test_retrofit.json_mapper.MovieResponse;
import com.example.test_retrofit.listeners.MoviesAPI;
import com.example.test_retrofit.retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServicePantallaPrincipal {

    private MainActivity padre;

    public ServicePantallaPrincipal(MainActivity padre) {
        this.padre = padre;
    }

    public void getPopularMovies() {
        Call<MovieResponse> call = RetrofitClient.getInstance().getPopularMovies(MoviesAPI.apiKey, "es-ES", 1);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful()) {
                    List<Movie> movies = response.body().getResults();
                    for (Movie myMovie : movies) {
                        Toast.makeText(padre, "Movie: " + myMovie.getTitle(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(padre, "Error en la respuesta", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Toast.makeText(padre, "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void getSearchedMovie(String query) {
        Call<MovieResponse> call = RetrofitClient.getInstance().getSearchedMovie(MoviesAPI.apiKey, "es-ES", query, 1);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful()) {
                    List<Movie> movies = response.body().getResults();
                    for (Movie myMovie : movies) {
                        Toast.makeText(padre, "Movie: " + myMovie.getTitle(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(padre, "Error en la respuesta", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Toast.makeText(padre, "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void getMovieDetailsById(int movieId) {
        Call<Movie> call = RetrofitClient.getInstance().getMovieDetails(movieId, MoviesAPI.apiKey, "es-ES");
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Movie myMovie = response.body();
                    Toast.makeText(padre, "Details: " + myMovie.getOverview(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(padre, "Error en la respuesta", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                Toast.makeText(padre, "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    // Obtener películas recomendadas por ID de película
    public void getRecommendedMovies(int movieId) {
        Call<MovieResponse> call = RetrofitClient.getInstance().getRecommendedMovies(movieId, MoviesAPI.apiKey, "es-ES", 1);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful() && response.body() != null && response.body().getResults() != null) {
                    List<Movie> movies = response.body().getResults();
                    for (Movie myMovie : movies) {
                        Toast.makeText(padre, "Recommended: " + myMovie.getTitle(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(padre, "Error en la respuesta o sin resultados", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Toast.makeText(padre, "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }


    // Obtener géneros de películas
    public void getMovieGenres() {
        Call<GenreResponse> call = RetrofitClient.getInstance().getMovieGenres(MoviesAPI.apiKey, "es-ES");
        call.enqueue(new Callback<GenreResponse>() {
            @Override
            public void onResponse(Call<GenreResponse> call, Response<GenreResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Genre> genres = response.body().getGenres(); // Asegúrate de que 'getGenres()' no retorne null
                    if (genres != null && !genres.isEmpty()) {
                        for (Genre genre : genres) {
                            Toast.makeText(padre, "Género: " + genre.getTitle(), Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(padre, "No se encontraron géneros", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(padre, "Error en la respuesta o sin datos", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<GenreResponse> call, Throwable t) {
                Toast.makeText(padre, "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }


    // Obtener películas por género
    public void getMoviesByGenre(String genreIds) {
        Call<MovieResponse> call = RetrofitClient.getInstance().getMoviesByGenre(MoviesAPI.apiKey, genreIds, "es-ES", 1);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful()) {
                    List<Movie> movies = response.body().getResults();
                    for (Movie myMovie : movies) {
                        Toast.makeText(padre, "Genre Movie: " + myMovie.getTitle(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(padre, "Error en la respuesta", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Toast.makeText(padre, "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    // Obtener películas filtradas por fecha de lanzamiento
    public void getMoviesByReleaseDate(String startDate, String endDate) {
        Call<MovieResponse> call = RetrofitClient.getInstance().getMoviesByReleaseDate(MoviesAPI.apiKey, "es-ES", startDate, endDate, 1);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful()) {
                    List<Movie> movies = response.body().getResults();
                    for (Movie myMovie : movies) {
                        Toast.makeText(padre, "Release Date Movie: " + myMovie.getTitle(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(padre, "Error en la respuesta", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Toast.makeText(padre, "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    // Obtener películas por puntaje mínimo
    public void getMoviesByVoteAverage(double minVoteAverage) {
        Call<MovieResponse> call = RetrofitClient.getInstance().getMoviesByVoteAverage(MoviesAPI.apiKey, "es-ES", minVoteAverage, 1);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful()) {
                    List<Movie> movies = response.body().getResults();
                    for (Movie myMovie : movies) {
                        Toast.makeText(padre, "High Rating Movie: " + myMovie.getTitle(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(padre, "Error en la respuesta", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Toast.makeText(padre, "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
