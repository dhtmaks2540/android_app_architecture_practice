package kr.co.lee.presentation.binding

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object ViewBinding {
    @JvmStatic
    @BindingAdapter("set_image")
    fun AppCompatImageView.bindSetImage(imageUrl: String) {
        Glide.with(this)
            .load(imageUrl)
            .centerCrop()
            .into(this)
    }
}