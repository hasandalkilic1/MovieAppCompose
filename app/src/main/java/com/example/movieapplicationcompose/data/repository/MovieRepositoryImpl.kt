package com.example.movieapplicationcompose.data.repository

import com.example.movieapplicationcompose.data.remote.MovieAPI
import com.example.movieapplicationcompose.data.remote.dto.MovieDetailDto
import com.example.movieapplicationcompose.data.remote.dto.MoviesDto
import com.example.movieapplicationcompose.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val api: MovieAPI) : MovieRepository {
    override suspend fun getMovies(search: String): MoviesDto {
        return api.getMovies(search)
    }

    override suspend fun getMovieDetail(imdbID: String): MovieDetailDto {
        return api.getMovieDetail(imdbID)
    }
}