package kr.co.lee.datasource

import io.reactivex.rxjava3.core.Single
import kr.co.lee.api.MovieService
import kr.co.lee.model.MovieResponse
import javax.inject.Inject

interface MovieRemoteSource {
    fun getMovies(query: String): Single<MovieResponse>
}

class MovieRemoteSourceImpl @Inject constructor(
    private val movieApiService: MovieService
): MovieRemoteSource {
    override fun getMovies(query: String): Single<MovieResponse> {
        return movieApiService.getSearchMovie(query = query)
    }
}