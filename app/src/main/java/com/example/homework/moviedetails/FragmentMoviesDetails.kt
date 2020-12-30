package com.example.homework.moviedetails

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homework.R
import com.example.homework.R.layout
import com.example.homework.data.models.Movie
import com.example.homework.domain.MoviesDataSource
import com.idlestar.ratingstar.RatingStarView

class FragmentMoviesDetails : Fragment() {

    private lateinit var backButton: TextView
    private lateinit var moviePoster: ImageView
    private lateinit var moviePg: TextView
    private lateinit var movieTitle: TextView
    private lateinit var movieTags: TextView
    private lateinit var movieRating: RatingStarView
    private lateinit var movieReviews: TextView
    private lateinit var movieStoryline: TextView
    private lateinit var movieActors: RecyclerView
    private lateinit var actorsAdapter: ActorsListAdapter
    private var backToMovieListListener: BackToMovieListListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(layout.fragment_movie_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViewsFrom(view)
        addListenersToViews()
        addAdapterToRecyclerView()

        val moviesDataSource = MoviesDataSource()
        val movie = moviesDataSource.movies.first()
        displayMovieDetail(movie)
    }

    private fun initViewsFrom(view: View) {
        with(view) {
            backButton = findViewById(R.id.back_text)
            moviePoster = findViewById(R.id.movie_orig)
            moviePg = findViewById(R.id.prev_movie_pg)
            movieTitle = findViewById(R.id.movie_title)
            movieTags = findViewById(R.id.movie_tags)
            movieRating = findViewById(R.id.prev_movie_rating)
            movieReviews = findViewById(R.id.movie_reviews)
            movieStoryline = findViewById(R.id.movie_story_line)
            movieActors = findViewById(R.id.rv_movie_actors_list)
        }
    }

    private fun addListenersToViews() {
        backButton.setOnClickListener {
            backToMovieListListener?.backToMovieList()
        }
    }
    private fun addAdapterToRecyclerView() {                                                ////<-medium example
        val castImageMargin = resources.getDimension(R.dimen.cast_image_margin).toInt()
        val actorsDecorator = ActorsListDecorator(castImageMargin)
        actorsAdapter = ActorsListAdapter()
        movieActors.addItemDecoration(actorsDecorator)
        movieActors.adapter = actorsAdapter
    }
    private fun displayMovieDetail(movie: Movie) {
        with(requireView()) {
            Glide.with(context).load(movie.posterId).into(moviePoster)
            moviePg.text = context.getString(R.string.movie_pg, movie.pg)                             //missing some argument movie.pg
            movieTitle.text = movie.movieTitle
            movieTags.text = movie.tags.joinToString(", ")
            movieRating.rating = movie.rating
            movieReviews.text = context.getString(R.string.movie_reviews, movie.reviews)
            movieStoryline.text = movie.storyline
            actorsAdapter.submitList(movie.actors)
        }
    }
    override fun onDetach() {
        super.onDetach()
        backToMovieListListener = null
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BackToMovieListListener) {
            backToMovieListListener = context
        }
    }

    interface BackToMovieListListener {

        fun backToMovieList()
    }
}
