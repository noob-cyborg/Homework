package com.example.homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework.data.models.Movie
import com.example.homework.moviedetails.FragmentMoviesDetails
import com.example.homework.movieslist.FragmentMoviesList

class MainActivity : AppCompatActivity(), FragmentMoviesList.ShowMovieDetailsListener,
    FragmentMoviesDetails.BackToMovieListListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            val moviesListFragment = FragmentMoviesList()
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment, moviesListFragment)
                .commit()
        }
    }

    override fun showMovieDetails(movie: Movie) {
        val movieDetailsFragment = FragmentMoviesDetails()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment, movieDetailsFragment)
            .addToBackStack(null)
            .commit()
    }

    override fun backToMovieList() {
        supportFragmentManager.popBackStack()
    }
}