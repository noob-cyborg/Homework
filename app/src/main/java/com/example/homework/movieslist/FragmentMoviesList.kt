package com.example.homework.movieslist

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.homework.R
import com.example.homework.R.layout
import com.example.homework.data.models.Movie
import com.example.homework.domain.MoviesDataSource

class FragmentMoviesList : Fragment() {

    private var showMovieDetailsListener: ShowMovieDetailsListener? = null
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MoviesListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(layout.fragment_movies_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = view.findViewById(R.id.rv_movies_list)
        adapter = MoviesListAdapter { movie ->
            showMovieDetailsListener?.showMovieDetails(movie)
        }
        recyclerView.adapter = adapter

        val moviesDataSource = MoviesDataSource()
        adapter.submitList(moviesDataSource.movies)
    }

    override fun onDetach() {
        super.onDetach()
        showMovieDetailsListener = null
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ShowMovieDetailsListener) {
            showMovieDetailsListener = context
        }
    }

    interface ShowMovieDetailsListener {

        fun showMovieDetails(movie: Movie)
    }
}