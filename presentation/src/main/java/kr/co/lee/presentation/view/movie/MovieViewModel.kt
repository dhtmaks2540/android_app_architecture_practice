package kr.co.lee.presentation.view.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers
import kr.co.lee.domain.model.MovieModel
import kr.co.lee.domain.usecase.GetMovieUseCase
import kr.co.lee.presentation.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val useCase: GetMovieUseCase
) : BaseViewModel() {
    val queryTitle = MutableLiveData<String>("")
    private val _movieList = MutableLiveData<List<MovieModel>>(emptyList())
    val movieList: LiveData<List<MovieModel>> = _movieList
    private fun setMovieList(movies: List<MovieModel>) {
        _movieList.value = movies
    }

    fun getMovieList(query: String) {
        compositeDisposable.add(
            useCase.invoke(query = query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                    onSuccess = {
                        setMovieList(it)
                    },
                    onError = { throwable ->
                        println(throwable)
                    }
                )
        )
    }
}