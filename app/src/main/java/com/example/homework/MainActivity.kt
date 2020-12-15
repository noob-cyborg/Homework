package com.example.homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), MyFragmentListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.persistent_container, FragmentMoviesList())
            .addToBackStack(null)
            .commit()
    }

    override fun changeToFragmentDetails() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.persistent_container, FragmentMoviesDetails())
            .addToBackStack(null)
            .commit()
    }

    override fun changeToFragmentList() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.persistent_container, FragmentMoviesList())
            .addToBackStack(null)
            .commit()
    }
}