package com.example.themoviedb_001.json_mapper;

import java.util.List;

public class MovieResponse {
    // URL: https://api.themoviedb.org/3/movie/popular?api_key=da801cba97030b2061f98438076b37f6
    private List<Movie> results;

    // GETTERS & SETTERS
    public List<Movie> getResults() {
        return results;
    }
    public void setResults(List<Movie> results) {
        this.results = results;
    }
}
