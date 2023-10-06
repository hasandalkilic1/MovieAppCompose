package com.example.movieapplicationcompose.presentation.movies.views

import com.example.movieapplicationcompose.domain.model.Movie

data class MoviesState(
    val isLoading : Boolean = false,
    val movies : List<Movie> = emptyList(),
    val error : String = "",
    val search: String = "oppenheimer"
) {
}