package com.example.movieapplicationcompose.domain.use_case.get_movies

import com.example.movieapplicationcompose.data.remote.dto.toMovieList
import com.example.movieapplicationcompose.domain.model.Movie
import com.example.movieapplicationcompose.domain.repository.MovieRepository
import com.example.movieapplicationcompose.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import java.io.IOException
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(private val repository: MovieRepository) {
    fun executeGetMovies(search: String) : Flow<Resource<List<Movie>>> = flow {
        try {
            emit(Resource.Loading())
            val movieList = repository.getMovies(search)
            if (movieList.Response == "True") {
                emit(Resource.Success(movieList.toMovieList()))
            } else {
                emit(Resource.Error(message = "No movie found!"))
            }
        }catch (e:IOError){
            emit(Resource.Error(message = "No internet connection!"))
        }
        catch (e:HttpException){
            emit(Resource.Error(message = e.localizedMessage ?: "Error!"))
        }
    }
}