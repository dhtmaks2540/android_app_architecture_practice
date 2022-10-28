package kr.co.lee.model

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("lastBuildDate")
    val lastBuildData: String,
    @SerializedName("total")
    val total: Int,
    @SerializedName("start")
    val start: Int,
    @SerializedName("display")
    val display: Int,
    @SerializedName("items")
    val movieList: List<MovieEntity>
)
