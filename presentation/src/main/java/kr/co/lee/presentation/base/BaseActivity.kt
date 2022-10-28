package kr.co.lee.presentation.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import io.reactivex.rxjava3.disposables.CompositeDisposable

abstract class BaseActivity<VB: ViewDataBinding>(@LayoutRes layout: Int): AppCompatActivity() {
    protected val binding: VB by lazy {
        DataBindingUtil.setContentView(this, layout)
    }
    protected val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.lifecycleOwner = this
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}