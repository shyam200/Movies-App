package com.example.moviesapp.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.example.moviesapp.data.models.MovieModel
import com.example.moviesapp.databinding.ListItemBinding

class MoviesAdapter : RecyclerView.Adapter<MoviesViewHolder>() {
    private val moviesList = ArrayList<MovieModel>()

    fun setMoviesList(movies: List<MovieModel>) {
        moviesList.clear()
        moviesList.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ListItemBinding>(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )
        return MoviesViewHolder(binding)

    }

    override fun getItemCount(): Int = moviesList.size

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(moviesList[position])
    }
}

class MoviesViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {


    fun bind(movie : MovieModel){
        binding.cardTitle.text = movie.title
        binding.cardDesc.text = movie.overview
    }
}