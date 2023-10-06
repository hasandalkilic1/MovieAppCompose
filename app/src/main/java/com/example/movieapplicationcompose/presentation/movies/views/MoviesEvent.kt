package com.example.movieapplicationcompose.presentation.movies.views

sealed class MoviesEvent {
    data class Search(val searchString: String) : MoviesEvent()
}