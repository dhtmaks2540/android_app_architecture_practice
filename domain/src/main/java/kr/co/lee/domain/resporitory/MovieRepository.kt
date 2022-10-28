package kr.co.lee.domain.resporitory

import io.reactivex.rxjava3.core.Single
import kr.co.lee.domain.model.MovieModel

interface MovieRepository {
    fun getMovies(query: String): Single<List<MovieModel>>
}