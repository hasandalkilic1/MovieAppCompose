package com.example.movieapplicationcompose.domain.repository

import com.example.movieapplicationcompose.data.remote.dto.MovieDetailDto
import com.example.movieapplicationcompose.data.remote.dto.MoviesDto

interface MovieRepository {

    suspend fun getMovies(search: String): MoviesDto

    suspend fun getMovieDetail(imdbID: String): MovieDetailDto
}