package com.example.themoviedb_001.movies_api;

import com.example.themoviedb_001.json_mapper.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MoviesAPI {
    // Routers!!! express.js
    @GET("movie/popular?api_key=da801cba97030b2061f98438076b37f6")
    Call<MovieResponse> getPopularMovies();
}
