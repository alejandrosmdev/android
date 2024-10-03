package com.example.test_retrofit.listeners;

import com.example.test_retrofit.json_mapper.Movie;
import com.example.test_retrofit.json_mapper.MovieResponse;
import com.example.test_retrofit.json_mapper.GenreResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MoviesAPI {

    String apiKey = "da801cba97030b2061f98438076b37f6";

    // Obtener las películas populares
    @GET("movie/popular")
    Call<MovieResponse> getPopularMovies(@Query("api_key") String apiKey,
                                         @Query("language") String language,
                                         @Query("page") int page);

    // Buscar películas por título
    @GET("search/movie")
    Call<MovieResponse> getSearchedMovie(@Query("api_key") String apiKey,
                                         @Query("language") String language,
                                         @Query("query") String query,
                                         @Query("page") int page);

    // Obtener detalles de una película por ID
    @GET("movie/{movie_id}")
    Call<Movie> getMovieDetails(@Path("movie_id") int movieId,
                                @Query("api_key") String apiKey,
                                @Query("language") String language);

    // Obtener los créditos de una película por ID
    @GET("movie/{movie_id}/credits")
    Call<Movie> getMovieCredits(@Path("movie_id") int movieId,
                                          @Query("api_key") String apiKey);

    // Obtener las películas recomendadas por ID de película
    @GET("movie/{movie_id}/recommendations")
    Call<MovieResponse> getRecommendedMovies(@Path("movie_id") int movieId,
                                             @Query("api_key") String apiKey,
                                             @Query("language") String language,
                                             @Query("page") int page);

    // Obtener los géneros de películas
    @GET("genre/movie/list")
    Call<GenreResponse> getMovieGenres(@Query("api_key") String apiKey,
                                       @Query("language") String language);

    // Obtener películas por género
    @GET("discover/movie")
    Call<MovieResponse> getMoviesByGenre(@Query("api_key") String apiKey,
                                         @Query("with_genres") String genreIds,
                                         @Query("language") String language,
                                         @Query("page") int page);

    // Obtener las películas más votadas
    @GET("movie/top_rated")
    Call<MovieResponse> getTopRatedMovies(@Query("api_key") String apiKey,
                                          @Query("language") String language,
                                          @Query("page") int page);

    // Obtener las próximas películas en cines
    @GET("movie/upcoming")
    Call<MovieResponse> getUpcomingMovies(@Query("api_key") String apiKey,
                                          @Query("language") String language,
                                          @Query("page") int page);

    // Obtener películas filtradas por fecha de lanzamiento
    @GET("discover/movie")
    Call<MovieResponse> getMoviesByReleaseDate(@Query("api_key") String apiKey,
                                               @Query("language") String language,
                                               @Query("primary_release_date.gte") String startDate,
                                               @Query("primary_release_date.lte") String endDate,
                                               @Query("page") int page);

    // Obtener películas filtradas por popularidad
    @GET("discover/movie")
    Call<MovieResponse> getMoviesByPopularity(@Query("api_key") String apiKey,
                                              @Query("language") String language,
                                              @Query("sort_by") String sortOrder,
                                              @Query("page") int page);

    // Obtener películas que contienen un término en su título
    @GET("search/movie")
    Call<MovieResponse> getMoviesByTitleKeyword(@Query("api_key") String apiKey,
                                                @Query("language") String language,
                                                @Query("query") String keyword,
                                                @Query("include_adult") boolean includeAdult,
                                                @Query("page") int page);

    // Obtener películas con un puntaje mínimo
    @GET("discover/movie")
    Call<MovieResponse> getMoviesByVoteAverage(@Query("api_key") String apiKey,
                                               @Query("language") String language,
                                               @Query("vote_average.gte") double minVoteAverage,
                                               @Query("page") int page);
}
