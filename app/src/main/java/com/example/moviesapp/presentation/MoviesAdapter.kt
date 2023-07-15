package com.example.moviesapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
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

        //creating image url i.e
       val image_url = "https://image.tmdb.org/t/p/w500/${movie.poster_path}"

        //Using Glide library to upload image on imageView for faster processing
        Glide.with(binding.cardImage.context)
            .load(image_url)
            .into(binding.cardImage)
    }
}