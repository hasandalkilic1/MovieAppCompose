package com.example.movieapplicationcompose.domain.use_case.get_movie_detail

import com.example.movieapplicationcompose.data.remote.dto.toMovieDetail
import com.example.movieapplicationcompose.data.remote.dto.toMovieList
import com.example.movieapplicationcompose.domain.model.Movie
import com.example.movieapplicationcompose.domain.model.MovieDetail
import com.example.movieapplicationcompose.domain.repository.MovieRepository
import com.example.movieapplicationcompose.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(private val repository: MovieRepository) {
    fun executeGetMovieDetails(imdbID: String) : Flow<Resource<MovieDetail>> = flow {
        try {
            emit(Resource.Loading())
            val movieDetail = repository.getMovieDetail(imdbID)
            emit(Resource.Success(movieDetail.toMovieDetail()))
        }catch (e: IOError){
            emit(Resource.Error(message = "No internet connection!"))
        }
        catch (e: HttpException){
            emit(Resource.Error(message = e.localizedMessage ?: "Error!"))
        }
    }
}