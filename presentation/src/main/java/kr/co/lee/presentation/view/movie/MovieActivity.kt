package kr.co.lee.presentation.view.movie

import android.os.Bundle
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kr.co.lee.presentation.R
import kr.co.lee.presentation.base.BaseActivity
import kr.co.lee.presentation.databinding.ActivityMovieBinding
import java.net.URLEncoder
import javax.inject.Inject

@AndroidEntryPoint
class MovieActivity @Inject constructor(): BaseActivity<ActivityMovieBinding>(R.layout.activity_movie) {
    private val viewModel: MovieViewModel by viewModels()
    private val movieAdapter: MovieAdapter by lazy {
        MovieAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            vm = viewModel
            adapter = movieAdapter
        }
        viewModel.getMovieList("마루 밑")

        viewModel.movieList.observe(this) {
            movieAdapter.setItems(it)
        }
    }
}