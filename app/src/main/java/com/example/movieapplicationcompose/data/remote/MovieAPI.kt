package com.example.movieapplicationcompose.data.remote

import com.example.movieapplicationcompose.data.remote.dto.MovieDetailDto
import com.example.movieapplicationcompose.data.remote.dto.MoviesDto
import com.example.movieapplicationcompose.utils.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {

    @GET(".")
    suspend fun getMovies(
        @Query("s") searchString: String,
        @Query("apikey") apikey: String = API_KEY
    ): MoviesDto

    @GET(".")
    suspend fun getMoviesImdb(
        @Query("s") searchString: String,
        @Query("apikey") apikey: String = API_KEY
    ): MoviesDto

    @GET(".")
    suspend fun getMovieDetail(
        @Query("i") imdbID: String,
        @Query("apikey") apikey: String = API_KEY
    ): MovieDetailDto
}