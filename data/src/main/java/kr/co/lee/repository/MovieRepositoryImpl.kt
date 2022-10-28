package kr.co.lee.repository

import io.reactivex.rxjava3.core.Single
import kr.co.lee.datasource.MovieRemoteSource
import kr.co.lee.domain.model.MovieModel
import kr.co.lee.domain.resporitory.MovieRepository
import kr.co.lee.mapper.toMovieModel
import kr.co.lee.model.MovieEntity
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieRemoteSource: MovieRemoteSource
): MovieRepository {
    override fun getMovies(query: String): Single<List<MovieModel>> {
        return movieRemoteSource.getMovies(query).flatMap { Single.just(toMovieModel(it.movieList)) }
    }
}