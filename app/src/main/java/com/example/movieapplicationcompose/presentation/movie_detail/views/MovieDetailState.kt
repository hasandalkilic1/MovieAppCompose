package com.example.movieapplicationcompose.presentation.movie_detail.views

import com.example.movieapplicationcompose.domain.model.MovieDetail

data class MovieDetailState(
    val isLoading: Boolean = false,
    val movie: MovieDetail? = null,
    val error: String = ""
) {
}