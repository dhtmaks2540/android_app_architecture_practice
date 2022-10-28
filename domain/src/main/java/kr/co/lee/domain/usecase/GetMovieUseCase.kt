package kr.co.lee.domain.usecase

import io.reactivex.rxjava3.core.Single
import kr.co.lee.domain.model.MovieModel
import kr.co.lee.domain.resporitory.MovieRepository

class GetMovieUseCase(private val movieRepository: MovieRepository) {
    operator fun invoke(query: String): Single<List<MovieModel>> {
        return movieRepository.getMovies(query)
    }
}