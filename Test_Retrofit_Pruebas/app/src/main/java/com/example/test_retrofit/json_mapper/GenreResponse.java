package com.example.test_retrofit.json_mapper;

import java.util.List;

public class GenreResponse {
    private List<Genre> results;

    public List<Genre> getGenres() {
        return results;
    }
    public void setResults(List<Genre> results) {
        this.results = results;
    }
}
