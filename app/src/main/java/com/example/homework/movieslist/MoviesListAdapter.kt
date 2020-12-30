package com.example.homework.movieslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homework.R
import com.example.homework.data.models.Movie
import com.example.homework.movieslist.MoviesListAdapter.MovieHolder
import com.example.homework.utils.extensions.context
import com.idlestar.ratingstar.RatingStarView

class MoviesListAdapter(private val listener: OnClickListener) :
    ListAdapter<Movie, MovieHolder>(MovieCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        return MovieHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.vh_movie_preview, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(movie)
        holder.itemView.setOnClickListener {
            listener.onClick(movie)
        }
    }

    class MovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val moviePoster: ImageView = itemView.findViewById(R.id.iv_prev_poster)
        private val movieTitle: TextView = itemView.findViewById(R.id.prev_movie_title)
        private val movieTags: TextView = itemView.findViewById(R.id.prev_tags)
        private val moviePg: TextView = itemView.findViewById(R.id.prev_movie_pg)
        private val movieRating: RatingStarView = itemView.findViewById(R.id.prev_movie_rating)
        private val movieReviews: TextView = itemView.findViewById(R.id.prev_reviews)
        private val movieLength: TextView = itemView.findViewById(R.id.prev_film_duration)

        fun bind(movie: Movie) {
            Glide.with(context).load(movie.smallPosterId).into(moviePoster)
            movieTitle.text = movie.movieTitle
            movieTags.text = movie.tags.joinToString(", ")
            moviePg.text = context.getString(R.string.movie_pg, movie.pg)
            movieRating.rating = movie.rating
            movieReviews.text = context.getString(R.string.movie_reviews, movie.reviews)
            movieLength.text = context.getString(R.string.movie_duration, movie.movieDuration)
        }
    }

    fun interface OnClickListener {

        fun onClick(movie: Movie)
    }
}

class MovieCallback : DiffUtil.ItemCallback<Movie>() {

    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.movieTitle == newItem.movieTitle
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }
}