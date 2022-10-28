package kr.co.lee.mapper

import kr.co.lee.domain.model.MovieModel
import kr.co.lee.model.MovieEntity

fun toMovieModel(movies: List<MovieEntity>): List<MovieModel> {
    return movies.toList().map {
        MovieModel(
            title = it.title,
            link = it.link,
            image = it.image,
            subtitle = it.subtitle,
            pubDate = it.pubDate,
            director = it.director,
            actor = it.actor,
            userRating = it.userRating
        )
    }
}