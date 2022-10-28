package kr.co.lee.presentation.view.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import kr.co.lee.domain.model.MovieModel
import kr.co.lee.presentation.R
import kr.co.lee.presentation.databinding.ItemMovieBinding

class MovieAdapter: RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    private var itemList: List<MovieModel> = emptyList()

    fun setItems(items: List<MovieModel>) {
        itemList = items
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemMovieBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieModel) {
            binding.apply {
                item = movie
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ItemMovieBinding>(LayoutInflater.from(parent.context), R.layout.item_movie, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size
}